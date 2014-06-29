package trees;

public class ConvertSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null) return null;
		return helper(num, 0, num.length-1);    
	}

	public TreeNode helper(int[] num, int l, int r) {
		if (l > r) return null;
		int m = (l + r) >> 1;
		TreeNode root = new TreeNode(num[m]);
		root.left = helper(num, l, m-1);
		root.right = helper(num, m+1, r);
		return root;
	}
}
