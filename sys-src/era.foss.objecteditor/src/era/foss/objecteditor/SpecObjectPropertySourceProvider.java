/**************************************************************************
* ERA - Eclipse Requirements Analysis
* ==============================================
* Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
* and Bernd Haberstumpf (http://era.origo.ethz.ch)
**************************************************************************
* Licensed under the Eclipse Public License - v 1.0 (the "License");
* you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
* http://www.eclipse.org/org/documents/epl-v10.html
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
**************************************************************************
* $Id: SpecObjectPropertySourceProvider.java 328 2011-06-01 22:08:48Z cpn $
*************************************************************************/
package era.foss.objecteditor;

import java.util.ArrayList;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.SpecObject;

/**
 * The Class SpecObjectPropertySourceProvider.
 */
public class SpecObjectPropertySourceProvider implements IPropertySourceProvider {

    /**
     * The Class SpecObjectPropertySource.
     */
    class SpecObjectPropertySource implements IPropertySource {
        
        /**
         * The Class SpecObjectPropertyId.
         */
        class SpecObjectPropertyId{
            
            /** The spec object. */
            private SpecObject specObject;
            
            /** The attribute definition. */
            private AttributeDefinition attributeDefinition;
            
            /**
             * Instantiates a new spec object property id.
             * 
             * @param specObject the spec object
             * @param attributeDefinition the attribute definition
             */
            public SpecObjectPropertyId(SpecObject specObject, AttributeDefinition attributeDefinition) {
                SpecObjectPropertyId.this.specObject = specObject;
                SpecObjectPropertyId.this.attributeDefinition = attributeDefinition;
            }

            /**
             * Gets the spec object.
             * 
             * @return the spec object
             */
            public SpecObject getSpecObject() {
                return specObject;
            }
            
            /**
             * Gets the attribute definition.
             * 
             * @return the attribute definition
             */
            public AttributeDefinition getAttributeDefinition() {
                return attributeDefinition;
            }
        }
        
        /** The spec object. */
        private SpecObject specObject;

        /**
         * Instantiates a new spec object property source.
         * 
         * @param specObject the spec object
         */
        public SpecObjectPropertySource( SpecObject specObject ) {
            this.specObject = specObject;
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
         */
        @Override
        public Object getEditableValue() {
            // Auto-generated method stub
            return null;
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
         */
        @Override
        public IPropertyDescriptor[] getPropertyDescriptors() {
            ArrayList<IPropertyDescriptor> propertyDescriptors = new ArrayList<IPropertyDescriptor>();

            for( AttributeDefinition attributeDefinition : specObject.getType().getSpecAttributes() ) {
                PropertyDescriptor newPropertyDescriptor = new PropertyDescriptor( new SpecObjectPropertyId( specObject, attributeDefinition ), attributeDefinition.getLongName() );
                newPropertyDescriptor.setDescription( attributeDefinition.getDesc() );
                propertyDescriptors.add( newPropertyDescriptor );
            }

            return propertyDescriptors.toArray( new PropertyDescriptor[propertyDescriptors.size()] );
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
         */
        @Override
        public Object getPropertyValue( Object object ) {
            SpecObject specObject = ((SpecObjectPropertyId)object).getSpecObject();
            AttributeDefinition attributeDefinition = ((SpecObjectPropertyId)object).getAttributeDefinition();

            // find value according to attribute definition
            for( AttributeValue specObjectValue : specObject.getValues() ) {
                if( specObjectValue instanceof AttributeValueSimple &&
                 ((AttributeValueSimple)specObjectValue).getDefinition().equals( attributeDefinition ) ) {
                        return ((AttributeValueSimple)specObjectValue).getTheValue();
                }
            }
            
            // in case we did not find a value try to use the default value
            if( (attributeDefinition instanceof AttributeDefinitionSimple)
                && (((AttributeDefinitionSimple)attributeDefinition).getDefaultValue() != null) ) {
                return ((AttributeDefinitionSimple)attributeDefinition).getDefaultValue().getTheValue();
            }

            return null;
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
         */
        @Override
        public boolean isPropertySet( Object id ) {
            // Auto-generated method stub
            return false;
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
         */
        @Override
        public void resetPropertyValue( Object id ) {
            // Auto-generated method stub
        }

        /* (non-Javadoc)
         * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
         */
        @Override
        public void setPropertyValue( Object id, Object value ) {
            // Auto-generated method stub
        }

    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.views.properties.IPropertySourceProvider#getPropertySource(java.lang.Object)
     */
    @Override
    public IPropertySource getPropertySource( Object object ) {
        // stop processing if we don't have a spec object
        if( !(object instanceof SpecObject) ) {
            return null;
        }
        return new SpecObjectPropertySource( (SpecObject)object );
    }

}
