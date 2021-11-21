package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/22
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //root要做什么
        if(p == null && q == null) {
            return true;
        }
        if(p==null || q==null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
