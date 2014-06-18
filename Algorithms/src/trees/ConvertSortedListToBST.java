package trees;

import lists.ListNode;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		ListNode x = head;
		while (x != null) { x = x.next; length++; }
		
		ListNode[] c = new ListNode[1];
		c[0] = head;
		
		return helper(c, length);
	}

	public TreeNode helper(ListNode[] c, int length) {
		if (length <= 0) return null;

		int half = length / 2;     

		TreeNode l = helper(c, half);
		
		TreeNode n = new TreeNode(c[0].val);
		c[0] = c[0].next;
		
		n.left = l;
		n.right = helper(c, length-half-1);

		return n;    
	}
}