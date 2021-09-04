package com.algorithm.bytype.binarySearch;

/**
 * @author tanglijuan
 * @date 2021/8/31
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                int targetStart = mid;
                int targetEnd = mid;
                while (targetStart - 1 >= 0 && nums[targetStart - 1] == target && targetStart >= 0) {
                    targetStart--;
                }
                while (targetEnd + 1 < nums.length && nums[targetEnd + 1] == target && targetEnd >= 0) {
                    targetEnd++;

                }
                return new int[]{targetStart, targetEnd};
            }
        }
        return new int[]{-1, -1};

    }



    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target -1);
        int rightIdx = binarySearch(nums, target) -1;
        if (leftIdx<= rightIdx && nums[leftIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1,-1};
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int ans = nums.length;
        while(left<= right)  {
            int mid = (left +right) /2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid +1;}
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3};
        System.out.println(searchRange(nums, 1).toString());
    }
}
