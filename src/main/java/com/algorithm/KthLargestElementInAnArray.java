package com.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/9/6
 */
public class KthLargestElementInAnArray {

    //暴力求解 O(NlogN)
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len -k];
    }
    public int findKthLargest1(int[] nums, int k) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
      for (int num: nums) {
          priorityQueue.offer(num);
          if (priorityQueue.size()> k){
              priorityQueue.poll();
          }
      }
      return priorityQueue.peek();
    }
}
