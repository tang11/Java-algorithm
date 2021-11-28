package com.algorithm.leetcode.tree.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/26
 */
public class IsValidBST {
    Integer max;
    Integer min;

    public boolean isValidBST(TreeNode root) {
        return validBST(root, null, null);

    }

    public boolean validBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val > max.val) {
            return false;
        }
        if (min != null && root.val < min.val) {
            return false;
        }
        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }
}
