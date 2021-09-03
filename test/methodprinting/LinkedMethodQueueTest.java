/*
 * PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 11 2021
* LAST UPDATE:  Aug 31 2021
 */
package methodprinting;

import methodprinting.MethodQueue;
import methodprinting.LinkedMethodQueue;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andr00
 */
public class LinkedMethodQueueTest {
   
   public LinkedMethodQueueTest() {
   }

   /**
    * Test of offer method, of class LinkedMethodQueue.
    */
   @Test
   public void testOffer() {
      MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      boolean result = instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      boolean expResult = queue.add(getterMethod);
      assertEquals(expResult, result);
      
   }

   /**
    * Test of remove method, of class LinkedMethodQueue.
    */
   @Test
   public void testRemove() {
      MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      queue.add(getterMethod);
      String result = instance.remove();
      String expResult = queue.remove();
      assertEquals(expResult, result);
   }

   /**
    * Test of peek method, of class LinkedMethodQueue.
    */
   @Test
   public void testPeek() {
       MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      queue.add(getterMethod);
      String result = instance.peek();
      String expResult = queue.peek();
      assertEquals(expResult, result);
   }

   /**
    * Test of poll method, of class LinkedMethodQueue.
    */
   @Test
   public void testPoll() {
      MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      queue.add(getterMethod);
      String result = instance.poll();
      String expResult = queue.poll();
      assertEquals(expResult, result);
   }

   /**
    * Test of element method, of class LinkedMethodQueue.
    */
   @Test
   public void testElement() {
       MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      queue.add(getterMethod);
      String result = instance.element();
      String expResult = queue.element();
      assertEquals(expResult, result);
      
      
   }
   
   /**
    * Test of getQueue method, of class LinkedMethodQueue.
    */
   @Test
   public void testGetQueue() {
      LinkedMethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      instance.add(getterMethod);
      LinkedList<String> queue = new LinkedList();
      queue.add("public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}");
      assertEquals(queue, instance.getQueue());
   }

   /**
    * Test of add method, of class LinkedMethodQueue.
    */
   @Test
   public void testAdd() {
      MethodQueue instance = new LinkedMethodQueue();
      String getterMethod = "public int getNumber()\n" +
      "{\n" + "   return number;\n" + "}";
      boolean result = instance.add(getterMethod);
      Queue<String> queue = new LinkedList();
      boolean expResult = queue.add(getterMethod);
      assertEquals(expResult, result);
      
   }
   
}
