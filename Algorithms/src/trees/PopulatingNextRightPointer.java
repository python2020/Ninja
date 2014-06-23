package trees;

public class PopulatingNextRightPointer {
	// complete binary tree
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

	// incomplete binary tree
	public void connect2(TreeLinkNode root) {
		TreeLinkNode head = root, tail = null, curr = null;

		while (head != null) {
			curr = head;
			head = null;

			while (curr != null) {
				if (curr.left != null) {
					if (head == null) { 
						head = curr.left;
						tail = head;
					} else { 
						tail.next = curr.left;
						tail = tail.next;
					}
				}
				if (curr.right != null) {
					if (head == null) { 
						head = curr.right;
						tail = head;
					} else { 
						tail.next = curr.right;
						tail = tail.next;
					}
				}
				curr = curr.next;
			} 
		}
	}
}
