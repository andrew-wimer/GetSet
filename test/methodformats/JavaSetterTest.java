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
public class JavaSetterTest {
   
   public JavaSetterTest() {
   }

   /**
    * Test of writeSetter method, of class JavaSetter.
    */
   @Test
   public void testWriteSetter() {
      System.out.println("writeSetter");
      String identifier = "number";
      String returnType = "int";
      JavaSetter instance = new JavaSetter();
      String expResult = "\npublic void set" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "(" + returnType + " " + identifier +")" + 
              "\n{\n   this." + identifier + " = " + identifier + ";\n}\n";
      String result = instance.writeSetter(identifier, returnType);
      assertEquals(expResult, result);
   }

   /**
    * Test of writeFileFormattedSetter method, of class JavaSetter.
    */
   @Test
   public void testWriteFileFormattedSetter() {
      System.out.println("writeFileFormattedSetter");
      String identifier = "number";
      String returnType = "int";
      JavaSetter instance = new JavaSetter();
      String expResult = "\n\tpublic void set" + 
              identifier.substring(0,1).toUpperCase() + identifier.substring(1)
              + "(" + returnType + " " + identifier +")" + 
              "\n\t{\n\t\tthis." + identifier + " = " + identifier + 
              ";\n\t}\n";
      String result = instance.writeFileFormattedSetter(identifier, returnType);
      assertEquals(expResult, result);
   }
   
}
