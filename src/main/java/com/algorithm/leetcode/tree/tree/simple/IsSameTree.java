package com.algorithm.leetcode.tree.tree.simple;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/9
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q==null) {
            return true;
        }
        if(p == null || q==null) {
            return false;
        }
        return  (p.val == q.val) &&isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
