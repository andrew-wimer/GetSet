/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 15 2021
*/

package getset;

/**
 * INTERFACE DESCRIPTION: An interface for a method printer object. 
 * Method printer objects will print our methods/functions to either 
 * a program file, the console, or to the user's clipboard.
 * @author Andrew Wimer
 */
public interface MethodPrinter {
   
   public void printToFile(MethodQueue getters, MethodQueue setters);
   
   public void printToConsole(MethodQueue getters, MethodQueue setters);
   
   public void copyToClipboard(MethodQueue getters, MethodQueue setters);

}
