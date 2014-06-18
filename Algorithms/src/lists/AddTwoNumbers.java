package lists;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode l3 = dummy;

		int sum = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			} 

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			l3.next = new ListNode(sum % 10);
			l3 = l3.next;

			sum = sum / 10; // carry
		}    

		if (sum == 1) l3.next = new ListNode(1);

		return dummy.next;        
	}
}
