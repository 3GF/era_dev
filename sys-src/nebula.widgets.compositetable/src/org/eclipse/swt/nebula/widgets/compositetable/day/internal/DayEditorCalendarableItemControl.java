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

package org.eclipse.swt.nebula.widgets.compositetable.day.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.nebula.widgets.compositetable.day.ICalendarableItemControl;
import org.eclipse.swt.nebula.widgets.compositetable.timeeditor.CalendarableItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Widget;

/**
 * Represents a graphical item inside a multi-day event editor.
 * 
 * @since 3.2
 */
public class DayEditorCalendarableItemControl extends Canvas implements ICalendarableItemControl  {

	private static final int MARGIN = 3;
	private Label label = null;
	private Color BORDER_COLOR;
	private Color SELECTED_BORDER_COLOR;
	private Color BACKGROUND_COLOR;
	private Color SELECTED_BACKGROUND_COLOR;

   /**
	 * Constructs a new instance of this class given its parent
	 * and a style value describing its behavior and appearance.
	 * <p>
	 * The style value is either one of the style constants defined in
	 * class <code>SWT</code> which is applicable to instances of this
	 * class, or must be built by <em>bitwise OR</em>'ing together 
	 * (that is, using the <code>int</code> "|" operator) two or more
	 * of those <code>SWT</code> style constants. The class description
	 * lists the style constants that are applicable to the class.
	 * Style bits are also inherited from superclasses.
	 * </p>
	 *
	 * @param parent a composite control which will be the parent of the new instance (cannot be null)
	 * @param style the style of control to construct
	 *
	 * @exception IllegalArgumentException <ul>
	 *    <li>ERROR_NULL_ARGUMENT - if the parent is null</li>
	 * </ul>
	 * @exception SWTException <ul>
	 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the parent</li>
	 *    <li>ERROR_INVALID_SUBCLASS - if this class is not an allowed subclass</li>
	 * </ul>
	 *
	 * @see Widget#checkSubclass
	 * @see Widget#getStyle
	 */
	public DayEditorCalendarableItemControl(Composite parent, int style) {
		super(parent, style);
		Display display = parent.getDisplay();

		BACKGROUND_COLOR = new Color(display, lighten(saturate(display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT).getRGB(), .08f), .3f));
		BORDER_COLOR = new Color(display, lighten(saturate(display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND).getRGB(), .18f), .1f));
		SELECTED_BACKGROUND_COLOR = display.getSystemColor(SWT.COLOR_WHITE);
		SELECTED_BORDER_COLOR = new Color(display, saturate(BORDER_COLOR.getRGB(), .4f));

		initialize();
	}
	
	/**
	 * Sets the color's saturation to the specified value.
	 * 
	 * @param color The RGB of the color
	 * @param saturation the new saturation (between 0 and 1)
	 * @return a Color that is saturated by the specified amount
	 */
	private RGB saturate(RGB color, float saturation) {
		float[] hsb = color.getHSB();
		return new RGB(hsb[0], saturation, hsb[2]);
	}
	
	/**
	 * @param color The RGB of the color
	 * @param amount The amount to lighten as a percentage expresssed as a float between -1 and 1.
	 * @return The new RGB that is lightened by the specified amount
	 */
	private RGB lighten(RGB color, float amount) {
		float[] hsb = color.getHSB();
		float b = hsb[2] + hsb[2] * amount;
		if (b < 0) b=0;
		if (b > 1) b=1;
		return new RGB(hsb[0], hsb[1], b);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#dispose()
	 */
	public void dispose() {
		super.dispose();
		BORDER_COLOR.dispose();
		BACKGROUND_COLOR.dispose();
		SELECTED_BORDER_COLOR.dispose();
//		SELECTED_BACKGROUND_COLOR.dispose();
	}

	/**
	 * Create the event control's layout
	 */
	private void initialize() {
		setBackground(BACKGROUND_COLOR);
        label = new Label(this, SWT.WRAP);
        label.setText("Label");
        label.setBackground(BACKGROUND_COLOR);
        FillLayout fillLayout = new FillLayout();
        fillLayout.marginHeight = MARGIN;
        fillLayout.marginWidth = MARGIN;
        setBackground(BORDER_COLOR);
        setLayout(fillLayout);
        addPaintListener(paintListener);
        label.addMouseListener(labelMouseListener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#setMenu(org.eclipse.swt.widgets.Menu)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setMenu(org.eclipse.swt.widgets.Menu)
	 */
	public void setMenu(Menu menu) {
		super.setMenu(menu);
		label.setMenu(menu);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setText(java.lang.String)
	 */
	public void setText(String text) {
		if (text == null) {
			text = "";
			Exception e = new Exception("Warning: setText(null) not permitted--changing to empty string");
			System.err.println(e);
//			Policy.getLog().log(
//					new Status(IStatus.WARNING, Policy.JFACE, IStatus.ERROR,
//							"setText(null) not permitted--changing to empty string", e));
		}
		label.setText(text);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setImage(org.eclipse.swt.graphics.Image)
	 */
	public void setImage(Image image) {
		label.setImage(image);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setToolTipText(java.lang.String)
	 */
	public void setToolTipText(String text) {
		super.setToolTipText(text);
		label.setToolTipText(text);
	}

	private int clipping;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setClipping(int)
	 */
	public void setClipping(int clipping) {
		this.clipping = clipping;
		redraw();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#getClipping()
	 */
	public int getClipping() {
		return clipping;
	}
	
	private int continued;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setContinued(int)
	 */
	public void setContinued(int continued) {
		this.continued = continued;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#getContinued()
	 */
	public int getContinued() {
		return continued;
	}
	
	private PaintListener paintListener = new PaintListener() {
		public void paintControl(PaintEvent e) {
			Rectangle bounds = getBounds();
			Color savedForeground = e.gc.getForeground();
			Color savedBackground = e.gc.getBackground();
			if ((continued & SWT.TOP) != 0 && (clipping & SWT.TOP) == 0) {
				e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
				e.gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
			} else {
				e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
				e.gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
			}
			if ((clipping & SWT.TOP) != 0 || (continued & SWT.TOP) != 0) {
				for (int arrow = MARGIN; arrow < bounds.width - 2*MARGIN; arrow += 2*MARGIN + 3) {
					int[] arrowPoints = new int[] {arrow, MARGIN-1, arrow + MARGIN, 0, arrow + 2 * MARGIN, MARGIN-1};
					e.gc.fillPolygon(arrowPoints);
					e.gc.drawPolygon(arrowPoints);
				}
			}
			if ((continued & SWT.BOTTOM) != 0 && (clipping & SWT.BOTTOM) == 0) {
				e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
				e.gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
			} else {
				e.gc.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
				e.gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
			}
			if ((clipping & SWT.BOTTOM) != 0 || (continued & SWT.BOTTOM) != 0) {
				int bottom = bounds.height-1;
				int marginBottom = bounds.height - MARGIN;
				for (int arrow = MARGIN; arrow < bounds.width - 2*MARGIN; arrow += 2*MARGIN + 3) {
					int[] arrowPoints = new int[] {arrow, marginBottom, arrow + MARGIN, bottom, arrow + 2 * MARGIN, marginBottom};
					e.gc.fillPolygon(arrowPoints);
					e.gc.drawPolygon(arrowPoints);
				}
			}
			e.gc.setForeground(savedForeground);
			e.gc.setBackground(savedBackground);
		}
	};

	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setSelected(boolean)
	 */
	public void setSelected(boolean selected) {
		if (selected) {
			setBackground(SELECTED_BORDER_COLOR);
			label.setBackground(SELECTED_BACKGROUND_COLOR);
		} else {
			setBackground(BORDER_COLOR);
			label.setBackground(BACKGROUND_COLOR);
		}
	}
	
	private List mouseListeners = new LinkedList();
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#addMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#addMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	public void addMouseListener(MouseListener listener) {
		super.addMouseListener(listener);
		mouseListeners.add(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Control#removeMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#removeMouseListener(org.eclipse.swt.events.MouseListener)
	 */
	public void removeMouseListener(MouseListener listener) {
		super.removeMouseListener(listener);
		mouseListeners.remove(listener);
	}
	
	private MouseListener labelMouseListener = new MouseListener() {
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDoubleClick(MouseEvent e) {
			e.widget = DayEditorCalendarableItemControl.this;
			for (Iterator listenerIter = mouseListeners.iterator(); listenerIter.hasNext();) {
				MouseListener l = (MouseListener) listenerIter.next();
				l.mouseDoubleClick(e);
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseDown(MouseEvent e) {
			e.widget = DayEditorCalendarableItemControl.this;
			for (Iterator listenerIter = mouseListeners.iterator(); listenerIter.hasNext();) {
				MouseListener l = (MouseListener) listenerIter.next();
				l.mouseDown(e);
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
		 */
		public void mouseUp(MouseEvent e) {
			e.widget = DayEditorCalendarableItemControl.this;
			for (Iterator listenerIter = mouseListeners.iterator(); listenerIter.hasNext();) {
				MouseListener l = (MouseListener) listenerIter.next();
				l.mouseUp(e);
			}
		}
	};

	private CalendarableItem calendarable;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#setCalendarableItem(org.eclipse.jface.examples.databinding.compositetable.timeeditor.CalendarableItem)
	 */
	public void setCalendarableItem(CalendarableItem calendarable) {
		this.calendarable = calendarable;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.examples.databinding.compositetable.day.internal.ICalendarableItemControl#getCalendarableItem()
	 */
	public CalendarableItem getCalendarableItem() {
		return calendarable;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
