package com.algorithm.leetcode.graph;

import com.algorithm.leetcode.tree.TreeNode;
import org.springframework.beans.factory.parsing.QualifierEntry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2021/11/17
 */
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = que.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
                size--;
            }
            res.add(level);
        }
        return res;
    }
}
