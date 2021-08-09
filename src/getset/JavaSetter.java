/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON:
* LAST UPDATE: 
*/

package getset;

/**
 * CLASS DESCRIPTION:
 * @author Andrew Wimer
 * 
 */
public class JavaSetter implements Setter {
   
   @Override
   public String writeSetter(String identifier, String returnType)
   {
      String setterString = "";
      
      
      setterString += "public void set" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "(" + returnType + " " + identifier +")" + 
              "\n{\n   this." + identifier + " = " + identifier + ";\n}";
      
      return setterString;
   }

}
