package trees;

import lists.ListNode;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		ListNode x = head;
		while (x != null) { x = x.next; length++; }
		
		ListNode[] curr = new ListNode[1];
		curr[0] = head;
		
		return helper(curr, length);
	}

	public TreeNode helper(ListNode[] curr, int length) {
		if (length <= 0) return null;

		int half = length >> 1;     

		TreeNode l = helper(curr, half);
		
		TreeNode root = new TreeNode(curr[0].val);
		
		curr[0] = curr[0].next; // advance to the next node!
		
		root.left = l;
		root.right = helper(curr, length-half-1);

		return root;    
	}
}