package com.algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/17
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }


    }

    public HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.get(node) != null) {
            return map.get(node);
        }
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        for (Node child : node.neighbors) {
            map.get(node).neighbors.add(cloneGraph(child));
        }
        return node;
    }
}
