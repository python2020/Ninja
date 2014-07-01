package trees;

import java.util.ArrayList;
import java.util.Iterator;


public class BinaryTreeSerialAndDeserial {
	
	public String serialize(TreeNode root) {
		StringBuffer bf = new StringBuffer();
		serializeHelper(root, bf);
		return bf.toString();
	}
	
	public void serializeHelper(TreeNode root, StringBuffer bf) {
		if (root == null) {
			bf.append("# "); // # + white space
		} else {
			bf.append(root.val + " "); // value + white space
			serializeHelper(root.left, bf);
			serializeHelper(root.right, bf);
		}
	}
	
	public TreeNode deserialize(String input) {

		ArrayList<String> numStrs = new ArrayList<String>();
		StringBuffer bf = new StringBuffer();
		// Parsing
		char c;
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);
			if (c == ' ') {
				numStrs.add(bf.toString());
				bf = new StringBuffer();
			} else {
				bf.append(c);
			}
		}

		Iterator<String> it = numStrs.iterator();

		return deserializeHelper(it);
	}
	
	public TreeNode deserializeHelper(Iterator<String> it) {
		TreeNode root = null;
		if (it.hasNext()) {
			String str = it.next();
			if (!str.equals("#")) {
				root = new TreeNode(Integer.parseInt(str));
				root.left = deserializeHelper(it);
				root.right = deserializeHelper(it);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeSerialAndDeserial x = 
				new BinaryTreeSerialAndDeserial();
		
		BTFromInorderPreorder t = new BTFromInorderPreorder();
		
		int[] preorder = {30, 20, 10, 40, 35, 50};
		int[] inorder = {10, 20, 30, 35, 40, 50};
		
		TreeNode root = t.buildTree(preorder, inorder);
		String se = x.serialize(root);
		System.out.println("Se: " + se);
		
		TreeNode deRoot = x.deserialize(se);
		se = x.serialize(root);
		System.out.println("De: " + se);
		BTPreorder pre = new BTPreorder();
		System.out.println(pre.preorderTraversal(deRoot));
		BTInorder in = new BTInorder();
		System.out.println(in.inorderTraversal(deRoot));
		
	}
}
