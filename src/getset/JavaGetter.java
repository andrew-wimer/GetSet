/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 8 2021
* LAST UPDATE: Aug 8 2021
*/

package getset;

/**
 * CLASS DESCRIPTION: Writes a java getter from a given identifier
 * and return type.
 * @author Andrew Wimer
 * 
 */
public class JavaGetter implements Getter {
   
   public JavaGetter()
   {
      
   }
   
   @Override
   public String writeGetter(String identifier, String returnType)
   {
      String getterString = "";
      
      
      getterString += "public " + returnType + " get" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "()" + "\n{\n   return " + identifier + ";" + "\n}";
      
      return getterString;
   }

}
