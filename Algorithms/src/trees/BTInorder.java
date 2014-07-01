package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorder {
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode n = root;

		while (!stack.empty() || n != null) {
			if (n != null) {
				stack.push(n);
				n = n.left;
			} else {
				n = stack.pop();
				res.add(n.val);
				n = n.right;
			}
		}

		return res;
	}
}
