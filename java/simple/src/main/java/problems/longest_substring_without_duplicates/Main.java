package problems.longest_substring_without_duplicates;

import java.util.HashSet;
import java.util.Set;

// Longest Substring Without Repeating Characters: https://neetcode.io/problems/longest-substring-without-duplicates
// Longest Substring Without Repeating Characters: https://leetcode.com/problems/longest-substring-without-repeating-characters

public class Main {
    static void main() {
        //@formatter:off
        String[] testCases = {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
        };
        //@formatter:on

        Solution solution = new Solution();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + i + ": " + solution.lengthOfLongestSubstring(testCases[i]));
        }
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int left = 0;
        Set<Character> chars = new HashSet<>(); // characters in the sliding window
        for (int right = 0; right < s.length(); right++) {
            while (chars.contains(s.charAt(right))) {
                // Before adding char at 'right' to the window,
                // we need to ensure it's not already there
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(s.charAt(right));
            if (chars.size() > maxLen) {
                maxLen = chars.size();
            }
        }

        return maxLen;
    }
}
