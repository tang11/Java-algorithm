package com.algorithm.shoppe;

/**
 * @author shenli
 * @date 2021/12/13
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i =0; i< n; i++) {
            while(nums[i]>0 && nums[i] <=n && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i =0; i< n;i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
