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
    
    
    
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0), slow = dummy, fast = null;
        dummy.next = head;
        
        int v = 0;
        while (slow.next != null && slow.next.next != null) {
            if (slow.next.val != slow.next.next.val) {
                slow = slow.next;            
            } else {
                v = slow.next.val;
                fast = slow.next.next.next; // skip two elems
                while (fast != null && fast.val == v) 
                    fast = fast.next;
                
                slow.next = fast;
            }
        }    
        
        return dummy.next;
    }
}
