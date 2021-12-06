package com.algorithm.abytype.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/8/29
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * using map
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<Node, Node>();
        Node p = head;
        while (p != null) {
            nodeMap.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            Node cloneNode = nodeMap.get(p);
            cloneNode.next = nodeMap.get(p.next);
            cloneNode.random = nodeMap.get(p.random);
            p = p.next;
        }
        return nodeMap.get(head);
    }

    /**
     * backtracking
     */
    class Solution {

        Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
                map.get(head).next = copyRandomList(head.next);
                map.get(head).random = copyRandomList(head.random);
            }

            return map.get(head);
        }
    }
}
