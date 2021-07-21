package com.algorithm.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode169
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    /**
     * HashMap
     * 通过hashMap存放nums[]的值和出现的次数
     * @param nums
     * @return
     */
    public static int majorityElementSolutionOne(int[] nums) {
        Map<Integer, Integer> valueTimesMap = countNums(nums);
        for (Map.Entry<Integer,Integer> entry : valueTimesMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }

    /**
     * sort array
     * 排序数组，因为多数元素的定义是出现的次数> n/2,所以数组中间的总是多数元素。
     * @param nums
     * @return
     */
    public static int majorityElementSolutionTwo(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     *投票法
     * 初始化候选人的票数为num[0],票数count初始化为1
     * 当遇到和候选人相同的数，则票数+1，否则票数-1
     * 当票数=0时，更换候选人 并将票数重置为1
     * 遍历完数组，候选人即为答案。
     * 因为投票法是遇到相同的则票数+1，遇到不同的则票数-1
     * 因为多数元素个数> n/2,所以多数元素的个数-其余元素的个数 结果>=1的
     * 就相当于多数元素和其他元素两两相互抵消，最后还剩余至少一个的多数元素
     * @param nums
     * @return
     */
    public static int majorityElementSolutionThree(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i =1; i < nums.length; i ++) {
            if (nums[i] == candidate) {
                count ++;
            } else{
                count --;
                if (count == 0) {
                    candidate = nums[i];
                    count =1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] testExample1 = new int[]{3, 2, 3};
        int testResult1 = 3;
        System.out.println("testResult1:" + (majorityElementSolutionOne(testExample1) == testResult1));
        int[] testExample2 = new int[]{2, 2, 1, 1, 1, 2, 2};
        int testResult2 = 2;
        System.out.println("testResult2:" + (majorityElementSolutionOne(testExample2) == testResult2));

        System.out.println("testResult1:" + (majorityElementSolutionTwo(testExample1) == testResult1));
        System.out.println("testResult2:" + (majorityElementSolutionTwo(testExample2) == testResult2));

        int[] testExample3 = new int[]{1,1,1,2,3,4,4,4,1,1,1};
        int testResult3 = 1;
        System.out.println("testResult1:" + (majorityElementSolutionThree(testExample1) == testResult1));
        System.out.println("testResult2:" + (majorityElementSolutionThree(testExample2) == testResult2));
        System.out.println("testResult3:" + (majorityElementSolutionThree(testExample3) == testResult3));



    }
}
