/**
* PROGRAMMED BY: Andrew Wimer
* CREATED ON:
* LAST UPDATE: 
*/

package leetcodechallenges;

/**
 * CLASS DESCRIPTION:
 * @author Andrew Wimer
 * 
 */
public class ListNode {
 Integer val;
    ListNode next;
    
    
    // CONSTRUCTORS//
     public ListNode() {
     }
     
     public ListNode(int val) { 
         this.val = val; 
     }
     
     ListNode(int val, ListNode next) { 
         this.val = val; 
         this.next = next;
      }
     
     
     //MUTATORS //
     
     public void add(Integer val)
     {
        this.next = new ListNode(val);
     }
     
     
     // ACCESSORS //
     
     public boolean isEmpty()
     {
        return (this.val == null);
     }
     

	public Integer getVal()
	{
		return val;
	}


	public ListNode getNext()
	{
		return next;
	}


	public void setVal(Integer val)
	{
		this.val = val;
	}


	public void setNext(ListNode next)
	{
		this.next = next;
	}

}
