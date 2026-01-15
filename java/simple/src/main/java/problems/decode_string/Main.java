package problems.decode_string;

// Encode and Decode Strings: https://neetcode.io/problems/string-encode-and-decode
// Decode String: https://leetcode.com/problems/decode-string

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //@formatter:off
        String[] testCases = {
                "2[a3[b]]c",
                "axb3[z]4[c]",
                "ab2[c]3[d]1[x]"
        };
        //@formatter:on

        for (int i = 0; i < testCases.length; i++) {
            String input = testCases[i];
            String output = solution.decodeString(input);
            System.out.println("Example " + (i + 1) + ": Input: s = \"" + input + "\", Output: \"" + output + "\"");
        }
    }

}

class Solution {
    public String decodeString(String s) {
        // 2[a3[b]]c"
        // 2[abbb]c
        // abbbabbbc
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (Character.isDigit(s.charAt(0))) {
            while (s.charAt(i) != '[') {
                i++;
            }
            int num = Integer.parseInt(s.substring(0, i));
            i++; // move to the character after '['

            int j = i + 1;
            while (s.charAt(j) != ']') {
                j++;
            }
            String content = s.substring(i, j);
            String decoded = decodeString(content);
            sb.append(decoded);
        }

        return sb.toString();
    }
}