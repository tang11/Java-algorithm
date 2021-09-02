package com.algorithm.bytype.binaryTree;

import com.algorithm.leetcode.tree.Node;
import com.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/8/26
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * DFS
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Deque<String> queue = new LinkedList<String>(Arrays.asList(str));
        return buildTree(queue);
    }

    public TreeNode buildTree(Deque<String> deque) {
        String val = deque.poll();
        if (val.equals("X")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(deque);
        node.right = buildTree(deque);
        return node;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */

    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "X";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("X,");

            } else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if(data ==""){
            return null;
        }
        String[] str = data.split(",");
        Queue<String> deque = new LinkedList<>(Arrays.asList(str));
        Queue<TreeNode> nodes = new LinkedList<>();
        String rootVal = deque.poll();
        if(rootVal== "X"){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            String leftVal = deque.poll();
            String rightVal = deque.poll();
            if (!leftVal.equals("X")) {
                node.left = new TreeNode(Integer.parseInt(leftVal));
                nodes.offer(node.left);
            }
            if (!rightVal.equals("X")) {
                node.right = new TreeNode(Integer.parseInt(rightVal));
                nodes.offer(node.right);
            }

        }
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("X,");
            } else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
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
