package com.algorithm.abytype.pointer;

/**
 * @author tanglijuan
 * @date 2021/9/7
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("array can not be empty");
            }
            this.val = nums[0];
            ListNode curr = this;
            for (int i = 1; i < nums.length; i++) {
                curr.next = new ListNode(nums[i]);
                curr = curr.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                s.append(cur.val);
                s.append(" -> ");
                cur = cur.next;
            }
            s.append("NULL");
            return s.toString();
        }
    }

    /**
     * fast pointer slow pointer
     */
   static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fastNode = head;

            ListNode slowNode=  head;
            while(fastNode != null && fastNode.next != null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }
            return slowNode;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        // int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        Solution solution = new Solution();
        ListNode res = solution.middleNode(head);
        System.out.println(res);
    }

}
