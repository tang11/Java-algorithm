package com.algorithm.leetcode.tree.tree.medium;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author shenli
 * @date 2021/11/10
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root,val,root);
    }
    public TreeNode insert(TreeNode root, int val, TreeNode prev) {
        if(root == null) {
            if(prev != null) {
                if(val > prev.val) {
                    prev.right = new TreeNode(val);
                } else{
                    prev.left = new TreeNode(val);
                }
            }else {
                root = new TreeNode(val);
            }
            return root;
        }

        if(root.val > val) {
            insert(root.left,val,root);
        }
        if(root.val< val) {
            insert(root.right,val,root);
        }
        return root;

    }


    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val> val) {
            root.left = insertIntoBST1(root.left,val);
        }
        if(root.val<val) {
            root.right = insertIntoBST1(root.right,val);
        }
        return root;

    }
}
