package problems.implement_prefix_tree;

// Implement Trie (Prefix Tree): https://neetcode.io/problems/implement-prefix-tree
// Implement Trie (Prefix Tree): https://leetcode.com/problems/implement-trie-prefix-tree

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        PrefixTree trie = new PrefixTree();
        trie.insert("dog");
        System.out.println(trie.search("dog"));    // return true
        System.out.println(trie.search("do"));     // return false
        System.out.println(trie.startsWith("do"));       // return true
        trie.insert("do");
        System.out.println(trie.search("do"));     // return true
    }
}

class PrefixTree {
    private final TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        if (word.isEmpty()) return;
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, (k) -> new TreeNode());
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            TreeNode next = current.children.get(c);
            if (next != null) {
                current = next;
            } else {
                return false;
            }
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;
        TreeNode current = root;
        for (char c : prefix.toCharArray()) {
            TreeNode next = current.children.get(c);
            if (next != null) {
                current = next;
            } else {
                return false;
            }
        }
        return true;
    }
}

class TreeNode {
    boolean isWord;
    final Map<Character, TreeNode> children;

    TreeNode() {
        this.children = new HashMap<>();
    }
}
