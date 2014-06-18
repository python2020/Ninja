package trees;

public class BalancedBT {
	public boolean isBalanced(TreeNode root) {
		return isBalancedHelper(root) >= 0;
	}

	public int isBalancedHelper(TreeNode root) {
		if (root == null) return 0;

		int l = isBalancedHelper(root.left);
		if (l == -1) return -1;

		int r = isBalancedHelper(root.right);
		if (r == -1) return -1;

		return Math.abs(l-r) > 1 ? -1 : (Math.max(l, r) + 1);
	}
}
