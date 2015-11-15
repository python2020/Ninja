package trees;

public class MinDepthBT {
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	
    	int leftDepth = minDepth(root.left);
    	int rightDepth = minDepth(root.right);
    	
    	if (leftDepth == 0 && rightDepth == 0) return 1;
    	
    	if (leftDepth == 0 || rightDepth == 0) return Math.max(leftDepth, rightDepth) + 1;  //!
    	
    	return Math.min(leftDepth, rightDepth) + 1; //!
    }
}
