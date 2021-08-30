package com.algorithm.bytype.LinkedList;

/**
 * @author tanglijuan
 * @date 2021/8/30
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fastNode= head;
        ListNode slowNode = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}
