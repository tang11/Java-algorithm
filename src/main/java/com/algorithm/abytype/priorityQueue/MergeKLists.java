package com.algorithm.abytype.priorityQueue;

import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/9/6
 */
public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (!heap.isEmpty()) {
                ListNode minNode = heap.poll();
                tail.next = minNode;
                tail = minNode;
                if (minNode.next != null) {
                    heap.offer(minNode.next);
                }
            }
            return  dummyHead.next;


    }
}
