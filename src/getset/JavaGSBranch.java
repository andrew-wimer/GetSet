/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE: Aug 25 2021
*/

package getset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CLASS DESCRIPTION: Handles inputs, submenus, and program functioning 
 * when java is selected as the language to generate getters and setters.
 * @author Andrew Wimer
 * Aug 25 2021
 */
public class JavaGSBranch implements GetSetBranch {

   
   public void run()
   {
      try {
         languageMainMenu();
      } catch (IOException ex) {
         Logger.getLogger(JavaGSBranch.class.getName()).log(Level.SEVERE, null, ex);
      }  
   }
   
   /**
    * Displays the selection of options available in the main menu for
    * importing Java data members. 
    */
   public void displayLanguageMainMenu()
   {
      System.out.println("Java Main Menu");
         System.out.println("Choose method of importing data members: ");
         System.out.print("[c] Input to console\n");
         System.out.print("[j] Import from Java file \n");
         System.out.print("[l] Import from list in text file \n");
         System.out.print("[b] Back \n");
         System.out.print("[x] Exit program\n");
         System.out.print("\nEnter Menu Option: ");
   }
   
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
         displayLanguageMainMenu();
         choice = reader.readLine();
         switch(choice.toLowerCase()){
            
            case "j":
               importFromJavaFile();
               break;
            case "x": 
               closeProgram();
               break;
            case "b":
               break;
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x")
              && !choice.equalsIgnoreCase("b"));
   }
   
   /**
    * Displays the selection of options available in the Output Selection
    * menu
    */
   public void displayOutputSelectionMenu()
   {
      System.out.println("Output Selection Menu");
         System.out.println("Choose method of outputting data members: ");
         System.out.print("[f] Print to file\n");
         System.out.print("[t] Print to terminal\n");
         System.out.print("[c] Copy to clipboard\n");
         System.out.print("[b] Back \n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");
   }

   /**
    * Output selection menu for outputting getters and setters from the
    * processed data members.
    * @throws IOException 
    */
   @Override
   public void outputSelectionMenu(DataMemberMap dMM) throws IOException {  
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));

      String choice = "";
      do
      {  
         displayOutputSelectionMenu();
         choice = reader.readLine();
         
         switch(choice.toLowerCase()){          
            case "f":
               printToFile(dMM);
               break;
            case "b":
               break;
            case "x": 
               closeProgram();
               break;
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x")
              && !choice.equalsIgnoreCase("b"));
   }
   
   /**
    * Imports data members from java file. 
    * @throws FileNotFoundException
    * @throws IOException 
    */
   public void importFromJavaFile() throws FileNotFoundException, IOException
   {
       String filePath = getFilePath();
       DataMemberParser dMP = new JavaDataMemberParser();
       DataMemberMap dMM = new DataMemberMap();
       dMM = dMP.parseFile(filePath);
       outputSelectionMenu(dMM);  
   }
   
   /**
    * Outputs getters and setters to java file
    * @throws FileNotFoundException
    * @throws IOException 
    */
   public void printToFile(DataMemberMap dMM) throws FileNotFoundException, IOException
   {
       String filePath = getFilePath();
       MembersToMethods mTM = new JavaMemsToMethods();
      MethodPrinter mPrint = new JavaMethodPrinter();
      MethodQueue[] getsSets = new LinkedMethodQueue[2];
      getsSets = mTM.generateMethodQueues(dMM);
      mPrint.printToFile(getsSets[0], getsSets[1], filePath);
      System.out.println("Methods printed to file: " +  filePath);
   }
   
   /**
    * Method for user to input the path of a file.
    * @return
    * @throws IOException 
    */
   public String getFilePath() throws IOException
   {
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter your filepath: ");
       String filePath = "";
       filePath = reader.readLine();
       return filePath;
   }
   
   /**
    * Closes the GetSet program.
    */
   public void closeProgram()
   {
      System.out.println("Closing program...");
      System.exit(0);
   }
   
  /**
    * Outputs getters and setters to console
    * @throws FileNotFoundException
    * @throws IOException 
    */
   public void printToConsole(DataMemberMap dMM)
   {

      MethodPrinter mPrint = new JavaMethodPrinter();
      MethodQueue[] getsSets = dataMembersToQueue(dMM);
      mPrint.printToConsole(getsSets[0], getsSets[1]);
   }
 
   /**
    * Creates array of getter and setter queues from the mapping of
    * identifiers to return types in the DataMemberMap. 
    * @throws FileNotFoundException
    * @throws IOException 
    */
   public MethodQueue[] dataMembersToQueue(DataMemberMap dMM)
   {
        MembersToMethods mTM = new JavaMemsToMethods();
      return mTM.generateMethodQueues(dMM);
      
   }
}
