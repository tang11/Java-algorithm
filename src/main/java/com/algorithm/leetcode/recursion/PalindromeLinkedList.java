package com.algorithm.leetcode.recursion;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 234
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 请判断一个链表是否为回文链表。
 */
public class PalindromeLinkedList {
    public boolean isPalindromeSolutionOne(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            vals.add(head.val);
            tail = tail.next;
        }
        int start = 0;
        int end = vals.size() -1;
        while(start < end) {
            if (vals.get(start) != vals.get(end) ) {
                return false;
            }
            start ++;
            end -- ;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode tail = head;
        while (tail != null) {
            tail = tail.next;
        }
        while (head != tail) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail =
        }
    }
}
