package problems.longest_repeating_character_replacement;

// Longest Repeating Character Replacement: https://neetcode.io/problems/longest-repeating-substring-with-replacement
// Longest Repeating Character Replacement: https://leetcode.com/problems/longest-repeating-character-replacement

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        record TestCase(String s, int k) {
        }

        //@formatter:off
        TestCase[] testCases = {
                new TestCase("ABAB", 2),
                new TestCase("AABABBA", 1),
                new TestCase("ABBABBB", 1),
                new TestCase("A", 1),
                new TestCase("A", 0),
        };
        //@formatter:on

        Solution solution = new Solution();

        for (TestCase testCase : testCases) {
            String s = testCase.s();
            int k = testCase.k();
            int result = solution.characterReplacement(s, k);
            System.out.println("s = \"" + s + "\", k = " + k + ", answer = " + result);
            System.out.println();
        }
    }
}


class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxWindowLength = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, 1 + freq.getOrDefault(c, 0));

            int mostFrequentCharCount = mostOccurences(freq);

            int windowLength = right - left + 1;
            if (windowLength - mostFrequentCharCount <= k) {
                maxWindowLength = windowLength;
            } else {
                freq.put(s.charAt(left), freq.get(s.charAt(left)) - 1);
                left++;
            }
        }

        return maxWindowLength;
    }

    private int mostOccurences(Map<Character, Integer> map) {
        int max = 0;
        for (int occurences : map.values()) {
            if (occurences > max) {
                max = occurences;
            }
        }
        return max;
    }
}