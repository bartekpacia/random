package problems.search_2d_matrix;

// Search a 2D Matrix: https://neetcode.io/problems/search-2d-matrix
// Search a 2D Matrix: https://leetcode.com/problems/search-a-2d-matrix

public class Main {
    static void main() {
        record Input(int[][] matrix, int target) {
        }

        //@formatter:off
        Input[] inputs = new Input[]{
                new Input(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3),
                new Input(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13),
                new Input(new int[][]{{1, 1}}, 2),
                new Input(new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}}, 10),
        };
        //@formatter:on

        Solution solution = new Solution();
        for (Input input : inputs) {
            System.out.println(solution.searchMatrix(input.matrix, input.target));
        }
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / n;
            int j = mid % n;
            int found = matrix[i][j];
            if (found == target) {
                return true;
            } else if (found < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
