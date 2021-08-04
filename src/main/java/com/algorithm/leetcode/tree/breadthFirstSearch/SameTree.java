package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * leetcode100
 * @date 2021/8/4
 */
public class SameTree {

    /**
     * 深度优先搜索
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q!= null) {
            return false;
        }
        return (p.val == q.val) && isSameTree( p.left, q.left) && isSameTree(p.right, q.right);
    }
}
