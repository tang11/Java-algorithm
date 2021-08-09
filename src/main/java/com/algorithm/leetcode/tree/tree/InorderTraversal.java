package com.algorithm.leetcode.tree.tree;

import com.algorithm.leetcode.tree.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    /**
     * 方法一：递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    class ColorNode{
        private TreeNode node;
        private String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }

    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null) {return new ArrayList<>();}
        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));
        while(!stack.isEmpty()){
            ColorNode cn = stack.pop();
            if(cn.color.equals("white")) {
                if(cn.node.right !=null) {
                    stack.push(new ColorNode(cn.node.right,"white"));
                }
                stack.push(new ColorNode(cn.node,"grey"));
                if(cn.node.left != null) {
                    stack.push(new ColorNode(cn.node.left,"white"));
                }

            } else {
                list.add(cn.node.val);
            }
        }
        return list;
    }
}
