package com.algorithm.leetcode.recursion;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.List;

/**
 * leetcode21
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoListsSolutionOne(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public ListNode mergeTwoListsSolutionTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsSolutionTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsSolutionTwo(l1, l2.next);
            return l2;
        }
    }
    }
