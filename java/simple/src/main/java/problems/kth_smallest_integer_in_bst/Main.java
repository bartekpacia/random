package problems.kth_smallest_integer_in_bst;

// Kth Smallest Integer in BST: https://neetcode.io/problems/kth-smallest-integer-in-bst
// Kth Smallest Integer in a BST: https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    int k = 0;
    int visitedMinimums = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inorder(root);
    }

    int inorder(TreeNode node) {
        if (node.left != null) {
            int result = inorder(node.left);
            if (result != -1) return result;
        }

        visitedMinimums++;
        if (visitedMinimums == k) {
            return node.val;
        }

        if (node.right != null) {
            int result = inorder(node.right);
            if (result != -1) return result;
        }

        return -1;
    }
}

