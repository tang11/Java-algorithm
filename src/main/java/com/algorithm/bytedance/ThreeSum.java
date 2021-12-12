package com.algorithm.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/12/7
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twosum = twoSum(i + 1, nums, 0 - nums[i]);
            if (twosum != null && !twosum.isEmpty()) {
                for (List<Integer> tmp : twosum) {
                    tmp.add(nums[i]);
                    res.add(tmp);
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int i, int[] nums, int target) {
        int l = i;
        int r = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                int left = nums[l];
                int right = nums[r];
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[l]);
                tmp.add(nums[r]);
                result.add(tmp);
                while (l < r && nums[l] == left) {
                    l++;
                }
                while (l < r && nums[r] == right) {
                    r--;
                }
            }
        }
        return result;
    }


}
