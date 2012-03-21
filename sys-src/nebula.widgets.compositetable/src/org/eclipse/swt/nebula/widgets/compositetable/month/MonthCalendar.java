/*******************************************************************************
 * Copyright (c) 2006 The Pampered Chef and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The Pampered Chef - initial API and implementation
 ******************************************************************************/
package org.eclipse.swt.nebula.widgets.compositetable.month;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.compositetable.day.CalendarableItemEventHandler;
import org.eclipse.swt.nebula.widgets.compositetable.day.CalendarableSelectionChangeListener;
import org.eclipse.swt.nebula.widgets.compositetable.month.internal.Day;
import org.eclipse.swt.nebula.widgets.compositetable.month.internal.Week;
import org.eclipse.swt.nebula.widgets.compositetable.month.internal.WeekHeader;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.AbstractEventEditor;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.CalendarableItem;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.EventContentProvider;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.EventCountProvider;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.IEventEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * An IEventEditor implementing a month calendar.  This class is not intended
 * to be subclassed.
 */
public class MonthCalendar extends AbstractEventEditor implements IEventEditor {

	private Date startDate;
    private WeekHeader weekHeader = null;
    private Composite weeksHolder = null;
	private Week[] weeks;
    
	/**
	 * Constructor DayEditor.  Constructs a calendar control that can display
	 * events on one or more days.
	 * 
	 * @param parent
	 * @param style The same style bits as @see Composite
	 */
	public MonthCalendar(Composite parent, int style) {
		super(parent, style);
		initialize();
		weeks = new Week[0];
		setStartDate(new Date());
	}

	private void initialize() {
        GridLayout gl = new GridLayout();
        gl.horizontalSpacing = 0;
        gl.marginWidth = 0;
        gl.verticalSpacing = 0;
        gl.marginHeight = 0;
        createWeekHeader();
        this.setLayout(gl);
        createWeeksHolder();
	}

    /**
	 * This method initializes weekHeader	
	 *
	 */
	private void createWeekHeader() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		weekHeader = new WeekHeader(this, SWT.NONE);
		weekHeader.setLayoutData(gridData);
	}

	/**
	 * This method initializes composite	
	 *
	 */
	private void createWeeksHolder() {
		weeksHolder = new Composite(this, SWT.NONE);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 1;
		gridLayout.marginHeight = 0;
		weeksHolder.setLayout(gridLayout);
		
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		weeksHolder.setLayoutData(gd);
	}

	/**
	 * This method initializes week	
	 */
	private Week createWeek() {
		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		Week week = new Week(weeksHolder, SWT.NONE);
		week.setLayoutData(gd);
		return week;
	}
	
	/**
	 * Sets the start date for this MonthCalendar.
	 * <p>
	 * The date is set to the first day of the specified month and the time part
	 * of the Date object is set to midnight before storing. Calling
	 * {@link #getStartDate()} will return this mutilated version instead of the
	 * original.
	 * 
	 * @see org.eclipse.swt.nebula.widgets.compositetable.timeeditor.IEventEditor#setStartDate(java.util.Date)
	 */
	public void setStartDate(Date startDate) {
		checkWidget();
		
		Calendar c = new GregorianCalendar();
		c.setTime(startDate);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		this.startDate = c.getTime();
		refresh();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#getStartDate()
	 */
	public Date getStartDate() {
		checkWidget();
		
		return startDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#refresh(java.util.Date)
	 */
	public void refresh(Date date) {
		checkWidget();
		
		if (date == null) {
			refresh();
			return;
		}
		
		Calendar currentDay = new GregorianCalendar();
		currentDay.setTime(startDate);
		currentDay.set(Calendar.DAY_OF_MONTH, 1);
		currentDay.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		Calendar endDay = new GregorianCalendar();
		endDay.setTime(date);
		endDay.set(Calendar.HOUR_OF_DAY, 0);
		endDay.set(Calendar.MINUTE, 0);
		endDay.set(Calendar.SECOND, 0);
		endDay.set(Calendar.MILLISECOND, 0);
		Date targetDate = endDay.getTime();
		
		Day currentDayControl = null;
		for (int week = 0; week < weeks.length; week++) {
			for (int day = 0; day < 7; day++) {
				currentDayControl = weeks[week].getDay(day);
				
				currentDay.add(Calendar.DAY_OF_MONTH, 1);
				if (currentDay.getTime().after(targetDate)) {
					refresh(date, currentDayControl);
					return;
				}
			}
		}
	}
	
	private void refresh(Date date, Day dayControl) {
		dayControl.setDate(date);
		if (eventCountProvider == null || eventContentProvider == null) {
			return;
		}
		int numberOfEventsInDay = eventCountProvider.getNumberOfEventsInDay(date);
		CalendarableItem controls[] = new CalendarableItem[numberOfEventsInDay];
		for (int i = 0; i < controls.length; i++) {
			controls[i] = new CalendarableItem(date);
		}
		eventContentProvider.refresh(date, controls);
		dayControl.setItems(controls);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#refresh()
	 */
	public void refresh() {
		checkWidget();
		
		Calendar c = new GregorianCalendar();
		c.setTime(startDate);
		int currentMonth = c.get(Calendar.MONTH);
		
		Calendar nextMonthCalendar = new GregorianCalendar();
		nextMonthCalendar.setTime(c.getTime());
		nextMonthCalendar.add(Calendar.MONTH, 1);
		Date nextMonth = nextMonthCalendar.getTime();
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		
		LinkedList newWeeksArray = new LinkedList();
		
		for (int week = 0; c.getTime().before(nextMonth); week++) {
			if (weeks.length > week) {
				newWeeksArray.addLast(weeks[week]);
			} else {
				Week newWeek = createWeek();
				newWeeksArray.addLast(newWeek);
				for (int day=0; day < 7; day++) {
					Day newDay = newWeek.getDay(day);
					newDay.setMonthPosition(new Point(day, week));
					newDay.addKeyListener(dayKeyListener);
					newDay.addMouseListener(dayMouseListener);
					newDay.addFocusListener(dayFocusListener);
				}
			}
			for (int day = 0; day < 7; day++) {
				Day currentDay = ((Week)newWeeksArray.get(week)).getDay(day);
				currentDay.setInCurrentMonth(c.get(Calendar.MONTH) == currentMonth);
				currentDay.setDayNumber(c.get(Calendar.DAY_OF_MONTH));
				refresh(c.getTime(), currentDay);
				currentDay.layout(true);
				c.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		if (weeks.length > newWeeksArray.size()) {
			for (int extraWeek=newWeeksArray.size(); extraWeek < weeks.length; ++extraWeek) {
				weeks[extraWeek].dispose();
			}
		}
		if (weeks.length != newWeeksArray.size()) {
			weeksHolder.layout(true);
		}
		weeks = (Week[]) newWeeksArray.toArray(new Week[newWeeksArray.size()]);
	}
	
	private EventContentProvider eventContentProvider = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#setEventContentProvider(org.eclipse.jface.examples.databinding.compositetable.timeeditor.EventContentProvider)
	 */
	public void setEventContentProvider(EventContentProvider eventContentProvider) {
		checkWidget();
		
		this.eventContentProvider = eventContentProvider;
	}
	
	private EventCountProvider eventCountProvider = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#setEventCountProvider(org.eclipse.jface.examples.databinding.compositetable.timeeditor.EventCountProvider)
	 */
	public void setEventCountProvider(EventCountProvider eventCountProvider) {
		checkWidget();
		
		this.eventCountProvider = eventCountProvider;
	}

	/*
	 * NEBULA_FIXME: To be used when we support full editing
	 */
//	private boolean fireEvents(CalendarableItem calendarableItem, List handlers) {
//		CalendarableItemEvent e = new CalendarableItemEvent();
//		e.calendarableItem = calendarableItem;
//		for (Iterator iter = handlers.iterator(); iter.hasNext();) {
//			CalendarableItemEventHandler handler = (CalendarableItemEventHandler) iter.next();
//			handler.handleRequest(e);
//			if (!e.doit) {
//				break;
//			}
//		}
//		for (Iterator i = handlers.iterator(); i.hasNext();) {
//			CalendarableItemEventHandler h = (CalendarableItemEventHandler) i.next();
//			h.requestHandled(e);
//			if (!e.doit) {
//				break;
//			}
//		}
//		return e.doit;
//	}
	
	private List deleteHandlers = new ArrayList();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#addItemDeleteHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void addItemDeleteHandler(CalendarableItemEventHandler deleteHandler) {
		checkWidget();
		
		deleteHandlers.add(deleteHandler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#removeItemDeleteHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void removeItemDeleteHandler(CalendarableItemEventHandler deleteHandler) {
		checkWidget();
		
		deleteHandlers.remove(deleteHandler);
	}
	
	private List disposeHandlers = new ArrayList();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#addItemDisposeHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void addItemDisposeHandler(CalendarableItemEventHandler itemDisposeHandler) {
		checkWidget();
		
		disposeHandlers.add(itemDisposeHandler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#removeItemDisposeHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void removeItemDisposeHandler(CalendarableItemEventHandler itemDisposeHandler) {
		checkWidget();
		
		disposeHandlers.remove(itemDisposeHandler);
	}
	
	private List itemEditHandlers = new ArrayList();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#addItemEditHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void addItemEditHandler(CalendarableItemEventHandler handler) {
		checkWidget();
		
		itemEditHandlers.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#removeItemEditHandler(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableItemEventHandler)
	 */
	public void removeItemEditHandler(CalendarableItemEventHandler handler) {
		checkWidget();
		
		itemEditHandlers.remove(handler);
	}
	
	private List selectionChangeListeners = new ArrayList();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#addSelectionChangeListener(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableSelectionChangeListener)
	 */
	public void addSelectionChangeListener(CalendarableSelectionChangeListener l) {
		checkWidget();
		
		selectionChangeListeners.add(l);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#removeSelectionChangeListener(org.eclipse.jface.examples.databinding.compositetable.day.CalendarableSelectionChangeListener)
	 */
	public void removeSelectionChangeListener(CalendarableSelectionChangeListener l) {
		checkWidget();
		
		selectionChangeListeners.remove(l);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#fireDelete(org.eclipse.jface.examples.databinding.compositetable.timeeditor.CalendarableItem)
	 */
	public boolean fireDelete(CalendarableItem toDelete) {
		checkWidget();
		
		// NEBULA_TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#setTimeBreakdown(int,
	 *      int)
	 */
	public void setTimeBreakdown(int numberOfDays, int numberOfDivisionsInHour) {
		checkWidget();
		// NOOP
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#getNumberOfDays()
	 */
	public int getNumberOfDays() {
		checkWidget();
		
		// Return the number of days in the current month
		Calendar c = new GregorianCalendar();
		c.setTime(startDate);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.examples.databinding.compositetable.timeeditor.IEventEditor#getNumberOfDivisionsInHour()
	 */
	public int getNumberOfDivisionsInHour() {
		checkWidget();
		
		// NOOP
		return -1;
	}
	
	private MonthCalendarSelectedDay selectedDay = null;
	
	/**
	 * Method getSelectedDay.  Returns the currently-selected day.
	 * 
	 * @return The current MonthCalendarSelection which represents the currently-
	 * selected day.
	 */
	public MonthCalendarSelectedDay getSelectedDay() {
		checkWidget();
		
		return selectedDay;
	}
	
	private List focusListeners = new ArrayList();
	
	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when the control gains or loses focus, by sending
	 * it one of the messages defined in the <code>FocusListener</code>
	 * interface.
	 * <p>
	 * In addition, e.data in the FocusEvent is the current MonthCalendarSelectedDay.
	 *
	 * @param listener the listener which should be notified
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see FocusListener
	 * @see #removeFocusListener
	 * @see org.eclipse.swt.widgets.Control#addFocusListener(org.eclipse.swt.events.FocusListener)
	 */
	public void addFocusListener(FocusListener listener) {
		checkWidget();
		
		super.addFocusListener(listener);
		focusListeners.add(listener);
	}
	
	/**
	 * Removes the listener from the collection of listeners who will
	 * be notified when the control gains or loses focus.
	 * <p>
	 * In addition, e.data in the FocusEvent is the current MonthCalendarSelectedDay.
	 *
	 * @param listener the listener which should no longer be notified
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see FocusListener
	 * @see #addFocusListener
	 * @see org.eclipse.swt.widgets.Control#removeFocusListener(org.eclipse.swt.events.FocusListener)
	 */
	public void removeFocusListener(FocusListener listener) {
		checkWidget();
		
		super.removeFocusListener(listener);
		focusListeners.remove(listener);
	}
	
	private FocusListener dayFocusListener = new FocusListener() {
		public void focusGained(FocusEvent e) {
			Day day = (Day) e.widget;
			Point coordinates = day.getMonthPosition();
			selectedDay = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			e.data = selectedDay;
			
			for (Iterator focusListenersIter = focusListeners.iterator(); focusListenersIter.hasNext();) {
				FocusListener listener = (FocusListener) focusListenersIter.next();
				listener.focusGained(e);
			}
		}

		public void focusLost(FocusEvent e) {
			Day day = (Day) e.widget;
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			
			for (Iterator focusListenersIter = focusListeners.iterator(); focusListenersIter.hasNext();) {
				FocusListener listener = (FocusListener) focusListenersIter.next();
				listener.focusLost(e);
			}
		}
	};
	
	private List mouseListeners = new ArrayList();
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#addMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	public void addMouseListener(MouseListener listener) {
		checkWidget();
		
		super.addMouseListener(listener);
		mouseListeners.add(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#removeMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	public void removeMouseListener(MouseListener listener) {
		checkWidget();
		
		super.removeMouseListener(listener);
		mouseListeners.remove(listener);
	}
	
	private MouseListener dayMouseListener = new MouseListener() {
		private Day getDay(MouseEvent e) {
			Control control = (Control) e.widget;
			while (!(control instanceof Day)) {
				control = control.getParent();
			}
			Day day = (Day) control;
			return day;
		}
		public void mouseDown(MouseEvent e) {
			Day day = getDay(e);
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);

			for (Iterator mouseListenersIter = mouseListeners.iterator(); mouseListenersIter.hasNext();) {
				MouseListener listener = (MouseListener) mouseListenersIter.next();
				listener.mouseDown(e);
			}
		}
		public void mouseUp(MouseEvent e) {
			Day day = getDay(e);
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			
			for (Iterator mouseListenersIter = mouseListeners.iterator(); mouseListenersIter.hasNext();) {
				MouseListener listener = (MouseListener) mouseListenersIter.next();
				listener.mouseUp(e);
			}
		}
		public void mouseDoubleClick(MouseEvent e) {
			Day day = getDay(e);
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			
			for (Iterator mouseListenersIter = mouseListeners.iterator(); mouseListenersIter.hasNext();) {
				MouseListener listener = (MouseListener) mouseListenersIter.next();
				listener.mouseDoubleClick(e);
			}
		}
	};

	private List keyListeners = new ArrayList();
	
	/**
	 * Adds the listener to the collection of listeners who will
	 * be notified when keys are pressed and released on the system keyboard, by 
	 * sending it one of the messages defined in the <code>KeyListener</code>
	 * interface.
	 * <p>
	 * In addition to the usual KeyListener contract, MonthCalendar will honor
	 * e.doit and will not perform its usual key processing if any KeyListener
	 * sets e.doit to false.
	 * <p>
	 * In addition to the usual KeyEvent fields, e.data is set to the current
	 * MonthCalendarSelection.
	 *
	 * @param listener the listener which should be notified
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see org.eclipse.swt.widgets.Control#addKeyListener(org.eclipse.swt.events.KeyListener)
	 */
	public void addKeyListener(KeyListener listener) {
		checkWidget();
		
		super.addKeyListener(listener);
		keyListeners.add(listener);
	}

	/**
	 * Removes the listener from the collection of listeners who will
	 * be notified when keys are pressed and released on the system keyboard.
	 *
	 * @param listener the listener which should no longer be notified
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the listener is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_WIDGET_DISPOSED - if the receiver has been disposed</li>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
	 * </ul>
	 *
	 * @see KeyListener
	 * @see #addKeyListener
	 * @see org.eclipse.swt.widgets.Control#removeKeyListener(org.eclipse.swt.events.KeyListener)
	 */
	public void removeKeyListener(KeyListener listener) {
		checkWidget();
		
		super.removeKeyListener(listener);
		keyListeners.remove(listener);
	}

	private KeyListener dayKeyListener = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			Day day = (Day) e.widget;
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			
			for (Iterator keyListenersIter = keyListeners.iterator(); keyListenersIter.hasNext();) {
				KeyListener listener = (KeyListener) keyListenersIter.next();
				listener.keyPressed(e);
			}

			if (!e.doit) {
				return;
			}
			
			switch (e.keyCode) {
			case SWT.ARROW_UP:
				if (coordinates.y > 0) {
					Day newDay = weeks[coordinates.y-1].getDay(coordinates.x);
					newDay.setFocus();
				}
				return;
			case SWT.ARROW_DOWN:
				if (coordinates.y < weeks.length-1) {
					Day newDay = weeks[coordinates.y+1].getDay(coordinates.x);
					newDay.setFocus();
				}
				return;
			}
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
		 */
		public void keyReleased(KeyEvent e) {
			Day day = (Day) e.widget;
			Point coordinates = day.getMonthPosition();
			e.data = new MonthCalendarSelectedDay(day.getDate(), coordinates);
			
			for (Iterator keyListenersIter = keyListeners.iterator(); keyListenersIter.hasNext();) {
				KeyListener listener = (KeyListener) keyListenersIter.next();
				listener.keyReleased(e);
			}

			// No need for this logic here yet, but leaving it commented
			// as a reminder...
			
			// if (!e.doit) return;
		}
	};
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Composite#setFocus()
	 */
	public boolean setFocus() {
		checkWidget();
		
		Day newDay = weeks[0].getDay(0);
		return newDay.setFocus();
	}


} // @jve:decl-index=0:visual-constraint="10,10"
