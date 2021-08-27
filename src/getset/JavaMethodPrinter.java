/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 26 2021
*/

package getset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * CLASS DESCRIPTION: JavaMethodPrinter prints the queues of getter and setter
 * methods to either the console, the clipboard, or to a file.
 * @author Andrew Wimer
 * aug 22 2021 - Bugfixes: - replaced hasNext and next in printToFileBottom
 *  with hasNextLine and nextLine.
 * -getterSetterList in printAlternating and printSeparately are now 
 * initialize while fileAsList is no longer the parameter or return
 * aug 21 2021 - removed copyToClipboard and printToConsole, now extends
 * instead of implementing MethodPrinter
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
      try {
         printToFileBottom(getters, setters, fileName, scnr);
      } catch (IOException ex) {
         Logger.getLogger(JavaMethodPrinter.class.getName()).log(Level.SEVERE, 
                 null, ex);
      }

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
              throws FileNotFoundException, IOException
      { 
      Scanner scnr = new Scanner(new File(fileName));
         
      if (placementLocation.equalsIgnoreCase(endOfFile))
         printToFileBottom(getters, setters, fileName, scnr);
      else if (placementLocation.equalsIgnoreCase(belowConstructors))
         printBelowConstructors(getters, setters, fileName, scnr);    
   }  
   
    /**
    * Prints getters and setters to the bottom of the specified file,
    * before the final closing brace '}' character found in the file.
    */
   private void printToFileBottom(MethodQueue getters, MethodQueue setters,
           String fileName, Scanner fileScnr) throws IOException
   {
      List<String> fileAsList = new ArrayList();
      List<String> getterSetterList = new ArrayList();
      
      while (fileScnr.hasNextLine())
      {
         String line = fileScnr.nextLine();
         fileAsList.add(line);
      }
      
      int indexOfLastBrace = fileAsList.size()-1;
      while (!fileAsList.get(indexOfLastBrace).contains("}") && 
              indexOfLastBrace > 0)
      {
         indexOfLastBrace--;
      }
      getterSetterList = printSeparately(getters, setters);
      fileAsList.addAll(indexOfLastBrace, getterSetterList);
      
      Path file = Path.of(fileName);
      Files.write(file, fileAsList, StandardCharsets.UTF_8);
   }
   
   /**
    * Prints getters and setters to directly below the constructors in a file 
    */
   private void printBelowConstructors(MethodQueue getters, MethodQueue setters,
           String fileName, Scanner fileScnr)
   {
      throw new UnsupportedOperationException("Unsupported operation.");
   }
   
   /**
    * Prints getters and setters in two separate consecutive lists.
    * @param getters
    * @param setters
    * @return 
    */
   private List<String> printSeparately(MethodQueue getters, 
           MethodQueue setters)
   {
      List<String> getterSetterList = new ArrayList();
      while(getters.peek() != null)
      {
         getterSetterList.add(getters.poll());
      }
      
      while(setters.peek() != null)
      {
         getterSetterList.add(setters.poll());
      }
      return getterSetterList;
   }
   
   /**
    * Prints alternating between setters and getters.
    * @param getters
    * @param setters
    * @return 
    */
   private List<String> printAlternating(MethodQueue getters, 
           MethodQueue setters)
   {
      List<String> getterSetterList = new ArrayList();
      while(getters.peek() != null)
      {
         getterSetterList.add(getters.poll());
         getterSetterList.add(setters.poll());
      }
      
      return getterSetterList;
   }
   
    /**
    * Returns true if the line contains the characters // which precedes 
    * comment lines, and *, which precedes javadoc comments
    * @param line
    * @return 
    */
   private boolean isComment(String line)
   {
      line = line.trim();
      
      return line.startsWith("//") || line.startsWith("*");
   }
   
   
   private boolean hasNonCommentBrace(String line)
   {
     throw new UnsupportedOperationException(); 
   }
}
