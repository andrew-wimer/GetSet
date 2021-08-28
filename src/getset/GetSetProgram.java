/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 19 2021
* LAST UPDATE: Aug 26 2021
*/

package getset;

import languagebranches.JavaGSBranch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLASS DESCRIPTION: Runs the GetSet program as per the String 
 * arguments provided when it is called in the main method in GetSet.java
 * @author Andrew Wimer
 * 
 */
public class GetSetProgram {
   
   /**
    * Default constructor
    */
   public GetSetProgram()
   {
      
   }
   
   public GetSetProgram(String[] args)
   {
      
   }
   
   /**
    * Runs main top-level menu for the GetSet program.
    * @throws IOException 
    */
   public void start() throws IOException
   {
      BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
      String choice = "";
      
      do
      {
         displayMainMenu();
         choice = reader.readLine();
         switch(choice.toLowerCase()){
            
            case "j":
               JavaGSBranch jGSB = new JavaGSBranch();
               jGSB.run();
               break;
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
               break;
            default:
               System.out.println("Invalid choice; try again.");
               break;
         }
      } while (!choice.equalsIgnoreCase("x"));
      reader.close();
   }
   
   public void start(String progLanguage)
   {
      
   }
   
   /**
    * Displays top-level main menu options. 
    */
   public void displayMainMenu()
   {
      System.out.println("GetSet Main Menu");
         System.out.println("Choose an objected-oriented language: ");
         System.out.print("[j] Java\n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");
   }

   

}
