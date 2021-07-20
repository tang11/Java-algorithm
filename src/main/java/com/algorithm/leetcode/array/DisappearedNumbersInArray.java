package com.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * leetcode448
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DisappearedNumbersInArray {
    public static Integer[] findDisappearedNumbers(Integer[] nums) {
        int maxNum = nums.length;
        List<Integer> resultList =new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < maxNum ; i++) {
            set.add(nums[i]);
        }
        for (int i =1; i <= maxNum; i++) {
            if (!set.contains(i)){
                resultList.add(i);
            }
        }
        return resultList.toArray(new Integer[resultList.size()]);
    }


    public static void main(String[] args) {
        Integer[] testExample1 = new Integer[]{4, 3, 2, 7, 8, 2, 3, 1};
        Integer[] testResult1 = new Integer[]{5, 6};

        System.out.println("testResult1 " + Arrays.equals(findDisappearedNumbers(testExample1), testResult1));
        Integer[] testExample2 = new Integer[]{1, 1};
        Integer[] testResult2 = new Integer[]{2};
        System.out.println("testResult2 " + Arrays.equals(findDisappearedNumbers(testExample2), testResult2));


    }

}
