/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getset;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author andr00
 */
public class JavaMethodPrinterTest {
   private final PrintStream standardOut = System.out;
   private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   

   

   public JavaMethodPrinterTest() {
   }
   
   @Before
   public void setUp () throws Exception
   {
      System.setOut(new PrintStream(outputStreamCaptor));
   }

   /**
    * Test of printToFile method, of class JavaMethodPrinter.
    */
   @Test
   public void testPrintToFile() {
      
   
   }

   @After
   public void tearDown() {
      System.setOut(standardOut);
   }
   /**
    * Test of printToConsole method, of class JavaMethodPrinter.
    */
   @Test
   public void testPrintToConsole() {
      JavaMethodPrinter instance = new JavaMethodPrinter();
   MethodQueue getters = new LinkedMethodQueue();
   getters.add("Getter1");
   getters.add("Getter2");
   MethodQueue setters = new LinkedMethodQueue();
   setters.add("Setter1");
   setters.add("Setter2");
   instance.printToConsole(getters, setters);
   Assert.assertEquals("Getter1" + 
           "\nGetter2" + "\nSetter1" + "\nSetter2", outputStreamCaptor.toString().trim());
   }

   /**
    * Test of printToConsoleAlternating method, of class JavaMethodPrinter.
    */
   @Test
   public void testPrintToConsoleAlternating() {
      JavaMethodPrinter instance = new JavaMethodPrinter();
   MethodQueue getters = new LinkedMethodQueue();
   getters.add("Getter1");
   getters.add("Getter2");
   MethodQueue setters = new LinkedMethodQueue();
   setters.add("Setter1");
   setters.add("Setter2");
   instance.printToConsoleAlternating(getters, setters, true);
   Assert.assertEquals("Getter1" + 
           "\nSetter1" + "\nGetter2" + "\nSetter2", outputStreamCaptor.toString().trim());
   }

   /**
    * Test of printToClipboard method, of class JavaMethodPrinter.
    */
   @Test
   public void testCopyToClipboard() {
   }
   
}
