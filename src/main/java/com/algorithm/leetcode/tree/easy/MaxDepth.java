package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.Node;

/**
 * @author tanglijuan
 * @date 2021/11/22
 */
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            int childDepth = maxDepth(node);
            max = Math.max(childDepth, max);
        }
        return max + 1;
    }
}
