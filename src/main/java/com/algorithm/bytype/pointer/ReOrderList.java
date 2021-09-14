package com.algorithm.bytype.pointer;

/**
 * @author tanglijuan
 * @date 2021/9/7
 */
public class ReOrderList {
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

    /**
     * step1: find middle node
     * step2: split into two listNode
     * step3: reverse the second listNode
     * step4: merger two LisNode
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode midNode = findMidNode(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        //cut the listNode
        midNode.next = null;
        l2 = reverse(l2);
        mergeList(l1, l2);

    }

    public ListNode findMidNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1 != null && l2 != null) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;
            l1.next = l2;

            l1 = l1Tmp;
            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
