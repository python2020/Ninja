package com.python2020.trees;

import java.util.ArrayList;
import java.util.Stack;

public class BTPostorder {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		if (root == null) return res;

		TreeNode v = null, n = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		while (!stack.empty()) {
			n = stack.peek();

			if (v == null || v.left == n || v.right == n) {
				if (n.left != null) {
					stack.push(n.left);
				} else if (n.right != null) {
					stack.push(n.right);
				} else {
					res.add(n.val);
					stack.pop();
				}
			} else {
				if (n.left == v) {
					if (n.right != null) {
						stack.push(n.right);
					} else {
						res.add(n.val);
						stack.pop();
					}
				} else {
					res.add(n.val);
					stack.pop();
				}
			}

			v = n;
		}
		
/*        while (!stack.empty()) {
            n = stack.peek();
            
            if (v == null || v.left == n || v.right == n) {
                v = n;
                if (n.left != null) {
                    stack.push(n.left);
                    continue;
                } else if (n.right != null) {
                    stack.push(n.right);
                    continue;
                }
            } else {
                if (n.left == v && n.right != null) {
                    v = n;
                    stack.push(n.right);
                    continue;
                }
            }
            res.add(n.val);
            stack.pop();
            v = n;
        }*/
        
		return res;   
	}
}
