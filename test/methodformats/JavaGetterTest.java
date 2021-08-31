/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 30 2021
* LAST UPDATE: Aug 30 2021
*/
package methodformats;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class JavaGetterTest {
   
   public JavaGetterTest() {
   }

   /**
    * Test of writeGetter method, of class JavaGetter.
    */
   @Test
   public void testWriteGetter() {
      System.out.println("writeGetter");
      String identifier = "number";
      String returnType = "int";
      JavaGetter instance = new JavaGetter();
      String expResult = "\npublic " + returnType + " get" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "()" + "\n{\n   return " + identifier + ";" + "\n}\n";
      String result = instance.writeGetter(identifier, returnType);
      assertEquals(expResult, result);
   }

   /**
    * Test of writeFileFormattedGetter method, of class JavaGetter.
    */
   @Test
   public void testWriteFileFormattedGetter() {
      System.out.println("writeFileFormattedGetter");
      String identifier = "number";
      String returnType = "int";
      JavaGetter instance = new JavaGetter();
      String expResult = "\n\tpublic " + returnType + " get" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "()" + "\n\t{\n\t\treturn " + identifier + ";" + "\n\t}\n";
      String result = instance.writeFileFormattedGetter(identifier, returnType);
      assertEquals(expResult, result);
   }
   
}
