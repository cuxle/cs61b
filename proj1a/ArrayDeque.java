public class ArrayDeque<T>{
	private int size;
	private int length;
	private T[] array;
	private int front;
	private int rear;

	public ArrayDeque() {
		initArray();
	}


	public ArrayDeque(ArrayDeque<T> other) {
		initArray();
		for (int i = 0; i < other.size(); i++) {
			this.addLast(other.get(i));
		}
	}

	private void initArray() {
		front = 0;
		rear = 0;
		size = 0;
		length = 8;
		array = (T[])new Object[length];
	}

	private void resize() {
		length = 2 * length;
		T[] newArray = (T[])new Object[length];
		for (int i = 0; i < length / 2; i++) {
			newArray[i] = array[i];
		}
		array = newArray;		
	}

	public void addFirst(T item) {
		//full
		if (isFull()) {
			resize();
		}

		//not full
		front = (front - 1) >= 0 ? (front - 1) : (front - 1 + length);
		array[front] = item;
		size += 1;
	}

	public void addLast(T item) {
		if (isFull()) {
			resize();
		}

		array[rear] = item;
		rear = (rear + 1) % length;
		size += 1;
	}

	public void printDeque() {
		int f = front;
		int r = rear;
		while (f != r) {
			System.out.print(array[f]);
			System.out.print(" ");
			f = (f + 1)%length;
		}

		System.out.println();

	}

	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		int index = front;
		front = (front + 1) % length;
		size -= 1;
		return array[index];
	}

	public T removeLast() {
		if(isEmpty()) {
			return null;
		}
		int index = rear;
		rear = rear - 1;
		if (rear < 0) {
			rear = rear + length;
		}
		size -= 1;
		return array[index];
	}

	public T get(int index) {
		if (index > (size - 1)) {
			return null;
		}
		int des = (front + index) % length;
		return array[des];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public boolean isFull() {
		int diff = front - rear;
		if (diff == 1 || diff == (1 - length)) {
			return true;
		} else {
			return false;
		}
	}

}