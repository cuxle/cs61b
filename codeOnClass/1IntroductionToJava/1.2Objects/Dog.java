public class Dog {
	public int weightInPounds;
	public Dog(int w) {
		weightInPounds = w;
	}
	public void makeNoise() {
		if (weightInPounds < 10) {
			System.out.println("yipyipyip!");
		} else if (weightInPounds < 30) {
			System.out.println("bark. bark.");
		} else {
			System.out.println("woof!");
		}
		
	}
	public static Dog maxDog(Dog dog1, Dog dog2) {
		if (dog1.weightInPounds > dog2.weightInPounds) {
			return dog1;
		}
		return dog2;
	}
}