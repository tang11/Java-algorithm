package com.algorithm.bytedance;

import java.util.PriorityQueue;

/**
 * @author tanglijuan
 * @date 2021/12/7
 * 数组中的第K个最大元素
 */
public class FindKthLargest {

    //时间复杂度 o(nlogk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int e : nums) {
            priorityQueue.offer(e);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    //解法二 其实这个 O(N) 的时间复杂度是个均摊复杂度，因为我们的 partition 函数中需要利用 双指针技巧 遍历 nums[lo..hi]，那么总共遍历了多少元素呢？
    //最好情况下，每次 p 都恰好是正中间 (lo + hi) / 2，那么遍历的元素总数就是：
    //N + N/2 + N/4 + N/8 + … + 1
    //这就是等比数列求和公式嘛，求个极限就等于 2N，所以遍历元素个数为 2N，时间复杂度为 O(N)。
    // 这就是个等差数列求和，时间复杂度会退化到 O(N^2)
    public int findKthLargest2(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        k = nums.length - k;
        while (lo < hi) {
            // 在 nums[lo..hi] 中选一个分界点
            int p = partition(nums, lo, hi);
            if (p < k) {
                // 第 k 大的元素在 nums[p+1..hi] 中
                lo = p + 1;
            } else if (p > k) {
                // 第 k 大的元素在 nums[lo..p-1] 中
                hi = p - 1;
            } else {
                // 找到第 k 大元素
                return nums[p];
            }
        }
        return -1;
    }

    int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }

    // 交换数组中的两个元素
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
