package com.algorithm.leetcode.array.medium;

import java.util.PriorityQueue;

/**
 * @author shenli
 * @date 2022/7/12
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int x : nums) {
            heap.offer(String.valueOf(x));
        }
        StringBuilder res = new StringBuilder();
        while (heap.size() > 0) {
            res.append(heap.poll());
        }

        if (res.charAt(0) == '0') {
            return "0";
        }
        return res.toString();
    }

}
