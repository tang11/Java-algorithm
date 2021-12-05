package com.algorithm.shoppe.easy;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanglijuan
 * @date 2021/12/3
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visites = new HashSet<>();
        while (headA != null) {
            visites.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visites.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
