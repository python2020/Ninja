package trees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }
    
    public boolean isValidBST(TreeNode root, int low, int high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return isValidBST(root.left, low, root.val) && 
                isValidBST(root.right, root.val, high);
    }
}
