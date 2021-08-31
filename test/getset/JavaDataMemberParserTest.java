/*
 * PROGRAMMED BY: Andrew Wimer
*  CREATED ON: August 12 2021
* LAST UPDATE: August 18 2021
 */
package getset;

import datamemberparse.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * v2. 
 * For cases of declarations:
 * Matches expected results for multi line comments on separate lines,
 * single line comments beginning with //. Also now matches expected results
 * when a multi line comment surrounds an initialization or declaration 
 * on the same line.
 * 
 * For cases of initializations: 
 * Matches expected results for multi line comments on separate lines,
 * single line comments beginning with //. Also now matches expected results
 * when a multi line comment surrounds an initialization or declaration 
 * on the same line.
 * 
 * For both cases: Fails when line ends with end comment, if no start comment
 * is initiated earlier
 * 
 * @author Andrew Wimer
 */
public class JavaDataMemberParserTest {
   
   public JavaDataMemberParserTest() {
   }

   /**
    * Test of parseFile method, of class JavaDataMemberParser.
    */
   @Test
   public void testParseFile() throws Exception {
      System.out.println("parseFile");
      String filePath = "JavaParserTestCase.txt"; 
      JavaDataMemberParser instance = new JavaDataMemberParser();
      DataMemberMap expResult = new DataMemberMap();
      expResult.put("name", "String");
      Set expResultSet = new TreeSet();
      expResultSet = expResult.entrySet();
      DataMemberMap result = instance.parseFile(filePath);
      Set resultSet = new TreeSet();
      resultSet = result.entrySet();
      assertEquals(expResultSet, resultSet);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }

   /**
    * Test of isComment method, of class JavaDataMemberParser.
    */
   @Test
   public void testIsComment() {
      System.out.println("isComment");
      String line = "//Test Comment";
      JavaDataMemberParser instance = new JavaDataMemberParser();
      boolean expResult = true;
      boolean result = instance.isComment(line);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //fail("The test case is a prototype.");
   }
   
}
