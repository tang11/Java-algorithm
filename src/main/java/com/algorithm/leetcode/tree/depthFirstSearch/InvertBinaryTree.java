package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * leetcode226
 * Given the root of a binary tree, invert the tree, and return its root.
 * 翻转一棵二叉树。
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
