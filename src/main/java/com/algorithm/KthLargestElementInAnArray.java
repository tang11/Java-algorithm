package com.algorithm;

import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/9/6
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i =0; i< k; i++) {
            minHeap.add(nums[i]);
        }
        for(int i = k;i< nums.length; i++) {
            Integer topEl = minHeap.peek();
            if(nums[i] > topEl) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
