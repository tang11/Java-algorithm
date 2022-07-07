package com.algorithm.leetcode.array.easy;
import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中inorderTraversal找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static  int[] twoSum(int[] nums, int target) {

        return  new int[]{};
    }

    public static void main(String[] args) {
        //test case one
        int testNums1[] = new int[]{2,7,11,15};
        int testTarget1 = 9;
        int result1[] = new int[]{0,1};
        assert Arrays.equals(twoSum(testNums1, testTarget1) , result1);

        //test case two
        int testNums2[] = new int[]{3,2,4};
        int testTarget2 = 6;
        int result2[] = new int[]{1,2};
        assert Arrays.equals(twoSum(testNums2, testTarget2) , result2);
    }
}

