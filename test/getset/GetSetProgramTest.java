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
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class GetSetProgramTest {
   
   private final PrintStream standardOut = System.out;
   private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
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
   
   public GetSetProgramTest() {
   }

   /**
    * Test of start method, of class GetSetProgram.
    */
   @Test
   public void testStart_0args() throws Exception {
   }

   /**
    * Test of start method, of class GetSetProgram.
    */
   @Test
   public void testStart_String() {
   }

   /**
    * Test of displayMainMenu method, of class GetSetProgram.
    */
   @Test
   public void testDisplayMainMenu() {
      GetSetProgram instance = new GetSetProgram();
      String expResult = "GetSet Main Menu\n"+
              "Choose an objected-oriented language: \n" +
              "[j] Java\n" +
              "[x] Exit\n" +
              "\nEnter Menu Option:";
      instance.displayMainMenu();
      String result = outputStreamCaptor.toString().trim();
      
      
      Assert.assertEquals(expResult, result);
   }
   
}
