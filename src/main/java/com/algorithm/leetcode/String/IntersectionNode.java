package com.algorithm.leetcode.String;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 方法一：通过hashSet，把链表A中的值都放到hashSet中，然后遍历链表B,如果在hashset中存在，则是相交的节点
 * 方法二：双指针通用解法，一个指针指向链表A，一个指针指向链表B,同步向前，如果A变为空，则指向链表B的头部（同理，如果B为空，变为指向A）,
 * 相当于A和B组成了循环链表，最终会在某个点相遇
 */
public class IntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 通过hashSet的方式
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeSolutionOne(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hashSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 通过双指针
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeSolutionTwo(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }

    public static void main(String[] args) {

    }
}
