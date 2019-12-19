public class DogArrayDemo {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[20];
		dogs[0] = new Dog(50);
		dogs[1] = new Dog(10);
		dogs[2] = new Dog(20);

		dogs[0].makeNoise();

	}
}