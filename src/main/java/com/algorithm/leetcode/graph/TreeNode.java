package com.algorithm.leetcode.graph;

/**
 * @author tanglijuan
 * @date 2021/11/17
 */
public class TreeNode {


    public int val;
    public com.algorithm.leetcode.tree.TreeNode left;
    public com.algorithm.leetcode.tree.TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, com.algorithm.leetcode.tree.TreeNode left, com.algorithm.leetcode.tree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
