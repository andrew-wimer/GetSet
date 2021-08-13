/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: August 12 2021
* LAST UPDATE: August 12 2021
*/

package getset;

/**
 * INTERFACE DESCRIPTION: DataMemberParse parses class files for Data Members
 * to add to the DataMemberMap
 * @author Andrew Wimer
 */
public interface DataMemberParser {
   
   /**
    * Opens file to read.
    */
   public void openFile();
   
   /**
    * Parses the file for data members to add to the DataMemberMap
    */
   public void parseFile();

}
