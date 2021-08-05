package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.Node;

/**
 * leetcode559
 * @date 2021/8/5
 */
public class MaximumDepthofNaryTree {

    /**
     * 和二叉树求深度是一样的，
     * 二叉树求深度取左右子树的最大深度+1
     * 多叉树是循环取子树的大小
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.isEmpty()) {
            return 1;
        }
        int max = 0;
        for (Node node: root.children) {
            max = Math.max(max, maxDepth(node) +1);
        }
        return max;
    }

}
