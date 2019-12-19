public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	public void addFirst(int x) {
		rest = this;
		first = x;
	}

/**
	public int size(IntList r) {
		if (r.rest == null) {
			return 0;
		}
		return 1 + size(r.rest);
	}
	*/

	public int size()
	{
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}
/**
	public int iterativeSize() {
		IntList tmp = this; 
		int size = 1;

		while (temp.rest) {
			size ++;
			temp = temp.rest;
		}

		return size;
	}
	*/

	public int iterativeSize() {
		IntList p = this; 
		int size = 0;
		
		while (p != null) {
			size ++;
			temp = temp.rest;
		}

		return size;
	}

	public int get(int i) {
		IntList p = this;
		int j = 0;
		while (p != null) {
			if (j == i) {
				return p.first;
			}
			j++;
		}
		return 0;
	}
}