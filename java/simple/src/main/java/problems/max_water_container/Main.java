package problems.max_water_container;

// Container With Most Water: https://neetcode.io/problems/max-water-container
// Container With Most Water: https://leetcode.com/problems/container-with-most-water

import java.util.HashSet;
import java.util.Set;

public class Main {
    static void main() {
        //@formatter:off
        int[][] heights = {
                {1, 7, 2, 5, 4, 7, 3, 6},
                {2, 2, 2},
        };
        //@formatter:on
        new HashSet<Character>();

        Solution solution = new Solution();
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Test case " + i + ": " + solution.maxArea(heights[i]));
        }
    }
}

class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int left = heights[i];
            int right = heights[j];
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;
            int area = height * width;
            if (area > max) {
                max = area;
            }
            if (left < right) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
