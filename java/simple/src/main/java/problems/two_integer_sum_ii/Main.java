package problems.two_integer_sum_ii;

// Two Integer Sum II: https://neetcode.io/problems/two-integer-sum-ii
// Two Sum II - Input Array Is Sorted: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

import java.util.Arrays;

public class Main {
    static void main() {
        //@formatter:off
        int[][] nums = {
                {2, 7, 11, 15},
                {3,2,4},
                {3,3},
        };
        int[] targets = {9, 6, 6};
        //@formatter:on

        Solution solution = new Solution();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Test case " + i + ": " + Arrays.toString(solution.twoSum(nums[i], targets[i])));
        }
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        // [2,7,11,15], target = 9
        // If numbers[left] + numbers[right] > target, decrement right (so that sum decreases)
        // If numbers[left] + numbers[right] < target, increment left (so that sum increases)
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }

        return result;
    }
}
