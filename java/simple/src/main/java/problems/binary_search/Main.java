package problems.binary_search;

// Binary Search: https://neetcode.io/problems/binary-search
// Binary Search: https://leetcode.com/problems/binary-search

public class Main {
    static void main() {
        record Input(int[] nums, int target) {
        }

        //@formatter:off
        Input[] inputs = new Input[]{
                new Input(new int[]{-1, 0, 2, 4, 6, 8}, 4),
                new Input(new int[]{-1, 0, 2, 4, 6, 8}, 3),
                new Input(new int[]{5}, 5),
        };
        //@formatter:on

        Solution solution = new Solution();
        for (Input input : inputs) {
            System.out.println(solution.search(input.nums, input.target));
        }
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }

        return -1;
    }
}
