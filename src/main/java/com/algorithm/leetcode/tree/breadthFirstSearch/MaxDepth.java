package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode
 *
 * @date 2021/8/4
 */
public class MaxDepth {

    /**
     * 深度搜索 优先  -------递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = maxDepth(root.left);
        int rightLength = maxDepth(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }

    /**
     * 广度搜索优先
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
