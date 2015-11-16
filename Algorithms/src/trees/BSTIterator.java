package trees;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode p = null;
    private Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        p = root;
        stack = new Stack<TreeNode>();         
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        
        return !stack.isEmpty();     
    }

    /** @return the next smallest number */
    public int next() {
        p = stack.pop();
        int val = p.val;
        p = p.right;
        
        return val;        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
