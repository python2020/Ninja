package com.python2020.lists;

public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		while (fast.next != null && n > 0) {
			n--;
			fast = fast.next;
		}

		if (n == 0) {
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next; // slow.next;
		}

		return dummy.next;
	}
}
