
/**
* PROGRAMMED BY: Andrew Wimer
* DESCRIPTION: 
* DATE CREATED: Aug 7 2021
* LAST UPDATED: Aug 21 2021
*/

package getset;

import java.io.IOException;

/**
 * GetSet writes setter and getter methods/functions in a specified language
 *  that uses Object-Oriented programming.
 * As of V1, GetSet only writes Java methods, and only writes one method at a
 * time. (Aug 8 2021)
 * @author Andrew Wimer
 * 
 * Aug 21 2021 - moved menu system to GetSetProgram class. GetSet.java will
 * now serve as the entry/main method class for the Getter Setter Program
 */
public class GetSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
       GetSetProgram gsPrgrm = new GetSetProgram(args);
       gsPrgrm.start();
       
    }

}
