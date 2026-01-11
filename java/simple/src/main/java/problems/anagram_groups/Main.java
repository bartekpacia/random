package problems.anagram_groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Group Anagrams: https://neetcode.io/problems/anagram-groups
// Group Anagrams: https://leetcode.com/problems/group-anagrams

public class Main {
    static void main() {
        //@formatter:off
        String[][] testCases = {
                {"act","pots","tops","cat","stop","hat"},
                {"x"},
                {""},
        };
        //@formatter:on

        Solution solution = new SolutionA();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1) + ": " + solution.groupAnagrams(testCases[i]));
        }
    }
}

interface Solution {
    List<List<String>> groupAnagrams(String[] strs);
}

/// m = strs.length
/// n = length of individual string
/// O(m * n * log(n))
class SolutionA implements Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}

/// m = strs.length
/// n = length of individual string
/// O(m * n)
class SolutionB implements Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                freq[index]++;
            }

            String key = Arrays.toString(freq);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
