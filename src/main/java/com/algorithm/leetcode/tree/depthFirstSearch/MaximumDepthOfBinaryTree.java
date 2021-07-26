package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        max = Math.max(leftDepth, rightDepth) + 1;
        return max;
    }

    public static void main(String[] args) {
    }
}
