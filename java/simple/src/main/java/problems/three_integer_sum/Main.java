package problems.three_integer_sum;

// 3Sum: https://neetcode.io/problems/three-integer-sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static void main() {
        Map<Integer, Integer> map = new HashMap<>();
        //@formatter:off
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0},
        };
        //@formatter:on

        Solution solution = new Solution();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + i + ": " + solution.threeSum(testCases[i]));
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // If this condition is true, we've already considered all the triplets that start with nums[i].
                // Let's skip it, so we don't do unnecessary work.
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k]);
                        results.add(result); // implicitly calls List.equals (structural equality)
                    }
                }
            }
        }

        return new ArrayList<>(results);
    }
}
