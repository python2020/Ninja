package trees;

public class BTInvert {
    public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode rightNew = invertTree(root.left);
		TreeNode leftNew = invertTree(root.right);
		root.right = rightNew;
		root.left = leftNew;
		return root;        
    }
}
