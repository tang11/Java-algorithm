package com.algorithm.bytype.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    long pre = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST1(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST1(root.right);
    }


    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for (int i = 0; i < res.size(); i++) {
            if (i > 0 && res.get(i) <= res.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
