public class Main {
	public static void main(String[] args) {
		System.out.println("Current time is: " + System.currentTimeMillis());

		String name = "testABC";
		System.out.println(name.hashCode());
		name = "testXYZ";
		System.out.println(name.hashCode());
	}
}
