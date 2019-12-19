public class HelloMethods {
	public static void drawTriangle(int N) {
		int i = 1;
		while (i <= N){
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			i++;
		}
	}

	public static void main(String[] args) {
		drawTriangle(10);
	}
}