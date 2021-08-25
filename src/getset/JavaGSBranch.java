/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE: Aug 24 2021
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
 * 
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
         System.out.print("[c] Input to console\n");
         System.out.print("[j] Import from Java file \n");
         System.out.print("[l] Import from list in text file \n");
         System.out.print("[b] Back \n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");

         
         
         choice = reader.readLine();
         
         

         switch(choice.toLowerCase()){
            
            case "j":
               importFromJavaFile();
            case "b":
               break;
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x")
              && !choice.equalsIgnoreCase("b"));
      
     reader.close();
   }

   @Override
   public void outputSelection(DataMemberMap dMM) throws IOException {  
      
      String choice = "";
      do
      {
         System.out.println("Output Selection Menu");
         System.out.println("Choose method of outputting data members: ");
         System.out.print("[f] Print to file\n");
         System.out.print("[t] Print to terminal\n");
         System.out.print("[c] Copy to clipboard\n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");

         BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
         
         choice = reader.readLine();

               reader.close();
         
         switch(choice.toLowerCase()){
            
            case "f":
               printToFile(dMM);
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x"));
      

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
       outputSelection(dMM);  
       
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
   }
   
   public String getFilePath() throws IOException
   {
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter your filepath: ");
       String filePath = "";
       filePath = reader.readLine();
       reader.close();
       return filePath;
   }

}
