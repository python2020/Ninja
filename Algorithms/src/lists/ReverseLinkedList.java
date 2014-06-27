package lists;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null) return head;
    	if (m == n) return head;
    	
    	ListNode dummy = new ListNode(0); // m could be 1
    	dummy.next = head;
    	ListNode p = dummy, q = null, r = null, before = null, tail = null;
    	
    	// locate m
    	while (m > 1) {
    		p = p.next;
    		m--;
    		n--;
    	}
    	before = p;
    	p = p.next;
    	tail = p;
    	n--;
    	
    	// reverse
    	q = p.next;   // p q r
    	
    	while (n > 0) {
    		r = q.next;
    		q.next = p;
    		p = q;
    		q = r;
    		n--;
    	}
    	
    	// link
    	before.next = p;
    	tail.next = r;
    	
    	return dummy.next;
    }
    
    
    public static void main(String[] args) {
    	int[] num = {1, 2, 3};
    	ListNode head = ListNodeUtil.makeList(num);
    	ReverseLinkedList x = new ReverseLinkedList();
    	head = x.reverseBetween(head, 1, 3);
    	ListNodeUtil.printList(head);
    }
}
