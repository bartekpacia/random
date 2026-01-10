package problems.two_integer_sum;

// Two Sum: https://neetcode.io/problems/two-integer-sum
// Two Sum: https://leetcode.com/problems/two-sum

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        //@formatter:off
        int[][] nums = {
                {2, 7, 11, 15},
                {3, 2, 4},
                {3, 3},
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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Example: nums = [2,7,11,15], t = 9
        // 9 (target) - 2 (current) = 7. Does the hashmap contain 7?
        // {
        //   2: 0,
        //   7: 1,
        //   11: 2,
        //   15: 3
        // }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer j = map.get(complement);
            if (j != null && i != j) {
                result[0] = i;
                result[1] = j;
                break;
            }
            map.put(nums[i], i);
        }

        Arrays.sort(result);
        return result;
    }
}
