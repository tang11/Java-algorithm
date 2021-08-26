package com.algorithm.bytype.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author tanglijuan
 * @date 2021/8/26
 */
public class LowestCommonAncestorofABinaryTree {

    /**
     * 此方法便于理解，但复杂度比较高
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果p,q为根节点，则公共祖先为根节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 如果p,q在左子树，则公共祖先在左子树查找
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        // 如果p,q在右子树，则公共祖先在右子树查找
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        // 如果p,q分属两侧，则公共祖先为根节点
        return root;
    }

    private boolean find(TreeNode root, TreeNode c) {
        if (root == null) {
            return false;
        }
        if (root.val == c.val) {
            return true;
        }

        return find(root.left, c) || find(root.right, c);
    }

    /**
     * 根据left和right有四种情况
     * 1、left和right同时为空，说明不存在公共祖先
     * 2、left和right同时不为空，说明p/q分别在root的两侧，因此root为公共祖先
     * 3、left为空，right不为空：
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
