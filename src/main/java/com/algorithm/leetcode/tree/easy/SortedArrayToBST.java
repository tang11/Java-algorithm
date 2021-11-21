package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/22
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if(left> right) {
            return  null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTree(nums, left, middle - 1);
        root.right = buildTree(nums, middle + 1, right);
        return root;
    }
}
