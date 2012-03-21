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
package era.foss.util.types;

import java.util.Map;

/**
 * Provides a convenient class to manage tag-value options.
 * 
 * @param <X> the generic type
 * @param <Y> the generic type
 */
public class Options<X, Y> {

    //
    // private members

    /** The m_options. */
    private Map<X, Y> m_options = null;

    /**
     * Instantiates a new options.
     * 
     * @param options the options
     */
    public Options( Map<X, Y> options ) {
        m_options = options;
    }

    /**
     * Gets the options.
     * 
     * @return The options map
     */
    public Map<X, Y> getOptions() {
        return m_options;
    }

    /**
     * Checks if is option.
     * 
     * @param name the name
     * @return true if the named option exists
     */
    public boolean isOption( String name ) {
        return m_options != null && m_options.containsKey( name );
    }

    /**
     * Returns the value of a boolean option.
     * 
     * @param name The name of the option
     * @param defaultValue The default value
     * @return The value of the option or defaultValue if option is unknown or contains no boolean value
     */
    public boolean getBooleanOption( String name, boolean defaultValue ) {
        if( m_options == null ) return defaultValue;
        Object o = m_options.get( name );
        if( o == null ) return defaultValue;
        return Boolean.parseBoolean( o.toString() );
    }

    /**
     * Returns the value of a String option.
     * 
     * @param name The name of the option
     * @param defaultValue The default value
     * @return The value of the option or defaultValue if option is unknown or contains no String value
     */
    public String getStringOption( String name, String defaultValue ) {
        if( m_options == null ) return defaultValue;
        Object o = m_options.get( name );
        if( o == null ) return defaultValue;
        return o.toString();
    }

    /**
     * Returns the value of an integer option.
     * 
     * @param name The name of the option
     * @param defaultValue The default value
     * @return The value of the option or defaultValue if option is unknown or contains no integer value
     */
    public long getIntegerOption( String name, long defaultValue ) {
        if( m_options == null ) return defaultValue;
        Object o = m_options.get( name );
        if( o == null ) return defaultValue;
        try {
            return Integer.parseInt( o.toString() );
        } catch( NumberFormatException e ) {
            return defaultValue;
        }
    }

    /**
     * Returns the value of an integer option.
     * 
     * @param name The name of the option
     * @param defaultValue The default value
     * @return The value of the option or defaultValue if option is unknown or contains no integer value
     */
    public double getDoubleOption( String name, double defaultValue ) {
        if( m_options == null ) return defaultValue;
        Object o = m_options.get( name );
        if( o == null ) return defaultValue;
        try {
            // throws NullpointerException, if value is null
            return Double.parseDouble( o.toString() );
        } catch( Exception e ) {
            return defaultValue;
        }
    }

} // Options
