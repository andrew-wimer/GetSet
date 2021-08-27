/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE: Aug 26 2021
*/

package getset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLASS DESCRIPTION: Handles inputs, submenus, and program functioning 
 * when java is selected as the language to generate getters and setters.
 * @author Andrew Wimer
 * Aug 25 2021
 */
public class JavaGSBranch extends GetSetBranch {

   /**
    * Entry into the Java branch of GetSet.
    * @throws IOException
    * @throws FileNotFoundException 
    */
   @Override
   public void run() throws IOException, FileNotFoundException
   {
         languageMainMenu();
   }
   
   /**
    * Displays the selection of options available in the main menu for
    * importing Java data members. 
    */
   private void displayLanguageMainMenu()
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
   private void displayOutputSelectionMenu()
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
            case "t":
               printToConsole(dMM);
               break;
             case "c":
               copyToClipboard(dMM);
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
       try{
       dMM = dMP.parseFile(filePath);
       outputSelectionMenu(dMM);  
       }
       catch(IOException e)
       {
          System.out.println("File not found.");
       }
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
      try{
      mPrint.printToFile(getsSets[0], getsSets[1], filePath);
      System.out.println("Methods printed to file: " +  filePath);
      }
      catch(IOException e)
       {
          System.out.println("File not found.");
       }
   }
   
  /**
    * Outputs getters and setters to console
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
    */
   public MethodQueue[] dataMembersToQueue(DataMemberMap dMM)
   {
        MembersToMethods mTM = new JavaMemsToMethods();
      return mTM.generateMethodQueues(dMM);
      
   }
   
   /**
    * Outputs getters and setters to clipboard
    * @throws FileNotFoundException
    */
   public void copyToClipboard(DataMemberMap dMM)
   {
      MethodPrinter mPrint = new JavaMethodPrinter();
      MethodQueue[] getsSets = dataMembersToQueue(dMM);
      mPrint.copyToClipboard(getsSets[0], getsSets[1]);
   }
}
