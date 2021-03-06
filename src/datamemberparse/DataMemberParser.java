/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 15 2021
*/

package datamemberparse;

import java.io.FileNotFoundException;

/**
 * INTERFACE DESCRIPTION: DataMemberParse parses class files for Data Members
 * to add to the DataMemberMap
 * @author Andrew Wimer
 */
public interface DataMemberParser {
   
   
   
   
   /**
    * Parses the file for data members to add to the DataMemberMap
    */
   public DataMemberMap parseFile(String filePath) 
           throws FileNotFoundException;
   
   /**
    * Returns true if the parser is in the middle of comment block, or scans
    * a comment line. 
    * Return false when line is not part of comment
    * @return 
    */
   public boolean isComment(String line);

   /**
    * Parses a list of data members in a file formatted in a list such that
    * each line contains one data member, which consists of a one-word 
    * data type and one-word identifier
    */
   public DataMemberMap parseFromListInFile(String filePath) 
           throws FileNotFoundException;
}
