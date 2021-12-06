package com.algorithm.shoppe;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/12/4
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for(ListNode tmp: lists) {
            if (tmp != null) {
                queue.offer(tmp);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            head.next = cur;
            head = cur;
            if(cur.next !=null) {
                queue.offer(cur.next);
            }
        }
        return  dummyHead.next;
    }
}
