package com.algorithm.剑指offer;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.HashSet;

/**
 * @author shenli
 * @date 2021/8/20
 */
public class findContinuousSequence {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        return Math.abs(depth(root.left) -depth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLength = depth(root.left);
        int rightLength = depth(root.right);
        return Math.max(leftLength, rightLength) +1;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
    }
}
