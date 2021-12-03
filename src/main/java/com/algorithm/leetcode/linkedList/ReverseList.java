package com.algorithm.leetcode.linkedList;

import com.algorithm.leetcode.commonEntity.ListNode;

/**
 * @author tanglijuan
 * @date 2021/12/2
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
