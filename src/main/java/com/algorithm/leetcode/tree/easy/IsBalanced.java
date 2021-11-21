package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/22
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class IsBalanced {

    //此解法是自顶向下，遍历左右子树，还需要计算左右子树的高度，时间复杂度o(n)
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right) +1;
    }

    //通过自底向上，时间复杂度o(n)
    public boolean isBalanced1(TreeNode root) {
        return height(root) != -1;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
