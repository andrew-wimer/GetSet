/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 30 2021
* LAST UPDATE: Aug 31 2021
*/

package methodprinting;

import datamemberparse.DataMemberMap;
import methodformats.JavaGetter;
import methodformats.JavaSetter;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew Wimer <andrew.wimer at https://github.com/andrew-wimer>
 */
public class JavaMemsToMethodsTest {
   
   public JavaMemsToMethodsTest() {
      
   }

   /**
    * Test of generateMethodQueues method, of class JavaMemsToMethods.
    */
   @Test
   public void testGenerateMethodQueues() {
      JavaMemsToMethods instance = new JavaMemsToMethods();
      DataMemberMap dMM = new DataMemberMap();
      String returnType = "int";
      String identifier = "number";
      dMM.put(identifier, returnType);
      
      MethodQueue[] mQ = new MethodQueue[2];
      mQ = instance.generateMethodQueues(dMM);
     
      MethodQueue[] expMQ = new LinkedMethodQueue[2];
      expMQ[0] = new LinkedMethodQueue();
      expMQ[1] = new LinkedMethodQueue();
      JavaGetter expGet = new JavaGetter();
      JavaSetter expSet = new JavaSetter();
      expMQ[0].offer(expGet.writeGetter(identifier, returnType));
      expMQ[1].offer(expSet.writeSetter(identifier, returnType));
         
      for (int i = 0; i < expMQ.length; i++)
      assertEquals(expMQ[i].getQueue(), mQ[i].getQueue());
      
   }

   /**
    * Test of fileFormattedMethodQueues method, of class JavaMemsToMethods.
    */
   @Test
   public void testFileFormattedMethodQueues() {
      JavaMemsToMethods instance = new JavaMemsToMethods();
      DataMemberMap dMM = new DataMemberMap();
      String returnType = "int";
      String identifier = "number";
      dMM.put(identifier, returnType);
      
      MethodQueue[] mQ = new MethodQueue[2];
      mQ = instance.fileFormattedMethodQueues(dMM);
     
      MethodQueue[] expMQ = new LinkedMethodQueue[2];
      expMQ[0] = new LinkedMethodQueue();
      expMQ[1] = new LinkedMethodQueue();
      JavaGetter expGet = new JavaGetter();
      JavaSetter expSet = new JavaSetter();
      expMQ[0].offer(expGet.writeFileFormattedGetter(identifier, returnType));
      expMQ[1].offer(expSet.writeFileFormattedSetter(identifier, returnType));
      
      for (int i = 0; i < expMQ.length; i++)
      Assert.assertEquals(expMQ[i].getQueue(), mQ[i].getQueue());
      
   }

   /**
    * Test of initializeArrayMethodQueue method, of class JavaMemsToMethods.
    * Initialization is equal if both methodqueues in both expected and actual
    * results are of size 0.
    */
   @Test
   public void testInitializeArrayMethodQueue() {
      JavaMemsToMethods instance = new JavaMemsToMethods();
      MethodQueue[] mQ = new MethodQueue[2];
      mQ = instance.initializeArrayMethodQueue(mQ);
      
      MethodQueue[] expMQ = new MethodQueue[2];
      expMQ[0] = new LinkedMethodQueue();
      expMQ[1] = new LinkedMethodQueue();
      
      for (int i = 0; i < expMQ.length; i++)
      assertEquals(expMQ[i].size(), mQ[i].size());
   }
   
}
