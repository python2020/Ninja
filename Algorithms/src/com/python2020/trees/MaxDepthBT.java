package com.python2020.trees;

public class MaxDepthBT {
	public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;		
	}
}
