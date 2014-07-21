package lists;

public class EvenOddReorder {
	public static void reorder(ListNode head) {
		if (head == null) return;
		
		ListNode f = head, s = head.next, h2 = s;
		
		while (s != null) {
			f.next = s.next;
			if (f.next == null) break;
			f = f.next;
			
			s.next = f.next;
			s = s.next;
		}
		
		f.next = h2;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		ListNode l = ListNodeUtil.makeList(a);
		reorder(l);
		ListNodeUtil.printList(l);
		
		int[] b = {1,2,3,4};
		l = ListNodeUtil.makeList(b);
		reorder(l);
		ListNodeUtil.printList(l);
	}
}
