package com.algorithm.leetcode.array.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 *leetcode108
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left > right) {
            return  null;
        }
        int mid = (left + right) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid -1);
        root.right = helper(nums, mid+1, right);
        return root;
    }
}
