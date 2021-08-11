package com.algorithm.leetcode.tree.breadthFirstSearch;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *leetcode653
 * @date 2021/8/11
 */
public class TwoSumIV {
    public boolean findTarget1(TreeNode root, int k) {
        List<Integer> treeList = new ArrayList<>();
        inorderTree(root,treeList);
        int start =0;
        int end = treeList.size()-1;
        while(start < end) {
            if(treeList.get(start) + treeList.get(end) == k) {
                return true;
            } else if(treeList.get(start) + treeList.get(end) >k) {
                end--;
            } else {
                start++;
            }
        }
        return false;

    }
    public List<Integer> inorderTree(TreeNode root,List<Integer> res) {
        if(root == null) {
            return null;
        }
        inorderTree(root.left,res);
        res.add(root.val);
        inorderTree(root.right,res);
        return res;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet set = new HashSet<>();
        return find(root, k, set);
    }
    public boolean find(TreeNode root,int k, HashSet<Integer> set) {
        if(root == null) {
            return false;
        }
        if(set.contains(k-root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

}
