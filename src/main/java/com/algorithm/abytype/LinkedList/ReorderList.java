package com.algorithm.abytype.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
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

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // are you there
        if(arr == null|| arr.length ==0) {
            return new int[]{-1,-1};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i < arr.length; i++) {
            if(map.containsKey(limit - arr[i])) {
                return new int[]{i,map.get(limit-arr[i])};

            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
}

