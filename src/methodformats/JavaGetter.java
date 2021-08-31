/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 8 2021
* LAST UPDATE: Aug 27 2021
*/

package methodformats;



/**
 * CLASS DESCRIPTION: Writes a java getter from a given identifier
 * and return type.
 * @author Andrew Wimer
 * Aug 27 2021 - added extra newline escape sequence to  beginning and end
 * of each getter string
 */
public class JavaGetter implements Getter {
   
   /**
    * Default constructor.
    */
   public JavaGetter()
   {
      
   }
   
   /**
    * Generates a String form of a getter method, where only the return
    * line is tabbed.
    * @param identifier
    * @param returnType
    * @return 
    */
   @Override
   public String writeGetter(String identifier, String returnType)
   {        
      String getterString = "\npublic " + returnType + " get" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "()" + "\n{\n   return " + identifier + ";" + "\n}\n";
      
      return getterString;
   }  

   /**
    * Generates a String form of a getter method, every lined is tabbed 
    * so as to be properly formatted for adding to a standard format 
    * java class. 
    * @param identifier
    * @param returnType
    * @return 
    */
   public String writeFileFormattedGetter(String identifier, String returnType)
   {        
      String getterString = "\n\tpublic " + returnType + " get" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "()" + "\n\t{\n\t\treturn " + identifier + ";" + "\n\t}\n";
      
      return getterString;
   }
}
