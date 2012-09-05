package era.foss.typeeditor.common;

import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;

/**
 * The purpose of this class is to handle the update of String values which are 'unsettable' (see
 * {@link EStructuralFeature#isUnsettable()})
 */
class UnsettableEMFUpdateValueStrategy extends EMFUpdateValueStrategy {
    /**
     * Structural feature of the observed value
     */
    private EStructuralFeature eStructuralFeature;

    /**
     * Constructor
     * 
     * @param eStructuralFeature structural feature of the value to the conversion is applied
     */
    public UnsettableEMFUpdateValueStrategy( EStructuralFeature eStructuralFeature ) {
        super();
        this.eStructuralFeature = eStructuralFeature;
    }

    @Override
    /**
     * In case the value sting is empty and the observed feature is 'unsettable' 
     * then return {@link SetCommand.UNSET_VALUE}
     * Otherwise leave the value as it is
     */
    public Object convert( Object value ) {
        if( ((String)value).isEmpty() && this.eStructuralFeature.isUnsettable() ) {
            return SetCommand.UNSET_VALUE;
        }
        return super.convert( value );
    }
}
