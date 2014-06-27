package trees;

public class BTFromInorderPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);    
	}

	public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
		if (is > ie) return null;

		TreeNode root = new TreeNode(postorder[pe]);
		int offset = 0;
		for (; offset + is <= ie; offset++) 
			if (root.val == inorder[offset + is]) break;

		root.left = buildTree(inorder, is, is+offset-1, postorder, ps, ps+offset-1);
		root.right = buildTree(inorder, is+offset+1, ie, postorder, ps+offset, pe-1);

		return root;
	}
}
