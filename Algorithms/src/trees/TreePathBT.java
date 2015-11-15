package trees;

import java.util.ArrayList;
import java.util.List;

public class TreePathBT {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<String>();
    	String path = "";
    	
    	binaryTreePaths(root, path, res);
    	
    	return res;
    }
    
    public void binaryTreePaths(TreeNode root, String path, List<String> res) {
    	if (root == null) return;
    	
    	String currPath = null;
    	
    	if (path.length() == 0) currPath = Integer.toString(root.val);
    	else currPath = path + "->" + Integer.toString(root.val);
    	
    	if (root.left == null && root.right == null) {
    		res.add(currPath);
    	} else {
    		binaryTreePaths(root.left, currPath, res);
    		binaryTreePaths(root.right, currPath, res);
    	}
    }
}
