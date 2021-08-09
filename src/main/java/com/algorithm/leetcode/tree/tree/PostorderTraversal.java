package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *leetcode145
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postorder(root, res);
    }

    public List<Integer> postorder(TreeNode root, List<Integer> res){
        if(root == null) {
            return new ArrayList<>();
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
        return res;
    }
}
