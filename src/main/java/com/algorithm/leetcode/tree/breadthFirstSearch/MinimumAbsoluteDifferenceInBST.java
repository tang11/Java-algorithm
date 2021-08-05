package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode530
 *
 * @date 2021/8/5
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
        }
        return minDiff;
    }

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


    private Integer prev;
    private int minDiff;

    public int getMinimumDifference1(TreeNode treeNode) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorder(treeNode);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}
