package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *leetcode783
 */
public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        inorder(root, res);
        int min = Integer.MAX_VALUE;
        for(int i=1; i < res.size(); i++) {
            min = Math.min(min,res.get(i)-res.get(i-1));
        }
        return min;

    }

    public List<Integer> inorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return null;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
        return res;
    }
}
