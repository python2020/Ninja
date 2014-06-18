package trees;

public class PopulatingNextRightPointer {
	public void connect(TreeLinkNode root) {
		if (root == null) return;

		TreeLinkNode curr = root, nextStart = curr.left;

		while (nextStart != null) {
			while (true) {
				curr.left.next = curr.right;
				if (curr.next == null) break;
				curr.right.next = curr.next.left;
				curr = curr.next;
			}
			curr = nextStart;
			nextStart = nextStart.left;
		}    
	}
}
