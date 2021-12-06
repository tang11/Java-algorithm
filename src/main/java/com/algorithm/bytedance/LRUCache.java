package com.algorithm.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/12/7
 */
public class LRUCache {

    class LinkedNode {

        private LinkedNode prev;
        private LinkedNode next;
        int key;
        int value;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                LinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(LinkedNode linkedNode) {
        removeNode(linkedNode);
        addToHead(linkedNode);
    }

    public void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(LinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public LinkedNode removeTail() {
        LinkedNode removeNode = tail.prev;
        removeNode(removeNode);
        return removeNode;
    }
}
