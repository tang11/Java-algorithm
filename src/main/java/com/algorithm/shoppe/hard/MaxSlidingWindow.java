package com.algorithm.shoppe.hard;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/12/3
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 */
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> window = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(k - 1, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            window.put(nums[i], i);
            queue.offer(nums[i]);
        }
        int right = k;
        int start = 0;
        int index =0;
        int[] res = new int[]{nums.length - k + 1};
        while (right < nums.length) {
            int cur = nums[right];
            right++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
    }
}
