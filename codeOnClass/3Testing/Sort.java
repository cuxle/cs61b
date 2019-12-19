public class Sort {
	public static void sort(String[] input) {
		sort(input, 0);
	}

	public static void sort(String[] input, int start) {
		//1. find the smallest item
		//2. move it to the front
		//3. sort the next n - 1 items
		if ((input.length - start) == 1) {
			return;
		}

		int minIndex = findSmallest(input, start);

		if (minIndex != start) {
			swapToPos(input, start, minIndex);
		}

		sort(input, start + 1);
	}

	public static int findSmallest(String[] input, int start) {
		int index = start;
		for (int i = start + 1; i < input.length; i++) {
			if (input[i].compareTo(input[index]) < 0) {
				index = i;
			}
		}
		return index;
	}

	public static void swapToPos(String[] input, int from, int to) {
		String temp = input[to];
		input[to] = input[from];
		input[from] = temp;
	}
}