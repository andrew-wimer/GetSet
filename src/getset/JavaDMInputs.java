/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE: Aug 23 2021
*/

package getset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLASS DESCRIPTION: Handles inputs, submenus, and program functioning 
 * when java is selected as the language to generate getters and setters.
 * @author Andrew Wimer
 * 
 */
public class JavaDMInputs implements DataMemberInputs {

   /**
    * Main GetSet menu for Java language selection
    * @throws IOException 
    */
   @Override
   public void languageMainMenu() throws IOException {
      
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
      String choice = "";
      do
      {
         System.out.println("Java Main Menu");
         System.out.println("Choose method of importing data members: ");
         System.out.print("[i] Input to console\n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");

         choice = reader.readLine();

         switch(choice.toLowerCase()){
            
            
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x"));
      
      reader.close();
   }

   @Override
   public void outputSelection() throws IOException {
      
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
      String choice = "";
      do
      {
         System.out.println("Output Selection Menu");
         System.out.println("Choose method of importing data members: ");
         System.out.print("[i] Input to console\n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");

         choice = reader.readLine();

         switch(choice.toLowerCase()){
            
            
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x"));
      
      reader.close();
   }
   
   

}
