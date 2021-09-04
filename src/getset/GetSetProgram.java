/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 19 2021
* LAST UPDATE: Sep 3 2021
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
 * Sep 3 2021: moved switch-case statement from start() to separate
 * mainMenuInput method
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
         mainMenuInput(choice);
         
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
      System.out.print("\nGetSet Main Menu\n" +
              "Choose an objected-oriented language: \n" +
              "[j] Java\n" +
              "[x] Exit\n" +
              "\nEnter Menu Option: ");
   }
   
   /**
    * Receives user's choice of program branch and matches with 
    * a switch-case branch for that input. 
    * @param choice
    * @throws IOException 
    */
   public void mainMenuInput(String choice) throws IOException
   {
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
   }
}
