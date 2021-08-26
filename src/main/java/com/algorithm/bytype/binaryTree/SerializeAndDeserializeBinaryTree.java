package com.algorithm.bytype.binaryTree;

import com.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tanglijuan
 * @date 2021/8/26
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * DFS
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue) {
        String data = queue.poll();
        if (data.equals("X")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(data));
        treeNode.left = buildTree(queue);
        treeNode.right = buildTree(queue);
        return treeNode;

    }

    class BFS{

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()){
                TreeNode curNode= queue.poll();
                if(curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if(curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if(curNode == null) {
                    sb.append("X");
                }else{
                    sb.append(curNode.val +",");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "") {
                return null;
            }
            Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
            TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                String left = nodes.poll();
                String right = nodes.poll();
                if (!left.equals("X")) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    queue.add(node.left);
                }
                if (!right.equals("X")) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.add(node.right);
                }
            }
            return root;
        }
    }


}
