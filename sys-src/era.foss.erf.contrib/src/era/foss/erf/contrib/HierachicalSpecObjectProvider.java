package era.foss.erf.contrib;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.common.notify.impl.NotifierImpl;
import org.eclipse.emf.common.notify.impl.NotifyingListImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EContentAdapter;

import era.foss.erf.ErfPackage;
import era.foss.erf.SpecHierarchy;
import era.foss.erf.SpecObject;
import era.foss.erf.Specification;

public class HierachicalSpecObjectProvider implements Notifier {

    /** Specification holding the SpecObjects */
    Specification specification;

    /** list holding all the spec objects of the given {@link specification} */
    NotifyingList<SpecObject> specObjectList;

    EContentAdapter contentAdapter;

    NotifierImpl notifier;

    public HierachicalSpecObjectProvider( Specification specification ) {

        this.notifier = new NotifierImpl();
        this.specification = specification;

        specObjectList = new NotifyingListImpl<SpecObject>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getNotifier() {
                return HierachicalSpecObjectProvider.this;
            }

            @Override
            public Object getFeature() {
                return ErfPackage.Literals.SPECIFICATION;
            }

            public int getFeatureID() {
                return ErfPackage.SPECIFICATION;
            }
        };

        gatherSpecObjects( HierachicalSpecObjectProvider.this.specification, specObjectList );

        this.contentAdapter = new EContentAdapter() {
            @Override
            public void notifyChanged( Notification notification ) {
                super.notifyChanged( notification );
                specObjectList.clear();
                gatherSpecObjects( HierachicalSpecObjectProvider.this.specification, specObjectList );
                HierachicalSpecObjectProvider.this.eNotify( notification );
            }
        };
        specification.eAdapters().add( contentAdapter );

    }

    public NotifyingList<SpecObject> getSpecObjectList() {

        return specObjectList;
    }

    /**
     * Travers tree of SpecHierarchy elements and gather the referred SpecObjects
     * 
     * @param specHierarchy the current SpecHierarchy element
     * @param specObjectList the list where the SpecObject are aggreated
     */
    private void gatherSpecObjects( SpecHierarchy specHierarchy, NotifyingList<SpecObject> specObjectList ) {
        SpecObject specObject = specHierarchy.getObject();
        if( specObject != null ) {
            specObjectList.add( specHierarchy.getObject() );
        }

        // traverse the tree
        EList<SpecHierarchy> specHierarchyChildList = specHierarchy.getChildren();
        if( !specHierarchyChildList.isEmpty() ) {
            for( SpecHierarchy specHierarchyChild : specHierarchyChildList ) {
                gatherSpecObjects( specHierarchyChild, specObjectList );
            }
        }
    }

    private void gatherSpecObjects( Specification specification, NotifyingList<SpecObject> specObjectList ) {
        for( SpecHierarchy specHierarchyChild : specification.getChildren() ) {
            this.gatherSpecObjects( specHierarchyChild, specObjectList );
        }
    }

    @Override
    public EList<Adapter> eAdapters() {
        return notifier.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return notifier.eDeliver();
    }

    @Override
    public void eSetDeliver( boolean deliver ) {
        notifier.eSetDeliver( deliver );
    }

    @Override
    public void eNotify( Notification notification ) {
        notifier.eNotify( notification );
    }

    public void dispose() {
        specification.eAdapters().remove( contentAdapter );
    }

}
