package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shenli
 * @date 2021/8/4
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }

    public int minDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLength = minDepth1(root.left);
        int rightLength = minDepth1(root.right);
        if(leftLength == 0 || rightLength ==0) {
            return Math.max(leftLength, rightLength) +1;
        }
        return Math.min(leftLength,rightLength)+1;
    }

    class MyNode{
        TreeNode node;
        int depth;
        MyNode(TreeNode node,int depth) {
            this.node = node;
            this.depth =depth;
        }
    }

    /**
     * 广度搜索
     * @param root
     * @return
     */
    public int minDepth3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root,1));
        while(!queue.isEmpty()){
            MyNode myNode = queue.poll();
            TreeNode treeNode = myNode.node;
            int depth = myNode.depth;
            if(treeNode.left == null && treeNode.right == null) {
                return depth;
            }
            if(treeNode.left != null) {
                queue.offer(new MyNode(treeNode.left, depth +1));
            }
            if(treeNode.right != null) {
                queue.offer(new MyNode(treeNode.right, depth +1));
            }
        }
        return 0;
    }
}
