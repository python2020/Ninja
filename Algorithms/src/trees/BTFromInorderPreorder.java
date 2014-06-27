package trees;

public class BTFromInorderPreorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);    
	}

	public TreeNode buildTree(int[] inorder, int is, int ie, int[] preorder, int ps, int pe) {
		if (is > ie) return null;

		TreeNode root = new TreeNode(preorder[ps]);
		int offset = 0;
		for (; offset + is <= ie; offset++) 
			if (root.val == inorder[offset + is]) break;

		root.left = buildTree(inorder, is, is+offset-1, preorder, ps+1, ps+offset);
		root.right = buildTree(inorder, is+offset+1, ie, preorder, ps+offset+1, pe);

		return root;
	}
}
