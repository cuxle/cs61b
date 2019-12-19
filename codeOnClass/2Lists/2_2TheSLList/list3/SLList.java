public class SLList {
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode (int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);

		size += 1;
	}

	public int getFirst() {
		return first.item;
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

	public void addLast(int last) {
		IntNode p = sentinel;

		size += 1;

		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(last, null);
		
	}

}