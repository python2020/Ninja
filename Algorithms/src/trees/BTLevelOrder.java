package trees;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrder {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;

		ArrayList<Integer> level; 
		ArrayList<TreeNode> curr = new ArrayList<TreeNode>(), next = null;
		curr.add(root);

		while (!curr.isEmpty()) {
			next = new ArrayList<TreeNode>();
			level = new ArrayList<Integer>();

			for (TreeNode n : curr) {
				if (n.left != null) next.add(n.left);
				if (n.right != null) next.add(n.right);
				level.add(n.val);
			}

			res.add(0, level); // inefficient. Should use recursion.
			curr = next;                            
		}

		return res;    
	}

    public List<List<Integer>> levelOrder(TreeNode root) {
    	return levelOrderInterative(root);
    }
    
    public List<List<Integer>> levelOrderInterative(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;

		ArrayList<Integer> level; 
		ArrayList<TreeNode> curr = new ArrayList<TreeNode>(), next = null;
		curr.add(root);

		while (!curr.isEmpty()) {
			next = new ArrayList<TreeNode>();
			level = new ArrayList<Integer>();

			for (TreeNode n : curr) {
				if (n.left != null) next.add(n.left);
				if (n.right != null) next.add(n.right);
				level.add(n.val);
			}

			res.add(level);
			curr = next;                            
		}

		return res;          
    }
    
    //public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        
    //}
}
