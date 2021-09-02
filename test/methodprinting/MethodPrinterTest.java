/*
 * PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 15 2021
* LAST UPDATED: Aug 20 2021
 */
package methodprinting;

import methodprinting.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests methods in the method printer abstract class.
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class MethodPrinterTest {
   //the standardOut printstream is a reference to the System.out stream
   private final PrintStream standardOut = System.out;
   private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
   public MethodPrinterTest() {
   }

   /**
    * outputStreamCaptor PrintStream captures the System.out stream that would
    * normally print to console with System.out.println() 
    * @throws Exception 
    */
   @Before
   public void setUp () throws Exception
   {
      System.setOut(new PrintStream(outputStreamCaptor));
   }
   
   /**
    * Returns the system output stream to the standard output stream
    */
   @After
   public void tearDown() {
      System.setOut(standardOut);
   }
   /**
    * Test of printToConsole method, of class JavaMethodPrinter.
    */
   @Test
   public void testPrintToConsole() {
      MethodPrinter instance = new JavaMethodPrinter();
   MethodQueue getters = new LinkedMethodQueue();
   getters.add("Getter1");
   getters.add("Getter2");
   MethodQueue setters = new LinkedMethodQueue();
   setters.add("Setter1");
   setters.add("Setter2");
   instance.printToConsole(getters, setters);
   String result = outputStreamCaptor.toString().trim();
   Assert.assertEquals("Getter1" + 
           "Getter2" + "Setter1" + "Setter2", result);
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
   String result = outputStreamCaptor.toString().trim();
   
   Assert.assertEquals("Getter1" + 
           "Setter1" + "Getter2" + "Setter2", result);
   }

   /**
    * Test of copyToClipboard method, of class MethodPrinter.
    */
   @Test
   public void testCopyToClipboard() throws IOException, UnsupportedFlavorException {
      MethodPrinter instance = new JavaMethodPrinter();
      
      MethodQueue getters = new LinkedMethodQueue();
      MethodQueue setters = new LinkedMethodQueue();
      
      getters.add("Getter1");
      getters.add("Getter2");
      setters.add("Setter1");
      setters.add("Setter2");
   
      instance.copyToClipboard(getters, setters);
   
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      //Collect the data copied to the system clipboard by copyToClipboard
		Clipboard clipboard = toolkit.getSystemClipboard();
      //and then returning the data from the clipboard using stringFlavor
      //returns the data from the clipboard as plain text
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
      
      
      Assert.assertEquals("Getter1" + 
           "Getter2" + "Setter1" + "Setter2", result);
      
   }

   public class MethodPrinterImpl extends MethodPrinter {

      public void printToFile(MethodQueue getters, MethodQueue setters, String filePath) {
      }
   }
   
}
