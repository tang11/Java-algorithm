package com.algorithm.abytype.slidingWindow;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/9/7
 */
public class MaxSlidingWindow {
    /* 单调队列的实现 */
    static class MonotonicQueue {
        MonotonicQueue() {

        }

        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
