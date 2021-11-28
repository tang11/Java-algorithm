package com.algorithm.leetcode.tree.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/26
 */
public class InsertIntoBST {

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return  root;
    }
}
