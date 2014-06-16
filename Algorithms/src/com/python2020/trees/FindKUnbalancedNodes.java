package com.python2020.trees;

// untested 

public class FindKUnbalancedNodes {
	public static TreeNode findKUnbalancedNodes(TreeNode root, int k) {
		TreeNode[] result = new TreeNode[1];
		result[0] = null;
		
		findKUnbalancedNodesHelper(root, k, result);
		
		return result[0];
	} 
	
	public static int findKUnbalancedNodesHelper(TreeNode n, int k, TreeNode[] result) {
		if (result[0] != null) return 0;
		if (n == null) return 0;
		
		int left = findKUnbalancedNodesHelper(n.left, k, result);
		int right = findKUnbalancedNodesHelper(n.right, k, result);
		
		if (Math.abs(left - right) > k) {
			result[0] = n;
			return 0;
		} else {
			return left + right + 1; 
		}
	}
}
