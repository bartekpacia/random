package problems.palindrome;

// Valid Palindrome: https://neetcode.io/problems/is-palindrome
// Valid Palindrome: https://leetcode.com/problems/valid-palindrome

public class Main {
    public static void main(String[] args) {
        String[] testCases = {"Was it a car or a cat I saw?", "tab a cat", "abba ab b a"};

        for (int i = 0; i < testCases.length; i++) {
            Solution solution = new Solution();
            boolean isPalindrome = solution.isPalindrome(testCases[i]);
            System.out.println("Test case " + i + ": " + isPalindrome);
        }
    }
}


class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        boolean result = true;
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!Character.isAlphabetic(left) && !Character.isDigit(left)) {
                i++;
            } else if (!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                j--;
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    result = false;
                    break;
                }
                i++;
                j--;
            }
        }

        return result;
    }
}
