package lists;

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null) return;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode s = dummy, f = dummy;

		while (f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
		}

		if (f.next != null) s = s.next; // 1st half: n+1, 2nd: n

		ListNode x = null, y = s.next, z = null;
		while (y != null) {
			z = y.next;
			y.next = x;
			x = y;
			y = z;
		}

		s.next = null; // tail of 1st half
		ListNode head2 = x;

		while (head2 != null) {
			x = head.next;
			head.next = head2;
			head2 = head2.next;
			head.next.next = x;
			head = x;
		}

		head = dummy.next;
	}
}
