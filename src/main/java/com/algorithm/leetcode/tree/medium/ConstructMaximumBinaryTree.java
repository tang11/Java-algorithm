package com.algorithm.leetcode.tree.medium;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/22
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    public TreeNode build(int[] nums,int start,int end) {
        if(start> end) {
            return null;
        }
        int max =Integer.MIN_VALUE;
        int index = -1;
        for(int i = start;i <= end;i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;

            }
        }
        TreeNode node = new TreeNode(max);
        node.left = build(nums,start,index-1);
        node.right = build(nums,index+1,end);
        return node;
    }
}
