package com.algorithm.bytype.slidingWindow;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/9/7
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left=0;
        int right =k;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k-1,Collections.reverseOrder());
        HashMap<Integer,Integer> window = new HashMap<Integer,Integer>();
        int[] res =new int[nums.length -k+1];
        for(int i=0;i<k;i++) {
            queue.offer(nums[i]);
            window.put(nums[i],i);
        }
        int index =0;
        while(right< nums.length) {
            Integer temp =  queue.peek();
            res[index] =temp;
            if(window.get(temp)==left) {
                queue.remove();
                queue.offer(nums[right]);
            }
            window.put(nums[right],right);
            right++;
            left++;
            index++;

        }
        return res;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
//        int[] nums1 = new int[]{1,-1};
//        int k1 =1;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums1,k1)));
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
