/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 8 2021
* LAST UPDATE: Aug 23 2021
*/

package getset;

/**
 * CLASS DESCRIPTION: Represents a Java setter method in the form of a string.
 * @author Andrew Wimer
 * 
 */
public class JavaSetter implements Setter {
   
   /**
    * Default constructor.
    */
   public JavaSetter()
   {
      
   }
   
   /**
    * Generates a String form of a setter method, where only the return
    * line is tabbed.
    * @param identifier
    * @param returnType
    * @return 
    */
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
   
   /**
    * Generates a String form of a getter method, every lined is tabbed 
    * so as to be properly formatted for adding to a standard format 
    * java class. 
    * @param identifier
    * @param returnType
    * @return 
    */
   public String writeFileFormattedSetter(String identifier, String returnType)
   {
      String setterString = "";
      
      
      setterString += "\tpublic void set" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "(" + returnType + " " + identifier +")" + 
              "\n\t{\n\t\tthis." + identifier + " = " + identifier + ";\n\t}";
      
      return setterString;
   }
}
