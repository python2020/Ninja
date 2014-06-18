package lists;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        
        slow.next = null;
        
        return head;            
    }
}
