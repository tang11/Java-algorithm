package com.algorithm.abytype.pointer;

/**
 * @authortanglijuan
 * @date 2021/11/2
 */
public class ReverseList {


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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = head;
        while (p.next != null) {
            ListNode moveNode = p.next;
            p.next = moveNode.next;
            moveNode.next = dummyHead.next;
            dummyHead.next = moveNode;
        }
        return dummyHead.next;

    }
}
