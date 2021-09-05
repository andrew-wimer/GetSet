/**
* PROGRAMMED BY: Andrew Wimer
*  CREATED ON: August 12 2021
* LAST UPDATE: Sep 4 2021
*/

package datamemberparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CLASS DESCRIPTION: JavaDataMemberParse parses Java class files for 
 * Data Members to add to the DataMemberMap
 * @author Andrew Wimer
 * Sep 4 2021: added parseFromListInFile method
 * 
 *  Update Aug 19 2021: originally had trimComments(line, inCommentBlock) in
 * parseFile. Now changed so line = trimComments(line, inCommentBlock); 
 * Without this change, comments were never trimmed from the current line. 
 * 
 * Update Aug 18 2021: parseFile method has shrunk by containing the process 
 * to one consecutive while loop instead of two consecutive while loops.
 * 
 * Update Aug 17 2021: close to final version. breaking down parseFile method
 * into smaller mathods
 */
public class JavaDataMemberParser implements DataMemberParser  {
   
   
   /** This regex pattern is for simple data member declarations. */
   final private Pattern declarationPattern = 
           Pattern.compile("([a-zA-z]+)\\s([a-zA-z]+)[;]");
   /** This regex pattern is for data member declarations with initializations. 
    */
   final private Pattern initializationPattern = 
           Pattern.compile("([a-zA-z]+)\\s([a-zA-z]+)\\s[=]");


   /**
    * Main logic for parsing a Java file for data members
    * @param filePath the path of the file to parse
    * @return map of data members declared at class-level in java file
    * @throws FileNotFoundException 
    */
   @Override
   public DataMemberMap parseFile(String filePath) throws FileNotFoundException  {
      Scanner scnr = new Scanner(new File(filePath));
      DataMemberMap dmMap = new DataMemberMap();
      boolean inCommentBlock = false;  
      //stack for braces not contained in comments found while parsing file. 
      ArrayDeque braceStack = new ArrayDeque();
      
      while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            if (startsCommentBlock(line) && !endsCommentBlock(line))
            {
               inCommentBlock = true;
               line = line.substring(0, line.indexOf("/*"));
            } 
            else if (!startsCommentBlock(line) && endsCommentBlock(line))
            {
                inCommentBlock = false;  
            }
            line = trimComments(line, inCommentBlock);      
            if (line.contains("{"))
            {
               braceStack.push("{");
            }
            else if (line.contains("}"))
            {
               braceStack.pop();
               if(braceStack.size()==0)
                  break;
            }

            if (!isComment(line) && !inCommentBlock && braceStack.size() == 1)
               dmMap = matchPatternsToMap(line, dmMap);
        }         
      scnr.close();
      return dmMap;
   }

   @Override
   /**
    * Returns true if the line contains the characters // which precedes 
    * comment lines, and *, which precedes javadoc comments
    * @param line
    * @return 
    */
   public boolean isComment(String line) {
      line = line.trim();
      return line.startsWith("//") || line.startsWith("*");
   }
   
   /**
    * Returns true if the line contains the characters /* and /** that 
    * start comment blocks.
    * @param line
    * @return 
    */
   private boolean startsCommentBlock(String line)
   {
      return line.contains("/*") || line.contains("/**");
   }
   
   /**
    * Returns true if line contains the end of a comment block
    * 
    */
   private boolean endsCommentBlock(String line)
   {
      return line.contains("*/");
   }
   
   /**
    * Parses a line with one or more comments beginning with / *
    * and ending with * / (minus the spaces between slash and asterisk)
    * @param line
    * @return string line without any commented sections
    */
   private String parseMultiCommentLine(String line)
   {
      Scanner newScan = new Scanner(line);
      String next = "";
      //the new line minus comments that will be returned 
      String newLine = "";
      newScan.useDelimiter("/*([a-zA-Z])"+"*/");
      while (newScan.hasNext())
      {
         next = newScan.next();
         if (!next.contains("*"))
            newLine += next;
      }
      return newLine;
   }
   
   /**
    * Trims comments from the parameterized file line passed through
    * @param line
    * @return the line passed through without comments
    */
   private String trimComments(String line, boolean inCommentBlock)
   {
      String lineMinusComments = line;
      if ((startsCommentBlock(line) && endsCommentBlock(line)))
      {
         lineMinusComments = parseMultiCommentLine(line);
      }
      else if (endsCommentBlock(line) & !inCommentBlock)
      {
         lineMinusComments = line.substring(line.indexOf("*/"));
      }
      if (line.contains("//"))
      {
         lineMinusComments = line.substring(0, line.indexOf("//"));
      }
      return lineMinusComments;
   }
   
   /**
    * Matches the patterns for data types and identifiers 
    */
   private DataMemberMap matchPatternsToMap(String line, DataMemberMap dmMap)
   {
      DataMemberMap updatedDMMap = dmMap;
      Matcher equalsMatcher = initializationPattern.matcher(line);
      Matcher semiColMatcher = declarationPattern.matcher(line);
      String identifier = "";
      String returnType = "";
      if (line.contains("=") && equalsMatcher.find())
      {
         identifier = equalsMatcher.group(2);
         returnType = equalsMatcher.group(1);
         updatedDMMap.put(identifier, returnType);
      }
      else if (line.contains(";") && semiColMatcher.find())
      {
         identifier = semiColMatcher.group(2);
         returnType = semiColMatcher.group(1);
         updatedDMMap.put(identifier, returnType);
      }
      return updatedDMMap;
   }
   
   /**
    * To implement later: trims code around braces in cases where
    * code precedes a right brace or follows a left brace.
    * @param line
    * @return 
    */
   private String trimAroundBraces(String line)
   {
      throw new UnsupportedOperationException();
   }
   
   /**
    * Parses data members from a simple list in a file. To be parsed, each 
    * line must be only two words long, the first word being a data type and
    * the second word the identifier.
    * @param filePath
    * @return
    * @throws FileNotFoundException 
    */
   public DataMemberMap parseFromListInFile(String filePath) 
           throws FileNotFoundException
   {
      DataMemberMap dMM = new DataMemberMap();
      Scanner scnr = new Scanner(new File(filePath));
      String newLine = "";
      int lineCount = 1;
      
      while(scnr.hasNextLine()){
      newLine = scnr.nextLine();
      String[] stringArray = newLine.split("\\s+");
      if (stringArray.length == 2)
         dMM.put(stringArray[1], stringArray[0]);
      else 
         System.out.println("Error line " + lineCount + 
                 ":  Data type and identifier must be "
                    + "two words only.");
      lineCount++;
      }
      
      return dMM;
   }
}