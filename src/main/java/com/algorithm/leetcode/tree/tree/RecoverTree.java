package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/9
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        //扫描遍历的结果，找出可能存在错误交换的节点x和y
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root);
        dfs(root.right, res);
    }

    TreeNode pre = null;
    TreeNode s = null;
    TreeNode t = null;

    public void recoverTree1(TreeNode root) {
        dfs1( root);
        if (s!= null && t!=null) {
            int tmp = s.val;
            s.val = t.val;
            t.val=tmp;
        }
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs1(root.left);
        if (pre == null) {
            pre = root;
        }
        if (pre.val > root.val) {
            s = (s == null) ? pre : s;
            t = root;
        }
        pre = root;
        dfs1(root.right);
    }


}
