package lists;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode x = head;
		ListNode y = dummy;
		ListNode p = null;

		while (x != null) {
			if (y.next == null || y.next.val >= x.val) {
				p = y.next;
				y.next = x;
				x = x.next;
				y.next.next = p;  // 1
				y = dummy;			// 2
			} else {
				y = y.next;
			}
		}

		return dummy.next;   
	}
}
