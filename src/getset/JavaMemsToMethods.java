/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 22 2021
* LAST UPDATE: Aug 23 2021
*/

package getset;

/**
 * CLASS DESCRIPTION: JavaMemsToMethods uses a DataMembeMap to 
 * generate a queue of getters and a queue of setters for each Java data member.
 * @author Andrew Wimer
 * Aug 23 2021 - generatedMethodQueues now uses 
 * writeFileFormatted versions of Getters and Setters
 */
public class JavaMemsToMethods implements MembersToMethods{

   /**
    * Converts the identifier-datatype mappings in the DataMemberMap
    * to two queues (getter queue and setter queue) in an array.
    * @param dMM the mapping of identifiers to data types that will
    * be generated into method queues
    * @return 
    */
   @Override
   public MethodQueue[] generateMethodQueues(DataMemberMap dMM) {
      //Getters will be placed in index 0 of the MethodQueue Array, 
      //Setters will be placed in index 1 of the MethodQueue Array
      MethodQueue[] getsSets = new LinkedMethodQueue[2];
      
      for(int i = 0; i < getsSets.length; i++)
      {
         getsSets[i] = new LinkedMethodQueue();
      }
      
      for (String key : dMM.keySet())
      {
         JavaGetter jG = new JavaGetter();
         JavaSetter jS = new JavaSetter();
         getsSets[0].offer(jG.writeFileFormattedGetter(key, dMM.get(key)));
         getsSets[1].offer(jS.writeFileFormattedSetter(key, dMM.get(key)));
      }
      
      return getsSets;
   }
   
   
}
