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

/**
 * Helper functions for string manipulation.
 * 
 * @author poldi
 */
public class StringUtils {

    /**
     * Converts first letter of a string to upper case.
     * 
     * @param value the string
     * @return the converted string
     * @since Jun 14, 2009
     */
    public static String fcUpper( String value ) {
        return fcConvert( value, true );
    }

    /**
     * Converts first letter of a string to lower case.
     * 
     * @param value the string
     * @return the converted string
     * @since Jun 14, 2009
     */
    public static String fcLower( String value ) {
        return fcConvert( value, false );
    }

    /**
     * Converts first letter of a string to upper or lower case.
     * 
     * @param value the string
     * @param upper true for upper case
     * @return the converted string
     * @since Jun 14, 2009
     */
    private static String fcConvert( String value, boolean upper ) {
        if( value == null || "".equals( value ) ) return value;
        StringBuilder b = new StringBuilder( Character.toString( upper
            ? Character.toUpperCase( value.charAt( 0 ) )
            : Character.toLowerCase( value.charAt( 0 ) ) ) );
        if( value.length() > 1 ) b.append( value.substring( 1 ) );
        return b.toString();
    }

} // StringUtils
