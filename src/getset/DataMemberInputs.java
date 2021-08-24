/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE:  Aug 23 2021
*/

package getset;

import java.io.IOException;

/**
 * CLASS DESCRIPTION: Handles inputs, submenus, and program functioning 
 * for whichever language is selected as the language to 
 * generate getters and setters.
 * @author Andrew Wimer
 * 
 */
public interface DataMemberInputs {
   
   public void languageMainMenu() throws IOException;
   
   public void outputSelection() throws IOException;

}
