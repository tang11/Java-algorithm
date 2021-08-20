package com.algorithm.剑指offer;

import java.util.Stack;

/**
 * @date 2021/8/15
 */
public class reversePrint {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            size++;
        }
        int[] res = new int[size];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
