package lists;

public class SwapPairNodes {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode l = dummy, p = null;
		while (l.next != null && l.next.next != null) {
			p = l.next;
			l.next = p.next;
			p.next = l.next.next;
			l.next.next = p;
			l = l.next.next;        
		}

		return dummy.next;
	}
}
