package com.algorithm.leetcode.array.easy;

/**
 * leetcode27
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// * 解法有两种
//     * 1、双指针一个从头开始，一个从尾部开始，等两个相遇。
//     * 2、双指针都从头开始，一个是快指针，一个是慢指针
public class RemoveElement {

    /**
     * 一个指针指向开头，一个指针指向结尾，
     * 当开头的指针指向的值==target时，就把结尾的指针指向的值赋值到开头的位置，并没有管结尾的指针指向的值是否==target,
     * 因为这个时候开始的指针并没有位移，等到判断开始指针的值!=target时才++，相当于先把结尾的值放到开始的位置，然后再判断是否==target
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementSolutionOne(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }
        return start;
    }

    /**
     * 两个指针都从头开始, j指针不等于val是，把值赋值给i位置，i向前移一位，j也移一位
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementSolutionTwo(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++ ) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElementSolutionThree(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++ ) {
            if(nums[i] == val) {
                nums[i] = nums[j];
            } else {
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] testExamplesOne = new int[]{3, 2, 2, 3};
        int targetOne = 3;
        int resultOne = 2;

        int[] testExamplesTwo = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int targetTwo = 2;
        int resultTwo = 5;
        System.out.println("result One:" + (removeElementSolutionOne(testExamplesOne, targetOne) == resultOne));
        System.out.println("result Two:" + (removeElementSolutionOne(testExamplesTwo, targetTwo) == resultTwo));

    }
}
