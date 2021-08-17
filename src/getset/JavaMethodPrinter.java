/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 15 2021
*/

package getset;


/**
 * CLASS DESCRIPTION: JavaMethodPrinter prints the queues of getter and setter
 * methods to either the console, the clipboard, or to a file.
 * @author Andrew Wimer
 * 
 */
public class JavaMethodPrinter implements MethodPrinter {
   
  
   @Override
   public void printToFile(MethodQueue getters, MethodQueue setters) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    /**
    * Prints  a full field of getters and full field of setters. 
    * @param getters
    * @param setters
    * @param isAlternating 
    */
   @Override
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
    * @param isAlternating 
    */
   public void printToConsoleAlternating(MethodQueue getters, 
           MethodQueue setters, boolean isAlternating) {

      //if the flag for alternating getters and setters is not true,
      //then uses default option to print separate fields of setters and getters
      if (isAlternating != true)
         printToConsole(getters, setters);
      else
      {
         while(getters.peek() != null && setters.peek() != null)
         {
            System.out.println(getters.poll());
            System.out.println(setters.poll());
         }
      }
   }

   @Override
   public void copyToClipboard(MethodQueue getters, MethodQueue setters) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
