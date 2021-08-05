package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode404
 *
 * @date 2021/8/5
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode node) {
        int sum = 0;
        if (node.left != null) {
            sum += isLeaf(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeaf(node.right)) {
            sum += dfs(node.right);
        }
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }


    public int sumOfLeftLeavesBreadthWay(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeaf(node.left)) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null && !isLeaf(node.right)) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

}


