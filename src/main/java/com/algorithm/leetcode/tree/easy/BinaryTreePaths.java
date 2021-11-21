package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * @date 2021/11/22
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        treePath(res,root,new StringBuilder());
        return res;
    }

    public void treePath(List<String> res, TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        if(root.left != null) {
            sb.append("->");
            treePath(res,root.left,sb);
        }
        if (root.right != null) {
            sb.append("->");
            treePath(res,root.right,sb);
        }
    }

}
