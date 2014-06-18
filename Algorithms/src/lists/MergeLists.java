package lists;

public class MergeLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), t = dummy;
        dummy.next = l1;
        ListNode p1;
        while (t.next != null && l2 != null) {
            if (t.next.val > l2.val) {
                p1 = t.next;
                t.next = l2;
                l2 = l2.next;
                t.next.next = p1;
            }
            t = t.next;
        }
        
        if (l2 != null) t.next = l2;
        
        return dummy.next;
    }
}
