/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 20 2021
*/

package getset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * CLASS DESCRIPTION: JavaMethodPrinter prints the queues of getter and setter
 * methods to either the console, the clipboard, or to a file.
 * @author Andrew Wimer
 * 
 */
public class JavaMethodPrinter extends MethodPrinter {
   
   final private String endOfFile= "e";
   final private String belowConstructors= "b";
  
   
   /**
    * Default printToFile prints the getters and setters to the bottom 
    * of the file, before the closing brace.
    * @param getters
    * @param setters
    * @param fileName 
    */
   @Override
   public void printToFile(MethodQueue getters, MethodQueue setters,
      String fileName) throws FileNotFoundException 
   {  
      Scanner scnr = new Scanner(new File(fileName));
      printToFileBottom(getters, setters, fileName, scnr);

   }  
   
   /**
    * placementLocation parameterized printToFile prints the getters and setters 
    * to the user-specified location in the file.
    * @param getters
    * @param setters
    * @param fileName 
    */
      public void printToFile(MethodQueue getters, MethodQueue setters,
           String fileName, String placementLocation) 
              throws FileNotFoundException
      {
      
      Scanner scnr = new Scanner(new File(fileName));
         
      if (placementLocation.equalsIgnoreCase(endOfFile))
         printToFileBottom(getters, setters, fileName, scnr);
      else if (placementLocation.equalsIgnoreCase(belowConstructors))
         printBelowConstructors(getters, setters, fileName, scnr);
      
   }  
   
    /**
    * Prints getters and setters to the bottom of the specified file
    */
   private void printToFileBottom(MethodQueue getters, MethodQueue setters,
           String fileName, Scanner fileScnr)
   {
      List<String> fileAsList = new ArrayList();
      ArrayDeque<String> braceStack = new ArrayDeque();
      
      while (fileScnr.hasNext())
      {
         String line = fileScnr.next();
         fileAsList.add(line);
      }
   }
   
   /**
    * Prints getters and setters to below the constructors in a file 
    */
   private void printBelowConstructors(MethodQueue getters, MethodQueue setters,
           String fileName, Scanner fileScnr)
   {
      throw new UnsupportedOperationException();
   }
   
   
   private void printConsecutively()
   {
      
   }
   
   private void printAlternating()
   {
      
   }
}
