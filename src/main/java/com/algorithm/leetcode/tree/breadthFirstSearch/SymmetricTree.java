package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode101
 *
 * @date 2021/8/4
 */
public class SymmetricTree {

    /**
     * 递归调用
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    private boolean check1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && check1(p.left, q.right) && check1(p.right, q.left);
    }

    /**
     * 把递归改为迭代，需要引入一个队列，这是把递归改为迭代的常用方法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    private boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

}
