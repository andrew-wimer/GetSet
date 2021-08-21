/*
 * PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 15 2021
* LAST UPDATED: Aug 20 2021
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

   
}
