package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/11/24
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 */
public class IsSubtree {

    //此题可以转换成一棵树是否和另一棵树相同
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }
        return  isSameTree(root,subRoot) || isSubtree(root.left,subRoot)  || isSubtree(root.right,subRoot);
    }

    boolean isSameTree(TreeNode p,TreeNode q) {
        if(p==null && q == null) {
            return true;
        }
        if(p ==null|| q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    
}
