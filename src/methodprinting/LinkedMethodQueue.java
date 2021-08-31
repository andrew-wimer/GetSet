/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 11 2021
* LAST UPDATE:  Aug 29 2021
*/

package methodprinting;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * CLASS DESCRIPTION: Represents a linked list queue of getter/ setter
 * methods/functions to print
 * @author Andrew Wimer
 * Aug 29 2021 - added equals, empty, toString, and size methods
 * 
 */
public class LinkedMethodQueue implements MethodQueue {

   protected LinkedList<String> queue = new LinkedList();
   
   /**
    * Inserts the specified element into this queue if it is possible to do so immediately
    *without violating capacity restrictions, 
    * @param method
    * @return 
    */
   @Override
   public boolean offer(String method) {
      return queue.offer(method);
   }

   /**
    * Retrieves and removes the head of this queue
    * @return head of queue, null if queue is empty
    */
   @Override
   public String remove() {
      return queue.remove();
   }

   /**
    * Retrieves, but does not remove, the head of this queue.
    * @return head of queue
    */
   @Override
   public String peek() {
      return queue.peek();
   }

   /**
    * Retrieves and removes the head of this queue
    * @return head of queue, null if queue is empty
    */
   @Override
   public String poll() {
      return queue.poll();
   }

   /**
    * Retrieves, but does not remove, the head of this queue.
    * @return head of queue
    */
   @Override
   public String element() {
      return queue.element();
   }

   @Override
   /**
    * Inserts the specified element into this queue if it is possible to do so immediately
    *without violating capacity restrictions, 
    * @return true upon success 
    * @throws IllegalStateException if no space is available.
    */
   public boolean add(String method) {
      return queue.add(method);
   }
   
   /**
    * Return true if queue is equal to another queue
    * @param anObject
    * @return 
    */
   public boolean equals(LinkedMethodQueue list) { 
          
      if (list.size() != queue.size())
         return false;
      for (int i = 0; i < queue.size(); i++)
      {
         String s = queue.get(i);
         String t = list.get(i);
         if (!s.equals(t))
            return false;
      }
      return true; 
   }    
   
   /**
    * Return true if queue is empty
    * @return 
    */
   public boolean isEmpty()
   {
      return queue.isEmpty();
   }
   
   public String get(int index)
   {
      return queue.get(index);
   }
   
   /**
    * Returns size of queue.
    * @return 
    */
   public int size()
   {
      return queue.size();
   }
   
   /**
    * Returns methodqueue as a string
    */
   public String toString()
   {
      String asString = "";
      for(String s : queue)
      {
         asString += s;
      }
      
      return asString;
   }
}
