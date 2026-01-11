package problems.string_encode_and_decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Encode and Decode Strings: https://neetcode.io/problems/string-encode-and-decode
// Encode and Decode Strings: https://leetcode.com/problems/encode-and-decode-strings

public class Main {
    static void main() {
        //@formatter:off
        String[][] inputs = {
                {"Hello", "World"},
                {""},
                {},
        };
        //@formatter:on

        Solution solution = new SolutionA();
        for (String[] input : inputs) {
            List<String> strings = Arrays.asList(input);
            String encoded = solution.encode(strings);
            System.out.println("Encoded " + wrapWithQuotesAndJoin(strings) + " into: " + "\"" + encoded + "\"");
            List<String> decoded = solution.decode(encoded);
            System.out.println("Decoded \"" + encoded + "\" into: " + wrapWithQuotesAndJoin(decoded));
        }
    }

    static String wrapWithQuotesAndJoin(List<String> strings) {
        return "[" + strings.stream()
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(", ")) + "]";
    }
}

interface Solution {
    String encode(List<String> strs);

    List<String> decode(String str);
}

class SolutionA implements Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        boolean isDecodingLength = true;
        int currentIdx = 0;
        int encodedStrLength = 0;
        StringBuilder len = new StringBuilder();
        StringBuilder content = new StringBuilder();
        for (char c : str.toCharArray()) {
            // First, get the length of the encoded string
            if (isDecodingLength) {
                if (c == '#') {
                    encodedStrLength = Integer.parseInt(len.toString());
                    isDecodingLength = false;
                } else {
                    len.append(c);
                }
            } else {
                if (currentIdx < encodedStrLength) {
                    content.append(c);
                    currentIdx++;
                } else {
                    result.add(content.toString());
                    content = new StringBuilder();
                    isDecodingLength = true;
                    encodedStrLength = 0;
                    currentIdx = 0;
                    len = new StringBuilder();
                    len.append(c);
                }
            }
        }

        if (!str.isEmpty()) {
            result.add(content.toString());
        }

        return result;
    }
}

class SolutionB implements Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            while (str.charAt(j) != '#') {
                sb.append(str.charAt(j));
                j++;
            }
            int len = Integer.parseInt(sb.toString());
            res.add(str.substring(j, j + len));
            i = j + len + 1;
        }

        return res;
    }
}