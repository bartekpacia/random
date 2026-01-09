package algo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Sample sorted array for binary search
        int[] sampleData = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78, 89}; // len = 12

        // Print the sample data
        System.out.println("Sample array: " + Arrays.toString(sampleData));
        System.out.println("Array length: " + sampleData.length);

        // Test cases
        int target1 = 23;
        int target2 = 100;
        int target3 = 2;

        // Test binary search
        int result1 = binarySearch(sampleData, target1);
        System.out.println("\nSearching for " + target1 + ": " +
                (result1 != -1 ? "Found at index " + result1 : "Not found"));

        System.out.println("---");

        int result2 = binarySearch(sampleData, target2);
        System.out.println("Searching for " + target2 + ": " +
                (result2 != -1 ? "Found at index " + result2 : "Not found"));

        System.out.println("---");

        int result3 = binarySearch(sampleData, target3);
        System.out.println("Searching for " + target3 + ": " +
                (result3 != -1 ? "Found at index " + result3 : "Not found"));
    }

    /**
     * Binary search implementation
     *
     * @param arr    - sorted array to search in
     * @param target - element to search for
     * @return index of target element, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        int steps = 0;
        int answer = -1;
        while (i <= j) {
            steps++;
            int mid = (i + j) / 2;

            if (target > arr[mid]) {
                i = mid + 1;
            } else if (target < arr[mid]) {
                j = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }

        System.out.printf("Return after %d steps\n", steps);

        return answer;
    }
}
