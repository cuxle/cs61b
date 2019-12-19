public class SLList<WHAT> {
	private class Node {
		public WHAT item;
		public Node next;

		public Node (WHAT i, Node n) {
			item = i;
			next = n;
		}
	}

	private Node sentinel;
	private int size;

	public SLList(WHAT x) {
		sentinel = new Node(x, null);
		sentinel.next = new Node(x, null);
		size = 1;
	}

	public void addFirst(WHAT x) {
		sentinel.next = new Node(x, sentinel.next);

		size += 1;
	}

	public WHAT getFirst() {
		return sentinel.next.item;
	}
/** 1. first step use recursive to size()
	public int size(IntNode p) {
		if (p == null) {
			return 0;
		}
		return 1 + size(p.next);
	}

	public int size() {
		return size(first);
	}
	*/

	public int size() {
		return size;
	}

	public void addLast(WHAT last) {
		Node p = sentinel;

		size += 1;

		while (p.next != null) {
			p = p.next;
		}

		p.next = new Node(last, null);
		
	}

}