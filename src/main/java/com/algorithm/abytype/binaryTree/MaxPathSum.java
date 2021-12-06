package com.algorithm.abytype.binaryTree;

/**
 * @author tanglijuan
 * @date 2021/11/6
 */
public class MaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        max = Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;

    }
}
