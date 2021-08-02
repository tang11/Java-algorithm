package com.algorithm.leetcode.HashTable;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.HashSet;
import java.util.List;

/**
 * leetcode160
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNodeSolutionOne(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerOne = headA;
        ListNode pointerTwo = headB;
        while (pointerOne != pointerTwo) {

            pointerOne = pointerOne == null ? headB : pointerTwo.next;
            pointerTwo = pointerTwo == null ? headA : pointerTwo.next;
        }
        return pointerOne;
    }

    public ListNode getIntersectionNodeSolutionTwo(ListNode headA, ListNode headB) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (listNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
