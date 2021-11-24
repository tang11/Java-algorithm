package com.algorithm.leetcode.tree.medium;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/22
 */
public class FindDuplicateSubtrees {
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return  res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree,0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree,freq +1);
        return subTree;
    }

}
