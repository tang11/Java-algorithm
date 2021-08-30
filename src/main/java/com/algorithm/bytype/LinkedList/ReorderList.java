package com.algorithm.bytype.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/8/30
 */
public class ReorderList {
    /**
     * using List
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        int i =0;
        int j = list.size()-1;
        while(i<j) {
            list.get(i).next = list.get(j);
            i++;
            if(i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        //最后一步 否则是循环链表
        list.get(i).next = null;
    }
}
