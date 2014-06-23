package trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
	public int numTrees(int n) {
		if (n <= 1) return 1;
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += numTrees(i-1) * numTrees(n-i); // i => root
		}
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
