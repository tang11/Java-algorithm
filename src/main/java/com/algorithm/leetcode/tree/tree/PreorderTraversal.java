package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *leetcode144
 * @date 2021/8/8
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res =new ArrayList<>();
        return preOder(root,res);
    }
    private List<Integer> preOder(TreeNode root, List<Integer> res){
        if(root == null) {
            return new ArrayList<>();
        }
        res.add(root.val);
        preOder(root.left, res);
        preOder(root.right, res);
        return res;
    }
}
