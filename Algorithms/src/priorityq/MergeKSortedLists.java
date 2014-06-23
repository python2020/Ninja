package priorityq;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import lists.ListNode;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) { 
		if (lists == null) return null;

		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode n1, ListNode n2) {
				if (n1.val == n2.val) return 0;
				if (n1.val < n2.val) return -1;
				return 1;
			}
		};

		int k = lists.size();
		if (k == 0) return null;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, comparator);

		for (ListNode head : lists) 
			if (head != null) minHeap.add(head);

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		while (!minHeap.isEmpty()) {
			tail.next = minHeap.remove();
			tail = tail.next;
			if (tail.next != null) minHeap.add(tail.next);
		}

		return dummy.next;      
	}
}
