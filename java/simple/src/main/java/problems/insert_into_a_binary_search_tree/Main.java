package problems.insert_into_a_binary_search_tree;

// Insert into a Binary Search Tree: https://neetcode.io/problems/insert-into-a-binary-search-tree
// Insert into a Binary Search Tree: https://leetcode.com/problems/insert-into-a-binary-search-tree

public class Main {
}

/// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        if (current == null) {
            return new TreeNode(val);
        }

        while (true) {
            if (val < current.val) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            } else if (val > current.val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
}