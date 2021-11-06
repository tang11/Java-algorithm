package com.algorithm.bytype.others;

import java.util.HashMap;

/**
 * @author tanglijuan
 * @date 2021/11/5
 */
public class LRUCache3 {
    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node node) {
            tail.prev.next=node;
            node.next = tail;
            node.prev=tail.prev;
            tail.prev=node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev=node.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }
    }

    class  LRUCache{
    private HashMap<Integer,Node> map;
    private DoubleList cache;

    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    }
}
