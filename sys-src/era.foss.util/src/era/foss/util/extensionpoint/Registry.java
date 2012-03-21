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
* $Id$
*************************************************************************/

package era.foss.util.extensionpoint;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import era.foss.util.types.StringUtils;

/**
 * This is the base class for all extension-point registries used by era to manage its extension-points.
 * 
 * <p>
 * To create an extension-point registry the parses an extension-point create a class that provides get/setter methods
 * for relevant attributes of the extension. This class must create a singleton instance of the {@lnink Registry} class
 * which is used for parsing the extension-point:
 * </p>
 * 
 * <pre>
 * public class MyExtensionPointRegistry {
 * 
 *     public static final String EXTENSION_POINT = &quot;era.foss.myextension&quot;;
 * 
 *     private static final Registry&lt;MyExtensionPointRegistry&gt; registry = new Registry&lt;MyExtensionPointRegistry&gt;();
 * 
 *     private static Map&lt;String, MyExtensionPointRegistry&gt; byId = new HashMap&lt;String, MyExtensionPointRegistry&gt;();
 * 
 *     private String id = null;
 * 
 *     public static Set&lt;MyExtensionPointRegistry&gt; getRegistrations() {
 *         return registry.getRegistrations( MyExtensionPointRegistry.class, EXTENSION_POINT );
 *     }
 * 
 *     public static void putId( String id, MyExtensionPointRegistry registration ) {
 *         byId.put( id, registration );
 *     }
 * 
 *     public static MyExtensionPointRegistry getById( String id ) {
 *         registry.getRegistrations( MyExtensionPointRegistry.class, EXTENSION_POINT );
 *         return byId.get( id );
 *     }
 * 
 *     public void setId( String id ) {
 *         this.id = id;
 *     }
 * 
 *     public String getId() {
 *         return id;
 *     }
 * }
 * </pre>
 * 
 * @param <T> the generic type
 * @author poldi
 */
public class Registry<T> {

    //
    // defines

    /** Method prefix for the method under which to register by id. */
    public static final String PUT_METHOD_PREFIX = "put";

    /** Method prefix for the methods via which to set attributes. */
    public static final String SET_METHOD_PREFIX = "set";

    /** Method prefix for the add methods. */
    public static final String ADD_METHOD_PREFIX = "add";

    //
    // private members

    /** The id-attribute to id method mappings parsed via reflection. */
    private Map<String, Method> idMethods = null;

    /**
     * All parsed registries, null when extension-point is not yet parsed.
     */
    private Set<T> registrations = null;

    /** Instance of an executable extension. */
    private Object instance = null;


    /**
     * This method is to be called to parse the extension-point.
     * 
     * @param type The type of the toplevel object
     * @param extensionPoint the extension-point id
     * @return the registrations
     * @throws IllegalStateException the illegal state exception
     * @throws IllegalArgumentException the illegal argument exception
     * @since Jun 14, 2009
     */
    public Set<T> getRegistrations( Class<T> type, String extensionPoint )
        throws IllegalStateException,
        IllegalArgumentException {
        
        Assert.isNotNull( type );
        Assert.isNotNull( extensionPoint );
        if( registrations != null ) return registrations;

        registrations = new HashSet<T>();
        for( IConfigurationElement element : ExtensionUtils.getConfigurationElementsForPoint( extensionPoint ) ) {
            T registration = parseExtension( type, element );
            if( registration == null ) continue;
            registrations.add( registration );
        }

        return registrations;
    }
    
    /**
     * Creates an instance of an executable extension.
     * 
     * @param element The parent element
     * @param tag The tag of the executable extension      
     * @param type The type of the instance
     * @param singleton true to make singletons
     * @return the instance
     * @since Jun 14, 2009
     */
    public Object instantiate( IConfigurationElement element, String tag, Class<?> type, boolean singleton ) {
        if( singleton && instance != null ) return instance;
        
        Object o;
        try {
            o = element.createExecutableExtension( tag );
        } catch( CoreException e ) {
            throw new IllegalStateException( "Failed to create adapter factory for extension "
                + ExtensionUtils.getExtensionId( element ), e );
        }
        if( o == null ) {
            throw new IllegalStateException( "Failed to create adapter factory for extension "
                + ExtensionUtils.getExtensionId( element ) );
        }
        if( !type.isInstance( o ) ) {
            throw new IllegalStateException( o.getClass().getSimpleName()
                + " must extend "
                + type.getSimpleName() );
        }

        return o;
    }
    
    /*
     * Parses the top level element of the extension-point.
     * 
     * @param type The type to create
     * 
     * @param element the top level XML tag
     * 
     * @return the create element
     * 
     * @since Jun 14, 2009
     */
    /**
     * Parses the extension.
     * 
     * @param type the type
     * @param element the element
     * @return the t
     * @throws IllegalStateException the illegal state exception
     * @throws IllegalArgumentException the illegal argument exception
     */
    @SuppressWarnings("unchecked")
    private T parseExtension( Class<T> type, IConfigurationElement element )
        throws IllegalStateException,
        IllegalArgumentException {

        // Create element
        T registration = (T)create( type, element );

        // Set attributes
        Map<String, Method> attributeMethods = getAttributeMethods( type );
        for( Map.Entry<String, Method> entry : attributeMethods.entrySet() ) {
            String value = ExtensionUtils.getAttribute( element, entry.getKey(), (String)null );
            if( value == null || "".equals( value ) ) continue;
            setAttribute( attributeMethods, registration, entry.getKey(), value );
        }

        // Create sub objects
        Map<String, Method> addMethods = getElementMethods( type );
        for( Map.Entry<String, Method> entry : addMethods.entrySet() ) {
            for( IConfigurationElement subElement : element.getChildren( entry.getKey() ) ) {
                Object subType = parseSubElement( registration, entry.getValue().getParameterTypes()[0], subElement );
                addElement( addMethods, registration, entry.getKey(), subType );
            }
        }

        // Set ids
        Map<String, Method> idMethods = getIdMethods( type );
        for( Map.Entry<String, Method> entry : idMethods.entrySet() ) {
            String value = ExtensionUtils.getAttribute( element, entry.getKey(), (String)null );
            if( value == null || "".equals( value ) ) continue;
            putId( registration, entry.getKey(), value );
        }

        return registration;
    }

    /**
     * Parses a sub element (XML-tag) into a sub class.
     * 
     * @param parent The parent object
     * @param type The sub type
     * @param element the element to transform
     * @return the sub object
     * @throws IllegalStateException the illegal state exception
     * @throws IllegalArgumentException the illegal argument exception
     * @since Jun 14, 2009
     */
    private Object parseSubElement( Object parent, Class<?> type, IConfigurationElement element )
        throws IllegalStateException,
        IllegalArgumentException {

        // Create sub element
        Object object = create( type, element );

        // Set attributes
        Map<String, Method> attributeMethods = getAttributeMethods( type );
        for( Map.Entry<String, Method> entry : attributeMethods.entrySet() ) {
            String value = ExtensionUtils.getAttribute( element, entry.getKey(), (String)null );
            if( value == null || "".equals( value ) ) continue;
            setAttribute( attributeMethods, object, entry.getKey(), value );
        }

        // Create sub objects
        Map<String, Method> addMethods = getElementMethods( type );
        for( Map.Entry<String, Method> entry : addMethods.entrySet() ) {
            for( IConfigurationElement subElement : element.getChildren( entry.getKey() ) ) {
                Object subType = parseSubElement( object, entry.getValue().getParameterTypes()[0], subElement );
                addElement( addMethods, object, entry.getKey(), subType );
            }
        }

        return object;
    }

    /**
     * Creates an instance of type passing element to the constructor if a respective constructor exists.
     * 
     * @param type The type to create
     * @param element the element to pass
     * @return the new object
     * @since Jun 14, 2009
     */
    private Object create( Class<?> type, IConfigurationElement element ) {
        Constructor<?> constructor;
        try {
            constructor = type.getConstructor( new Class<?>[]{IConfigurationElement.class} );
            if( constructor == null ) throw new Exception();
            return constructor.newInstance( element );
        } catch( Exception e ) {
        }
        try {
            constructor = type.getConstructor();
            if( constructor == null ) throw new Exception();
            return constructor.newInstance();
        } catch( Exception e ) {
        }
        throw new IllegalStateException( "Cannot instantiate " + type.getName() );
    }

    /**
     * Get the attribute names and method for id attributes.
     * 
     * @param registrationType The type of the registry
     * @return Map with attribute name to method call on registrationType
     * @since Jun 14, 2009
     */
    private Map<String, Method> getIdMethods( Class<T> registrationType ) {
        if( idMethods != null ) return idMethods;
        idMethods = new HashMap<String, Method>();
        for( Method method : registrationType.getMethods() ) {
            if( !method.getName().startsWith( PUT_METHOD_PREFIX ) ) continue;
            if( (method.getModifiers() & Modifier.STATIC) == 0 ) continue;
            if( method.getParameterTypes().length != 2 ) continue;
            if( !method.getParameterTypes()[0].getClass().equals( String.class ) ) continue;
            if( !method.getParameterTypes()[1].getClass().equals( registrationType ) ) continue;

            String attributeName = StringUtils.fcLower( method.getName().substring( 3 ) );
            idMethods.put( attributeName, method );
        }

        return idMethods;
    }

    /**
     * Makes a registration of the registry by id.
     * 
     * @param registration the registration to call the registration on
     * @param attributeName The name of the id attribute
     * @param id the id value
     * @throws IllegalArgumentException in case the attribute is unknown
     * @throws IllegalStateException in case the method call to the put method does not work
     * @since Jun 14, 2009
     */
    @SuppressWarnings("unchecked")
    private void putId( T registration, String attributeName, String id )
        throws IllegalArgumentException,
        IllegalStateException {

        Method method = getIdMethods( (Class<T>)registration.getClass() ).get( attributeName );
        if( method == null ) throw new IllegalArgumentException( "Unknown ID Attribute " + attributeName );
        try {
            method.invoke( null, new Object[]{id, registration} );
        } catch( Exception e ) {
            throw new IllegalStateException( e );
        }
    }

    /**
     * Get the attribute names and method for attributes.
     * 
     * @param type the type on which to set attributes
     * @return Map with attribute name to method call on type
     * @since Jun 14, 2009
     */
    private Map<String, Method> getAttributeMethods( Class<?> type ) {
        Map<String, Method> attributeMethods = new HashMap<String, Method>();
        for( Method method : type.getMethods() ) {
            if( !method.getName().startsWith( SET_METHOD_PREFIX ) ) continue;
            if( method.getParameterTypes().length != 1 ) continue;

            String attributeName = StringUtils.fcLower( method.getName().substring( 3 ) );
            attributeMethods.put( attributeName, method );
        }

        return attributeMethods;
    }

    /**
     * set an attribute.
     * 
     * @param attributeMethods the attribute method to call
     * @param element the element to add to
     * @param attributeName the name of the attribute
     * @param value the attribute value
     * @throws IllegalArgumentException in case the attribute is unknown
     * @throws IllegalStateException in case the method call to the put method does not work
     * @since Jun 14, 2009
     */
    private void setAttribute( Map<String, Method> attributeMethods,
                               Object element,
                               String attributeName,
                               String value ) throws IllegalArgumentException, IllegalStateException {

        Method method = attributeMethods.get( attributeName );
        if( method == null ) throw new IllegalArgumentException( "Unknown attribute " + attributeName );
        try {
            method.invoke( element, new Object[]{convertValue( method.getParameterTypes()[0], value )} );
        } catch( Exception e ) {
            throw new IllegalStateException( e );
        }
    }

    /**
     * Get the element names and method for sub elements.
     * 
     * @param type the type on which to set attributes
     * @return Map with element name to method call on type
     * @since Jun 14, 2009
     */
    private Map<String, Method> getElementMethods( Class<?> type ) {
        Map<String, Method> addMethods = new HashMap<String, Method>();
        for( Method method : type.getMethods() ) {
            if( !method.getName().startsWith( ADD_METHOD_PREFIX ) ) continue;
            if( method.getParameterTypes().length != 1 ) continue;

            String elementName = StringUtils.fcLower( method.getName().substring( 3 ) );
            addMethods.put( elementName, method );
        }

        return addMethods;
    }

    /**
     * Adds a sub element.
     * 
     * @param addMethods methods via which to add sub elements.
     * @param element the element to add to
     * @param elementName The name of the sub element
     * @param subElement the sub element t add
     * @throws IllegalArgumentException in case the attribute is unknown
     * @throws IllegalStateException in case the method call to the put method does not work
     * @since Jun 14, 2009
     */
    private void addElement( Map<String, Method> addMethods, Object element, String elementName, Object subElement )
        throws IllegalArgumentException,
        IllegalStateException {

        Method method = addMethods.get( elementName );
        if( method == null ) throw new IllegalArgumentException( "Unknown element " + elementName );
        try {
            method.invoke( element, new Object[]{subElement} );
        } catch( Exception e ) {
            throw new IllegalStateException( e );
        }
    }

    /**
     * Converts a string value to a simple type.
     * 
     * @param type The type to convert to
     * @param value the string value
     * @return the converted value
     * @throws IllegalArgumentException the illegal argument exception
     * @since Jun 14, 2009
     */
    private Object convertValue( Class<?> type, String value ) throws IllegalArgumentException {
        if( boolean.class.equals( type ) ) return Boolean.valueOf( value );
        if( long.class.equals( type ) ) return Long.valueOf( value );
        if( int.class.equals( type ) ) return Integer.valueOf( value );
        if( double.class.equals( type ) ) return Double.valueOf( value );
        if( float.class.equals( type ) ) return Float.valueOf( value );
        if( char.class.equals( type ) ) return value != null && value.length() >= 0
            ? Character.valueOf( value.charAt( 0 ) )
            : null;
        if( byte.class.equals( type ) ) return Byte.valueOf( value );
        if( short.class.equals( type ) ) return Short.valueOf( value );
        return value;
    }

} // AbstractRegistry
