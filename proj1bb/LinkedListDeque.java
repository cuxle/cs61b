public class LinkedListDeque<T> implements Deque<T> {
	private class Node {
	    T item;
	    Node prev;
	    Node next;

	    public Node(T t, Node next) {
	        item = t;
	        this.next = next;
        }
    }

    private Node sentF;
	private Node sentB;
	private int size;

	public LinkedListDeque() {
		sentF = null;
		sentB = null;
		size = 0;
	}

	public LinkedListDeque(LinkedListDeque<T> other) {
		if (other != null && other.size() > 0) {
			initSentinel(other.get(0));
			int size = other.size();
			for (int i = 0; i < size; i++) {
				addLast(other.get(i));
			}
		}
	}

	private void initSentinel(T item) {
		sentF = new Node(item, null);
		sentB = new Node(item, null);
		sentF.next = sentB;
		sentF.prev = sentB;
		sentB.prev = sentF;
		sentB.next = sentF;
		size = 0;
	}


	public LinkedListDeque(T t) {
		initSentinel(t);

		Node node = new Node(t, null);
		node.prev = sentF;
		node.next = sentB;
		sentF.next = node;
		sentB.prev = node;

		size = 1;
    }

	@Override
    public void addFirst(T item) {
		if (isEmpty()) {
			initSentinel(item);
		}

		Node node = new Node(item, null);
		node.prev = sentF;
		node.next = sentF.next;
		node.next.prev = node;
		sentF.next = node;
		size += 1;
	}

	@Override
	public void addLast(T item) {
		if (isEmpty()) {
			initSentinel(item);
		}

		Node node = new Node(item, null);
		node.prev = sentB.prev;
		node.prev.next = node;
		node.next = sentB;
		sentB.prev = node;
		size += 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printDeque() {
		if (isEmpty()) {
			System.out.println("Deque is empty");
			return;
		}
		Node p = sentF.next;
		while (p != sentB) {
			System.out.print(p.item);
			System.out.print(" ");
			p = p.next;
		}
		System.out.println();
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node first = sentF.next;
		sentF.next = sentF.next.next;
		sentF.next.prev = sentF;
		size -= 1;
		return first.item;
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			return null;
		}

		Node last = sentB.prev;
		sentB.prev = sentB.prev.prev;
		sentB.prev.next = sentB;
		size -= 1;
		return last.item;
	}

	@Override
	public T get(int index) {
		if (isEmpty() || (index > (size - 1)) || (index < 0)) {
			return null;
		}

		Node p = sentF.next;
		int i = 0;
		while (i != index) {
			i++;
			p = p.next;
		}
		return p.item;
	}
}