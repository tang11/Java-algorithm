package com.algorithm.bytype.priorrityQueue;

import java.util.Comparator;
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
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                } else if (l1.val == l2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists){
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        while(!priorityQueue.isEmpty()) {
            p.next = priorityQueue.poll();
            p = p.next;
            if (p.next != null) {
                priorityQueue.add(p.next);
            }
        }
        return  dummy.next;
    }
}
