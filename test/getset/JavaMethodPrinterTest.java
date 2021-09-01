/*
 * PROGRAMMED BY: Andrew Wimer
* DATE CREATED: Aug 15 2021
* LAST UPDATED: Aug 20 2021
 */
package getset;

import datamemberparse.DataMemberMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import methodformats.*;
import methodprinting.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andr00
 */
public class JavaMethodPrinterTest {

   
   public JavaMethodPrinterTest() {
   }
   


   /**
    * Test of printToFile method, of class JavaMethodPrinter.
    */
   @Test
   public void testPrintToFile() throws FileNotFoundException {
      LinkedMethodQueue[] getsSets = new LinkedMethodQueue[2];
      getsSets[0] = new LinkedMethodQueue();
      getsSets[1] = new LinkedMethodQueue();
      
      String identifier = "name";
      String returnType = "String";
      String fileLocation = "JavaParserTestCase2.txt";
      DataMemberMap dMM = new DataMemberMap();
      dMM.put(identifier, returnType);
      JavaMethodPrinter instance = new JavaMethodPrinter();
   
      for (String key : dMM.keySet())
      {
         JavaGetter jG = new JavaGetter();
         JavaSetter jS = new JavaSetter();
         getsSets[0].offer(jG.writeFileFormattedGetter(key, dMM.get(key)));
         getsSets[1].offer(jS.writeFileFormattedSetter(key, dMM.get(key)));
      }
      
      instance.printToFile(getsSets[0], getsSets[1], fileLocation);
      
      Assert.assertTrue(equalFiles("JavaParserTestCase.txt", 
              "JavaParserTestCase2.txt"));
   }

   /**
    * Reads files line by line and returns true if each line read from the 
    * test file matches the expected line from the expected file.
    * @param expectedFileName
    * @param resultFileName
    * @return 
    * @author Mauricio Gracia Gutierrez
    */
   private static boolean equalFiles(String expectedFileName,
        String resultFileName) {
    boolean equal;
    BufferedReader bExp;
    BufferedReader bRes;
    String expLine ;
    String resLine ;

    equal = false;
    bExp = null ;
    bRes = null ;

    try {
        bExp = new BufferedReader(new FileReader(expectedFileName));
        bRes = new BufferedReader(new FileReader(resultFileName));

        if ((bExp != null) && (bRes != null)) {
            expLine = bExp.readLine() ;
            resLine = bRes.readLine() ;

            equal = ((expLine == null) && (resLine == null)) || ((expLine != null) && expLine.equals(resLine)) ;

            while(equal && expLine != null)
            {
                expLine = bExp.readLine() ;
                resLine = bRes.readLine() ; 
                equal = expLine.equals(resLine) ;
            }
        }
    } catch (Exception e) {

    } finally {
        try {
            if (bExp != null) {
                bExp.close();
            }
            if (bRes != null) {
                bRes.close();
            }
        } catch (Exception e) {
        }

    }
    return equal;
}
   
}
