package com.algorithm.bytype.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/9/7
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = k - 1;
        int i = start;
        int maxValue = Integer.MIN_VALUE;
        while (i <= end) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];

            }
            i++;
        }
        list.add(maxValue);
        start++;
        end++;
        while (end < nums.length) {
            if (nums[end] > maxValue) {
                maxValue = nums[end];
            }
            list.add(maxValue);
            end++;
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }


    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length ==0 ) {
            return null;
        }
        int[] result = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        for(int i =0; i< k;i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        result[0] = max;
        int index = 1;
        for(int j = k;j< nums.length;j++) {
            if(nums[j] > max) {
                max = nums[j];
            }
            result[index] = max;
            index++;
        }
        return result;

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
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }
}
