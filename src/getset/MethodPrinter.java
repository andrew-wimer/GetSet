/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 26 2021
*/

package getset;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
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
      
      while(getters.peek() != null)
      {
         System.out.println(getters.poll());
      }
      
      while(setters.peek() != null)
      {
         System.out.println(setters.poll());
      }
   }
   
   /**
    * Prints alternating setters and getters to the console instead of
    * printing a full field of getters and full field of setters.
    * @param getters
    * @param setters
    */
   public void printToConsoleAlternating(MethodQueue getters, 
           MethodQueue setters) {

         while(getters.peek() != null && setters.peek() != null)
         {
            System.out.println(getters.poll());
            System.out.println(setters.poll());
         }
   }

   public void copyToClipboard(MethodQueue getters, MethodQueue setters) {
      String getSetList = "";
      
      while(getters.peek() != null)
      {
         getSetList += getters.poll();
      }
      
      while(setters.peek() != null)
      {
         getSetList += setters.poll();
      }
      
      StringSelection stringSelection = new StringSelection(getSetList);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, (ClipboardOwner) this);
   }

}
