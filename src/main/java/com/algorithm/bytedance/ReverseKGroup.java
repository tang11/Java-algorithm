package com.algorithm.bytedance;

import com.algorithm.leetcode.commonEntity.ListNode;

/**
 * @author tanglijuan
 * @date 2021/12/7
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for(int i =0; i< k;i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;

    }

    public ListNode reverse(ListNode a,ListNode b) {
        ListNode prev = null;
        ListNode cur = a;
        ListNode next;
        while(cur != b) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
