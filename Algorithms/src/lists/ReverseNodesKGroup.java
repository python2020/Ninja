package lists;

public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {       
    	if (k <= 1) return head;
    	
    	ListNode dummy = new ListNode(0), h = dummy, p, q, rev, tail = head;
    	dummy.next = head;
    	int n;
    	
    	while (true) {
    		n = 0;
    		// Get to the end of the k group
    		while(tail != null) {
    			n++;
    			if (n == k) break;
    			tail = tail.next;
    		}
    		if (n < k)	break;
    		
    		head = h.next;   // h -> {[head (stays), rev (moves)] -> q -> .... -> tail} -> p
    		rev = h.next;
    		q = rev.next;
    		p = tail.next;
    		
    		while (true) {
    			rev.next = p;
    			if (rev == tail) break;
    			p = rev; // !!!
    			rev = q;
    			q = q.next;
    		}
    		h.next = tail; // ! Connect with the previous k group
    		h = head; // Original head of the k group
    		tail = head.next; 
    	}
    	
    	return dummy.next;
    
    }
}
