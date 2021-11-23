package com.algorithm.leetcode.tree.easy;

import com.algorithm.leetcode.tree.TreeNode;

/**
 * @author shenli
 * @date 2021/11/23
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ans = 0;
        if(root.left != null ) {
            if(isLeaf(root.left)) {
                ans = ans + root.left.val ;
            }else {
                ans +=dfs(root.left);
            }
        }
        if(root.right != null && !isLeaf(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }
    public boolean isLeaf(TreeNode node ){
        return node.left == null && node.right == null;
    }
}
