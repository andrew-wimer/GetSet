/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 27 2021
*/

package getset;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;

/**
 * Abstract Class Description: An interface for a method printer object. 
 * Method printer objects will print our methods/functions to either 
 * a program file, the console, or to the user's clipboard.
 * @author Andrew Wimer
 * v2 Converted from interface to abstract class. Print to console 
 * and copy to clipboard should universally function the same for
 * each language, unlike printing to a file.
 */
abstract public class MethodPrinter {
   
abstract public void printToFile(MethodQueue getters, MethodQueue setters,
           String filePath) throws FileNotFoundException;
   
   /**
    * Prints  a full field of getters and full field of setters. 
    * @param getters
    * @param setters
    */
   public void printToConsole(MethodQueue getters, MethodQueue setters) {
      
      //String getSetList = "";
      
      //getSetList = separateGetSetList(getters, setters);
      
      System.out.println(separateGetSetList(getters, setters));
   }
   
   /**
    * Prints alternating setters and getters to the console instead of
    * printing a full field of getters and full field of setters.
    * @param getters
    * @param setters
    */
   public void printToConsoleAlternating(MethodQueue getters, 
           MethodQueue setters) {

      System.out.println(alternatingGetSetList(getters, setters));

   }

   /**
    * Copies  a full field of getters and full field of setters to clipboard. 
    * @param getters
    * @param setters
    */
   public void copyToClipboard(MethodQueue getters, MethodQueue setters) {
      String getSetList = "";
      
      getSetList = separateGetSetList(getters, setters);
      
      StringSelection stringSelection = new StringSelection(getSetList);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, null);
   }
   
   /**
    * Returns a string of consecutive getters followed by consecutive setters
    * @param getters
    * @param setters
    * @return 
    */
   protected String separateGetSetList(MethodQueue getters, MethodQueue setters)
   {
      String getSetList = "";
      
      while(getters.peek() != null)
      {
         getSetList += getters.poll();
      }
      
      while(setters.peek() != null)
      {
         getSetList += setters.poll();
      }
      
      return getSetList;
   }
   
   /**
    * Returns a string of alternating getters and setters
    * @param getters
    * @param setters
    * @return 
    */
   protected String alternatingGetSetList(MethodQueue getters, 
           MethodQueue setters)
   {
      String getSetList = "";
      
      while(getters.peek() != null && setters.peek() != null)
         {
            getSetList += getters.poll();
            getSetList += setters.poll();
         }
      
      return getSetList;
   }
   
   
}
