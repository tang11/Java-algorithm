package com.algorithm.shoppe.medium;

import com.algorithm.leetcode.commonEntity.ListNode;

/**
 * @author tanglijuan
 * @date 2021/12/3
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                //这一步很巧妙，如果第一个和第二个相等，然后记录下值，从第一个向后删除
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }


        }
        return dummyHead.next;

    }

    public static void main(String[] args) {

    }
}
