package com.algorithm.剑指offer;

import java.util.HashSet;

/**
 * @author shenli
 * @date 2021/8/20
 */
public class search {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length ;

        while(start <= end) {
            int mid = (start + end) /2;
            if(nums[mid] == target) {
                int sum =0;
                int indexLeft = mid -1;
                int indexRight = mid+1;

                while(indexLeft >=0 && nums[indexLeft] == target) {
                    sum++;
                    indexLeft--;
                }
                while(indexRight< nums.length && nums[indexRight] == target) {
                    sum++;
                    indexRight++;
                }
                return sum;
            }else if(nums[mid] > target) {
                end = mid -1;
            } else {
                start =mid +1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 1;
        search(nums, target);
        HashSet set = new HashSet();

    }
}
