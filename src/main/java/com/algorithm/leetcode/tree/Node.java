package com.algorithm.leetcode.tree;

import java.util.List;

/**
 *Node
 * @date 2021/8/5
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
