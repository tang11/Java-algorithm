package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @authortanglijuan
 * @date 2021/11/22
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        treePath(res, root, "");
        return res;
    }

    public void treePath(List<String> res, TreeNode root, String path) {
        path = path + root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            treePath(res, root.left, path + "->");
        }
        if (root.right != null) {
            treePath(res, root.right, path + "->");
        }


    }
}
