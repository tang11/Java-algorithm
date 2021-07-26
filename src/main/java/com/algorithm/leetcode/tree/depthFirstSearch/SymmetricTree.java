package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * leetcode101
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return (p.val == q.val) && check(p.left, q.right) && check(p.right, q.left);
    }
}
