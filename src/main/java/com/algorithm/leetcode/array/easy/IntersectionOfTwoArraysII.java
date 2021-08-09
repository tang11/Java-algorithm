package com.algorithm.leetcode.array.easy;

import java.util.*;

/**
 * leetcode350
 *
 * @date 2021/8/9
 */
public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start1 =0, start2 =0;
        List<Integer> res = new ArrayList<>();
        while(start1< nums1.length &&start2< nums2.length) {
            if(nums1[start1] == nums2[start2] ) {
                res.add(nums1[start1]);
                start2++;
                start1++;
            } else if(nums1[start1] > nums2[start2]){
                start2 ++;
            } else{
                start1 ++;
            }
        }
        int[] result = new int[res.size()];
        for(int i =0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length){
            return intersect2(nums2,nums1);
        }
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int item: nums1) {
            if(map.containsKey(item)){
                Integer value = map.get(item);

                map.put(item, ++value);
            } else{
                map.put(item,1);
            }
        }
        for(int key:nums2) {
            if(map.containsKey(key) && map.get(key) >0) {
                Integer value = map.get(key) ;
                map.put(key,--value);
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i =0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] result = new int[]{2,2};
        System.out.println(Arrays.equals(intersect2(nums1, nums2), result));

    }
}
