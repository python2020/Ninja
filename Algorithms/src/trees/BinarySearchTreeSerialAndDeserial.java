package trees;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinarySearchTreeSerialAndDeserial {

		public String serialize(TreeNode root) {
			StringBuffer bf = new StringBuffer();
			serializeHelper(root, bf);
			return bf.toString(); 
		}
		
		public void serializeHelper(TreeNode root, StringBuffer bf) {
			// need to encode null nodes
			if (root != null) {
				bf.append(String.valueOf(root.val) + " ");
				serializeHelper(root.left, bf);
				serializeHelper(root.right, bf);
			}
		}
		
		public TreeNode deserialize(String input) {

			ArrayList<String> numStrs = new ArrayList<String>();
			StringBuffer bf = new StringBuffer();
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
			
			MyIterator<String> myit = new MyIterator<String>(it); //!!!!!!! NOTE STRING!
			
			return deserializeHelper(myit, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		public class MyIterator<T> implements Iterator<T> {
			private Iterator<T> it = null;
			private T current = null;
		
			public MyIterator(Iterator<T> itertor) {
				it = itertor;
				if (it.hasNext()) current = it.next();
			}
			
			public T peek() {
				return current;
			}
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				if (!hasNext()) throw new NoSuchElementException();
				
				T data = current;
				if (it.hasNext()) current = it.next();
				else current = null;
				return data;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		
		public TreeNode deserializeHelper(MyIterator<String> it, int min, int max) {
			TreeNode node = null;
			String strValue = it.peek(); 
			if (strValue != null) {
				int val = Integer.parseInt(strValue);
				if (min <= val && val <= max) {
					it.next(); // "mark" used
					node = new TreeNode(val);
					node.left = deserializeHelper(it, min, val);
					node.right = deserializeHelper(it, val, max);
				}
			}
			return node;
		}
		
		public static void main(String[] args) {
			BinarySearchTreeSerialAndDeserial x = 
					new BinarySearchTreeSerialAndDeserial();
			
			BTFromInorderPreorder t = new BTFromInorderPreorder();
			
			int[] preorder = {30, 20, 10, 40, 35, 50};
			int[] inorder = {10, 20, 30, 35, 40, 50};
			
			TreeNode root = t.buildTree(preorder, inorder);
			//if (root == null) System.out.println("root is null");
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

