package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/11/8
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public TreeNode buildTree1(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numLeft = inRoot - inStart;
        root.left = buildTree1(preorder, preStart + 1, preStart + numLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree1(preorder, preStart + numLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}
