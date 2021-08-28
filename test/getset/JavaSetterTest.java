/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getset;

import methodformats.JavaSetter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andr00
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
      JavaSetter js = new JavaSetter();
      String expResult = "public void setNumber(int number)\n" +
      "{\n" + "   this.number = number;\n" + "}";
      String result = js.writeSetter(identifier, returnType);
      assertEquals(expResult, result);
   }
   
}
