/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 19 2021
* LAST UPDATE: Aug 24 2021
*/

package getset;

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
   
   public GetSetProgram()
   {
      
   }
   
   public GetSetProgram(String[] args)
   {
      
   }
   
   public void start() throws IOException
   {
      BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
      String choice = "";
      do
      {
         System.out.println("GetSet Main Menu");
         System.out.println("Choose an objected-oriented language: ");
         System.out.print("[j] Java\n");
         System.out.print("[x] Exit\n");
         System.out.print("\nEnter Menu Option: ");

         choice = reader.readLine();
         
         

         switch(choice.toLowerCase()){
            
            case "j":
               GetSetBranch jGSB = new JavaGSBranch();
               jGSB.run();
            case "x": 
               System.out.println("Closing program...");
               System.exit(0);
            default:
            System.out.println("Invalid choice; try again.");
                  break;
         }
      } while (!choice.equalsIgnoreCase("x"));
      reader.close();
      
      /*
      BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
       String id; // identifier
       String returnType; //data type of identifier
       
       System.out.println("Enter your identifier: ");
       id = reader.readLine();
       System.out.println("identifier  = " + id);
       System.out.println("Enter your data type: ");
       returnType = reader.readLine();
       System.out.println("data type  = " + returnType);

       Setter js = new JavaSetter();
       Getter jg = new JavaGetter();
       System.out.println(jg.writeGetter(id, returnType));
        System.out.println(js.writeSetter(id, returnType));

        reader.close();
*/
   }
   
   public void start(String progLanguage)
   {
      
   }

   

}
