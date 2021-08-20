package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * leetcode110
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        return height(root) >= 0;
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeigth = height1(root.left);
        int rightHeight = height1(root.right);
        if (leftHeigth == -1 || rightHeight == -1 || Math.abs(leftHeigth - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeigth, rightHeight) + 1;
        }
    }
}
