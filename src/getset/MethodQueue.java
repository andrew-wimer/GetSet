/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON: Aug 11 2021
* LAST UPDATE: Aug 11 2021
*/

package getset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * INTERFACE DESCRIPTION: Method Queue represents a queue of methods generated
 * by classes that implement the Getter and/or Setter interface. The queue 
 * of methods ensures that both getters and setters will be printed in 
 * First-in, First-out basis.
 * @author Andrew Wimer
 */
public interface MethodQueue {
   
   //Queue<String> queue = new LinkedList();
   
   /**
    * Adds the specified element as the tail (last element) of this list.
    * @param method
    * @return 
    */
   public boolean offer(String method);
   
   public String remove();

   public String peek();
           
   public String poll();
   
   public String element();
   
   public boolean add(String method);
}
