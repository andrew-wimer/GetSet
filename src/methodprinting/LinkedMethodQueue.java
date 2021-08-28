/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 11 2021
* LAST UPDATE:  Aug 11 2021
*/

package methodprinting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CLASS DESCRIPTION: Represents a linked list queue of getter/ setter
 * methods/functions to print
 * @author Andrew Wimer
 * 
 */
public class LinkedMethodQueue implements MethodQueue {

   protected Queue<String> queue = new LinkedList();
   
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
   

}
