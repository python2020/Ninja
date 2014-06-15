package com.python2020.trees;

public class SymmetricBT {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetricHelper(root.left, root.right);
	}

	public boolean isSymmetricHelper(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) return true;
		if (n1 == null || n2 == null || n1.val != n2.val) return false;
		return isSymmetricHelper(n1.left, n2.right) && isSymmetricHelper(n1.right, n2.left);
	}
}
