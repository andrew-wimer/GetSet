/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 23 2021
* LAST UPDATE:  Aug 26 2021
*/

package getset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CLASS DESCRIPTION: Handles inputs, submenus, and program functioning 
 * for whichever language is selected as the language to 
 * generate getters and setters.
 * @author Andrew Wimer
 * 
 */
public abstract class GetSetBranch {
   
   abstract public void run() throws IOException, FileNotFoundException;
   
   abstract public void printToConsole(DataMemberMap dMM);
   
   abstract public void printToFile(DataMemberMap dMM) throws FileNotFoundException, 
           IOException;
   
   abstract public MethodQueue[] dataMembersToQueue(DataMemberMap dMM);
   
   /**
    * Closes the GetSet program.
    */
   protected void closeProgram()
   {
      System.out.println("Closing program...");
      System.exit(0);
   }
   
   /**
    * Method for user to input the path of a file.
    * @return
    * @throws IOException 
    */
   protected String getFilePath() throws IOException
   {
      BufferedReader reader = 
              new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter your filepath: ");
       String filePath = "";
       filePath = reader.readLine();
       return filePath;
   }
}