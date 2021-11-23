package com.algorithm.leetcode.tree.medium;

import com.algorithm.leetcode.tree.Node;
import com.algorithm.leetcode.tree.TreeNode;

import java.util.HashMap;

/**
 * @authortanglijuan
 * @date 2021/11/22
 */
public class BuildTree {

    // root->left->right  left->root->right
    // [3,9,20,15,7] [9,3,15,20,7]
    TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inorderStart, int inorderEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderIndex = map.get(preorder[preStart]);
        root.left = build(preorder, inorder, preStart + 1, preEnd, inorderStart, inorderIndex, map);
        root.right = build(preorder, inorder, preStart + 2, preEnd, inorderIndex + 1, inorderEnd, map);
        return root;
    }


}
