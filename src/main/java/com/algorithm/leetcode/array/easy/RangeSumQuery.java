package com.algorithm.leetcode.array.easy;

/**
 *leetcode303
 * @date 2021/8/2
 */
public class RangeSumQuery {

    /**
     * brute force
     */
    class NumArray {

        int[] NumArray = new int[]{};
        public NumArray(int[] nums) {
            this.NumArray =  nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for(int i = left; i <= right; i ++ ) {
                sum += NumArray[i];
            }
            return sum;
        }
    }

    /**
     * 有一个前n个数的和的数组sum，那第n+1个数的和等于前n个数的和 加上第n+1个数，
     * sumRange通过计算sum数组，
     * 如果从0开始sumRange 那么sum[right]就是前n个数的和
     * 如果不是从零，就是sum[right]-sum[left-1]
     */
    static class NumArrayDP {
        int[] sum ;

        public NumArrayDP(int[] nums) {
            sum = new int[nums.length];

            if(nums.length == 0) {return;}
            sum[0] = nums[0];
            for(int i = 1; i < nums.length; i ++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if(left ==0) {return sum[right];}
            return sum[right] - sum[left -1];


        }
    }

    public static void main(String[] args) {
        int[] testExample = new int[] {-2, 0, 3, -5, 2, -1};
        NumArrayDP dp = new NumArrayDP(testExample);
        dp.sumRange(0,2);
    }

}
