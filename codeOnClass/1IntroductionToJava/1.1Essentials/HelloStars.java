public class HelloStars {
	public static void main(String[] args) {
		int lines = 6;
		int i = 1;
		while (i <= lines){
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			i++;
		}
	}
}
