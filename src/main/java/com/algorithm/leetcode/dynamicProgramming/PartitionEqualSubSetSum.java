package com.algorithm.leetcode.dynamicProgramming;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class PartitionEqualSubSetSum {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right,B);


    }
    public boolean recur(TreeNode A, TreeNode B) {
        if(A == null || A.val != B.val) {
            return false;
        }
        if(B ==null) {
            return true;
        }
        return recur(A.left, B.left) || recur(A.right, B.right);
    }

    public static  int maxSubArray(int[] nums) {
        int dp[] =new int[nums.length];
        dp[0] = nums[0];
        for(int i =1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],Math.max(dp[i-1], dp[i-1] + dp[i]));
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
       int[] example = new int[]{-2,1,-3,4,-1,2,1,-5,4};
       String s= "a";
       s.charAt(0);
       maxSubArray(example);
    }

}
