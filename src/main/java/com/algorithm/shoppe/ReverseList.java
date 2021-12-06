package com.algorithm.shoppe;

import com.algorithm.leetcode.commonEntity.ListNode;

/**
 * @author tanglijuan
 * @date 2021/12/3
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseList {
    //1->2->3
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next =  head.next;
            head.next = pre;
            pre = head;
            head =next;
        }
        return  pre;
    }
}
