package smallcompany;

import java.util.Stack;

import object.ListNode;

/**
 * Question: How can you reverse a linked list?
 * Follow up: How can you determine if a list is palindrome? (many ways to solve it such as: reverse, stack (2 runners)...)
 * @author Jian Xu
 *
 */
public class PalindromeLinkedList {
	
	/**
	 * Use stack data structure.
	 *
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        Stack<ListNode> stack = new Stack<>();
        int len = 0;
        // determine odd/even length 
        boolean isOddElement = false;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }
        isOddElement = len % 2 == 0 ? false : true;
        int temp = 0;
        while(temp < len/2){
            stack.push(head);
            head = head.next;
            temp++;
        }
        
        // find the middle point based on odd/even length
        if(isOddElement){
            head = head.next;
        }
        
        // compare
        while(head != null){
            ListNode node = stack.pop();
            if(node.val != head.val){
                return false;
            }
            head = head.next;
        }
        
        return true;
    }
	
	/**
	 * Reverse the entire linked list.
	 *
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(ListNode head, boolean reverseNeeded) {
	    if(head == null)
	        return true;
	 
	    ListNode p = head;
	    ListNode prev = new ListNode(head.val);
	 
	    while(p.next != null){
	        ListNode temp = new ListNode(p.next.val);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	 
	    ListNode p1 = head;
	    ListNode p2 = prev;
	 
	    while(p1!=null){
	        if(p1.val != p2.val)
	            return false;
	 
	        p1 = p1.next;
	        p2 = p2.next;
	    } 
	    return true;
	}

}
