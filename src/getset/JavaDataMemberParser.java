/**
* PROGRAMMED BY: Andrew Wimer
*  CREATED ON: August 12 2021
* LAST UPDATE: August 15 2021
*/

package getset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;



/**
 * CLASS DESCRIPTION: JavaDataMemberParse parses Java class files for Data Members
 * to add to the DataMemberMap
 * @author Andrew Wimer
 * 
 */
public class JavaDataMemberParser implements DataMemberParser  {
   
   private ArrayDeque bracketStack = new ArrayDeque();
   private ArrayDeque declarationStack = new ArrayDeque();

   /*
   @Override
   public File openFile(String filePath) {
      //parse file from parameterized file path
      File text = new File(filePath);
      return text;
   }
*/

   @Override
   public DataMemberMap parseFile(String filePath) throws FileNotFoundException  {
      
      Scanner scnr = new Scanner(new File(filePath));
      DataMemberMap dmMap = new DataMemberMap();
      String identifier = "";
      String returnType = "";
      boolean inCommentBlock = false;  
      int lineNumber = 1;
      
      
      while(scnr.hasNextLine() && bracketStack.size() != 1){
            
            String line = scnr.nextLine();
            line = line.substring(0, line.indexOf("//"));
            if (!isComment(line) && line.contains("{"))
               bracketStack.push("{");
        }    
      
      while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            
            if (startsCommentBlock(line))
            {
               inCommentBlock = true;
               line = line.substring(0, line.indexOf("/*"));
            }
        
            
            ArrayDeque declarationStack = new ArrayDeque();
            //while (line.)
            line = line.substring(0, line.indexOf("//"));
            
            
            
            System.out.println("line " + lineNumber + " :" + line);
            
            lineNumber++;
        }    
      
      scnr.close();
      return dmMap;
   }

   @Override
   public boolean isComment(String line) {
      if (line.startsWith("//") || line.startsWith("*"))
         return true;
      
      return false;
   }
   
   public boolean startsCommentBlock(String line)
   {
      if (line.contains("/*") || line.contains("/**"))
         {
            return true;
         }
      return false;
   }
   
   public boolean endsCommentBlock(String line)
   {
      if (line.contains("/*") || line.contains("/**"))
         return true;
      return false;
   }

}
