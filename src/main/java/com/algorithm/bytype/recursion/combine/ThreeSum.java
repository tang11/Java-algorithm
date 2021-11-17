package com.algorithm.bytype.recursion.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i < nums.length; ++i){
            if(nums[i] > 0) {
                return res;
            }
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l =i+1;
            int r = nums.length -1;
            while(l<r) {
                int tmp =nums[i]+ nums[l] + nums[r];
                if(tmp ==0) {
                    List<Integer> list  =new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while(l<r && nums[l] == nums[l+1]){++l;}
                    while(l<r && nums[r]==nums[r-1]){--r;}
                    ++l;
                    --r;
                } else if(tmp <0){
                    ++l;
                } else{
                    --r;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4} ;
        System.out.println( threeSum(nums));
    }
}
