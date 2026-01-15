package problems.design_word_search_data_structure;

import java.util.HashMap;
import java.util.Map;

// Design Add and Search Word Data Structure: https://neetcode.io/problems/design-word-search-data-structure
// Design Add and Search Words Data Structure: https://leetcode.com/problems/design-add-and-search-words-data-structure

public class Main {
    static void main() {
        WordDictionary dictionary = new WordDictionary();
        String[] words = new String[]{"day", "bay", "may"};
        for (String word : words) {
            dictionary.addWord(word);
        }
        System.out.println(dictionary.search("say")); // return false
        System.out.println(dictionary.search("day")); // return true
        System.out.println(dictionary.search(".ay")); // return true
        System.out.println(dictionary.search("b..")); // return true
    }
}

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode start) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean found = false;
                for (char key : start.children.keySet()) {
                    found = search(word.substring(i + 1), start.children.get(key));
                    if (found) {
                        start = start.children.get(key);
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            } else {
                TrieNode next = start.children.get(c);
                if (next == null) {
                    return false;
                }
                start = next;
            }
        }
        return start.isWord;
    }
}

class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    TrieNode() {
        isWord = false;
        children = new HashMap<>();
    }
}
