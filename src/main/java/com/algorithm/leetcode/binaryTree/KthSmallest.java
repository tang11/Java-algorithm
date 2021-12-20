package com.algorithm.leetcode.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author tanglijuan
 * @date 2021/12/20
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {
    //方法一：可以通过中序遍历，放到数组中，然后取出 时间复杂度O(n)

    //方法二：二叉搜索树的中序遍历是有序的，因此我们只需要对二叉搜索树执行中序遍历，并返回第 k 小的值即可。
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> d = new ArrayDeque<TreeNode>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}

