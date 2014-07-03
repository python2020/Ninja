package lists;



public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;
		RandomListNode node = head, nodeCopy = null;
		
		while (node != null) {
			nodeCopy = new RandomListNode(node.label);
			nodeCopy.next = node.next;
			node.next = nodeCopy;
			node = nodeCopy.next; // Move to the next node
		}
		
		
		RandomListNode headCopy = head.next;
		
		node = head;
		while (node != null) {
			nodeCopy = node.next;
			if (node.random == null) nodeCopy.random = null;
			else nodeCopy.random = node.random.next;
			node = node.next.next;
		}
		
		node = head;
		nodeCopy = headCopy;
		while (node != null) {
			node.next = node.next.next;
			node = node.next;
			if (node == null) break;
			nodeCopy.next = nodeCopy.next.next;
			nodeCopy = nodeCopy.next;
		}
		
		return headCopy;
	}
	
	public static void main(String[] args) {
		CopyListWithRandomPointer x = new CopyListWithRandomPointer();
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		a.next = b;
		a.random = b;
		b.next = c;
		b.random = b;
		c.next = null;
		c.random = null;
		
		RandomListNode node = x.copyRandomList(a);
		while (node != null) {
			System.out.println(node.label);
			if (node.random != null) System.out.println(node.random.label);
			else System.out.print("null");
			System.out.println();
			node = node.next;
		}
		
	}
}
