package lists;

public class ListNodeUtil {
    public static ListNode makeList(int[] num) {
    	ListNode head = new ListNode(0), p = head;
    	for (int i = 0; i < num.length; i++) {
    		p.next = new ListNode(num[i]);
    		p = p.next;
    	}
    	return head.next;
    }
    
    public static void printList(ListNode head) {
    	while (head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
   
}
