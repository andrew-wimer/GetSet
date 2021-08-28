/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getset;

import methodformats.JavaGetter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andr00
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
      JavaGetter jg = new JavaGetter();
      String expResult = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      String result = jg.writeGetter(identifier, returnType);
      assertEquals(expResult, result);
   }
   
}
