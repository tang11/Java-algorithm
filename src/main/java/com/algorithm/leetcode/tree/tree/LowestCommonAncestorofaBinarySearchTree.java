package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * leetcode235
 * @date 2021/8/13
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p,q );
        } else {
            return root;
        }
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.offer(root);
        while(!parent.containsKey(p)  || !parent.containsKey(q)) {
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                parent.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                parent.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
        Set<TreeNode> allParent = new HashSet<>();
        while(p != null) {
            allParent.add(p);
            p = parent.get(p);
        }
        while(!allParent.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
