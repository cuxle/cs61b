public class SLListLaunch {

	public static void main(String[] args) {
		SLList<String> list = new SLList<>("Hello");
		list.addLast("World");
		
		System.out.println(list.size());

	}
	
}