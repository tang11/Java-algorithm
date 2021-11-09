package com.algorithm.leetcode.tree.tree.simple;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/9
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(mid);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;

    }
}
