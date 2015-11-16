package trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;

		return numTreesHelper(n, dp);
	}

	public int numTreesHelper(int n, int[] dp) {
		if (dp[n] != 0) return dp[n];

		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += numTreesHelper(i-1, dp) * numTreesHelper(n-i, dp); // i => root
		}

		dp[n] = total;

		return total;
	}

	public List<TreeNode> generateTrees(int n) { 
		return generateTrees(1, n);
	}

	public ArrayList<TreeNode> generateTrees(int l, int r) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (l > r) { res.add(null); return res; } 
		if (l == r) { res.add(new TreeNode(l)); return res; }


		ArrayList<TreeNode> left = null, right = null;
		TreeNode n = null;

		for (int i = l; i <= r; i++) {
			left = generateTrees(l, i-1);
			right = generateTrees(i+1, r);
			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					n = new TreeNode(i);
					n.left = lnode;
					n.right = rnode;
					res.add(n);
				}
			}
		}

		return res;
	}
}
