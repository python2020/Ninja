package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        ArrayList<Integer> level = null;
        Stack<TreeNode> curr = new Stack<TreeNode>(), next = null;
        boolean ltor = true;
        curr.push(root);
        TreeNode n = null;
        
        while (!curr.isEmpty()) {
            next = new Stack<TreeNode>();
            level = new ArrayList<Integer>();
            
            if (ltor) {
                do {
                    n = curr.pop();
                    level.add(n.val);
                    if (n.left != null) next.push(n.left);
                    if (n.right != null) next.push(n.right);   
                } while (!curr.isEmpty()); 
            } else {
                do {
                    n = curr.pop();
                    level.add(n.val);
                    if (n.right != null) next.push(n.right);   
                    if (n.left != null) next.push(n.left);
                } while (!curr.isEmpty());            
            }
            
            res.add(level);
            ltor = !ltor;
            curr = next;
        }
        
        return res;
    }
}
