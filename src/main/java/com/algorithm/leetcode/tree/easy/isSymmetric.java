package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/22
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        //root要做啥, 和判断是否是同一个棵树思想是一样的
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
