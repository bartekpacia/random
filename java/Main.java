public class Main {
	public static void main(String[] args) {
		printNums(2, 1, 3, 7);
	}

	public static void printNums(int ... nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println("number at index " + i + " is " + nums[i]);
		}
	}
}
