package com.algorithm.bytype.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/8/27
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode treeNode, long minValue, long maxValue) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.val <= minValue || treeNode.val >= maxValue) {
            return false;
        }
        return valid(treeNode.left, minValue, (long) treeNode.val) && valid(treeNode.right, (long) treeNode.val, maxValue);
    }


}
