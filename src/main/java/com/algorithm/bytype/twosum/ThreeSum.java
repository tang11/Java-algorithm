package com.algorithm.bytype.twosum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/17
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i< nums.length;i++) {
            List<Integer> twosum = twoSum(i+1,nums,0-nums[i]);
            if(twosum != null) {
                twosum.add(nums[i]);
                res.add(twosum);
            }
        }
        return res;
    }
    public static List<Integer> twoSum(int i,int[]nums, int target) {
        int l = i;
        int r = nums.length-1;
        while(l<r) {
            if(nums[l] + nums[r] > target) {
                r--;
            }else if(nums[l] + nums[r] < target) {
                l++;
            }else {
                List<Integer> result = new ArrayList<>();
                result.add(nums[l]);
                result.add(nums[r]);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{-1,0,1,2,-1,-4};
       threeSum(nums);
    }
}
