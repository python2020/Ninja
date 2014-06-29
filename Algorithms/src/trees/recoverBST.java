package trees;

import java.util.Stack;

public class recoverBST {
	public void recoverTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null, curr = root;
		TreeNode first = null, second = null;

		while (!stack.empty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop(); 
				// visit
				if (prev != null) {
					if (prev.val > curr.val) {
						if (first == null) {
							first = prev;
							second = curr; // ! must record
						} else {
							second = curr;
							break; // find the pair
						}
					}
				}
				prev = curr;
				curr = curr.right;
			}
		}

		if (first == null) return; // non-existing

		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;            
	}
}
