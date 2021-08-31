/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagebranches;

import datamemberparse.DataMemberMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class JavaGSBranchTest {
   
   private final PrintStream standardOut = System.out;
   private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
   
   @Before
   public void setUp () throws Exception
   {
      System.setOut(new PrintStream(outputStreamCaptor));
   }
   
   @After
   public void tearDown() {
      System.setOut(standardOut);
   }
   
   public JavaGSBranchTest() {
   }

   /**
    * Test of run method, of class JavaGSBranch.
    */
   @Test
   public void testRun() throws Exception {
      
   }

   /**
    * Test of languageMainMenu method, of class JavaGSBranch.
    */
   @Test
   public void testLanguageMainMenu() throws Exception {
   }

   /**
    * Test of outputSelectionMenu method, of class JavaGSBranch.
    */
   @Test
   public void testOutputSelectionMenu() throws Exception {
   }

   /**
    * Test of importFromJavaFile method, of class JavaGSBranch.
    */
   @Test
   public void testImportFromJavaFile() throws Exception {
   }

   /**
    * Test of printToFile method, of class JavaGSBranch.
    */
   @Test
   public void testPrintToFile() throws Exception {
   }

   /**
    * Test of printToConsole method, of class JavaGSBranch.
    */
   @Test
   public void testPrintToConsole() {
   }

   /**
    * Test of dataMembersToQueue method, of class JavaGSBranch.
    */
   @Test
   public void testDataMembersToQueue() {
      JavaGSBranch instance = new JavaGSBranch();
      DataMemberMap dMM = new DataMemberMap();
      dMM.put("name", "String");
      
      
   }

   /**
    * Test of copyToClipboard method, of class JavaGSBranch.
    */
   @Test
   public void testCopyToClipboard() {
   }
   
}
