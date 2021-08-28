/*
 * PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 15 2021
* LAST UPDATED: Aug 20 2021
 */
package getset;

import methodprinting.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class MethodPrinterTest {
   private final PrintStream standardOut = System.out;
   private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
   public MethodPrinterTest() {
   }

   @Before
   public void setUp () throws Exception
   {
      System.setOut(new PrintStream(outputStreamCaptor));
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
      MethodPrinter instance = new JavaMethodPrinter();
   MethodQueue getters = new LinkedMethodQueue();
   getters.add("Getter1");
   getters.add("Getter2");
   MethodQueue setters = new LinkedMethodQueue();
   setters.add("Setter1");
   setters.add("Setter2");
   instance.printToConsoleAlternating(getters, setters);
   Assert.assertEquals("Getter1" + 
           "\nSetter1" + "\nGetter2" + "\nSetter2", outputStreamCaptor.toString().trim());
   }

   /**
    * Test of copyToClipboard method, of class MethodPrinter.
    */
   @Test
   public void testCopyToClipboard() {
      MethodPrinter instance = new JavaMethodPrinter();
      MethodQueue getters = new LinkedMethodQueue();
   getters.add("Getter1");
   getters.add("Getter2");
   MethodQueue setters = new LinkedMethodQueue();
   setters.add("Setter1");
   setters.add("Setter2");
   instance.copyToClipboard(getters, setters);
   Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
   }

   public class MethodPrinterImpl extends MethodPrinter {

      public void printToFile(MethodQueue getters, MethodQueue setters, String filePath) {
      }
   }
   
}
