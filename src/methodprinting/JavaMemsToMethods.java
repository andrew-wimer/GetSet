/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 22 2021
* LAST UPDATE: Aug 27 2021
*/

package methodprinting;

import datamemberparse.DataMemberMap;
import methodprinting.MembersToMethods;
import methodformats.JavaSetter;
import methodformats.JavaGetter;

/**
 * CLASS DESCRIPTION: JavaMemsToMethods uses a DataMembeMap to 
 * generate a queue of getters and a queue of setters for each Java data member.
 * @author Andrew Wimer
 * Aug 27 2021 - initialization of methodqueue arrays in each method
 * moved to separate method
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
      
      getsSets = initializeArrayMethodQueue(getsSets);
      
      for (String key : dMM.keySet())
      {
         JavaGetter jG = new JavaGetter();
         JavaSetter jS = new JavaSetter();
         getsSets[0].offer(jG.writeGetter(key, dMM.get(key)));
         getsSets[1].offer(jS.writeSetter(key, dMM.get(key)));
      }
      
      return getsSets;
   }
   
   public MethodQueue[] fileFormattedMethodQueues(DataMemberMap dMM)
   {
      //Getters will be placed in index 0 of the MethodQueue Array, 
      //Setters will be placed in index 1 of the MethodQueue Array
      MethodQueue[] getsSets = new LinkedMethodQueue[2];
      
      getsSets = initializeArrayMethodQueue(getsSets);
      
      for (String key : dMM.keySet())
      {
         JavaGetter jG = new JavaGetter();
         JavaSetter jS = new JavaSetter();
         getsSets[0].offer(jG.writeFileFormattedGetter(key, dMM.get(key)));
         getsSets[1].offer(jS.writeFileFormattedSetter(key, dMM.get(key)));
      }
      
      return getsSets;
   }
   
   /**
    * Initializes the two method queues in the method queue 
    * array.
    * @param getsSets
    * @return 
    */
   public MethodQueue[] initializeArrayMethodQueue(MethodQueue[] getsSets)
   {
      for(int i = 0; i < getsSets.length; i++)
      {
         getsSets[i] = new LinkedMethodQueue();
      }
      
      return getsSets;
   }
   
   
}
