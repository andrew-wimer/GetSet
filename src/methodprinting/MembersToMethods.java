/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 22 2021
* LAST UPDATE: Aug 22 2021
*/

package methodprinting;

import datamemberparse.DataMemberMap;

/**
 * INTERFACE DESCRIPTION:  MembersToMethods uses a DataMembeMap to 
 * generate a queue of getters and a queue of setters for each data member.
 * @author Andrew Wimer
 */
public interface MembersToMethods {
   
   public MethodQueue[] generateMethodQueues(DataMemberMap dMM);

}
