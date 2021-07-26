package com.algorithm.leetcode.tree.depthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode94
 * Binary Tree Inorder Traversal
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftRoot(root, res);
        return res;
    }

    public void leftRoot(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        leftRoot(root.left, res);
        res.add(root.val);
        leftRoot(root.right, res);
    }
}
