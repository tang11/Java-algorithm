package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode257
 * @date 2021/8/13
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        allPath(root,"", res);
        return res;
    }
    public void allPath(TreeNode root, String path, List<String> res) {
        if(root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(String.valueOf(root.val));
            if(root.left == null && root.right == null) {
                res.add(sb.toString());
            } else {
                sb.append("->");
                allPath(root.left, sb.toString(), res);
                allPath(root.right, sb.toString(), res);
            }
        }
    }
}
