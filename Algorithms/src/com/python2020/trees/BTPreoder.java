package com.python2020.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTPreoder {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		if (root == null) return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode n;
		while (!stack.empty()) {
			n = stack.pop();
			res.add(n.val);
			if (n.right != null) stack.push(n.right);
			if (n.left != null) stack.push(n.left);
		}

		return res;
	}
}
