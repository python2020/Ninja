package lists;

public class SortList {
	public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // !!

		ListNode dummy = new ListNode(0), fast = dummy, slow = dummy;
		dummy.next = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		fast = slow.next;
		slow.next = null;
		
		//return MergeLists.mergeTwoLists(sort(head), sort(fast));
		return mergeTwoLists(sortList(head), sortList(fast));
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0), t = dummy;
        dummy.next = l1;
        
        ListNode p1;
        while (t.next != null && l2 != null) {
            if (t.next.val > l2.val) {
                p1 = t.next;
                t.next = l2;
                l2 = p1;
            }
            t = t.next;
        }
        
        if (l2 != null) t.next = l2;
        
        return dummy.next;
    }
}
