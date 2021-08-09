
/**
* PROGRAMMED BY: Andrew Wimer
* DESCRIPTION: 
* DATE CREATED: Aug 7 2021
* LAST UPDATED: Aug 8 2021
*/

package getset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GetSet writes setter and getter methods/functions in a specified language
 *  that uses Object-Oriented programming.
 * As of V1, GetSet only writes Java methods, and only writes one method at a
 * time. (Aug 8 2021)
 * @author Andrew Wimer
 */
public class GetSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
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
    }

}
