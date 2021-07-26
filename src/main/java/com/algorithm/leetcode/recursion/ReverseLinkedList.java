package com.algorithm.leetcode.recursion;

import com.algorithm.leetcode.commonEntity.ListNode;

/**
 * leetcode 206
 *  Palindrome Linked ListGiven the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
           ListNode next = cur.next;
           cur.next = pre;
           pre  = cur;
           cur = next;
        }
        return  pre;
    }
}
