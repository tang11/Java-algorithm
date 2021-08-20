package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode112
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();

        queue.offer(root);
        queueVal.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curVal = queueVal.poll();
            if (cur.left == null && cur.right == null) {
                if (curVal == targetSum) {
                    return true;
                }
                continue;

            }

            if (cur.left != null) {
                queue.offer(cur.left);
                queueVal.offer(curVal + cur.left.val);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                queueVal.offer(curVal + cur.right.val);
            }
        }
        return false;
    }
}
