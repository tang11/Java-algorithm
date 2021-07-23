package com.algorithm.leetcode.HashTable;

import com.algorithm.leetcode.commonEntity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *leetcode141
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle {
    public boolean hasCycleSolutionOne(ListNode head) {
       if(head== null || head.next == null) {
           return  false;
       }
       ListNode fastPointer = head.next;
       ListNode slowPointer = head;
       while (fastPointer != slowPointer) {
           if (fastPointer == null || fastPointer.next == null) {
               return  false;
           }
           fastPointer = fastPointer.next.next;
           slowPointer = slowPointer.next;
       }
       return true;
    }

    /**
     * 通过hash表判断节点是否被访问过
     * @param head
     * @return
     */
    public boolean hasCycleSolutionTwo(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head !=null) {
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head =head.next;
        }
        return false;
    }
    }
