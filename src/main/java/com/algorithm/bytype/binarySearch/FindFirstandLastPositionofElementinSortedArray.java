package com.algorithm.bytype.binarySearch;

import java.util.Arrays;

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


    public static int[] searchRange3(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int i = -1;;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]== target){
                i=mid;
                break;
            }else if(nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        if(i == -1) {
            return new int[]{-1,-1};
        }
        int startIndex = i;
        while(startIndex>=0 && nums[startIndex]==target) {
            startIndex--;
        }
        int endIndex = i;
        while(endIndex< nums.length&& nums[endIndex] == target) {
            endIndex++ ;

        }
        return new int[]{startIndex+1,endIndex-1};
    }


    public static int[] searchRange2(int[] nums, int target) {
        if(nums.length==0) {
            return new int[]{-1,-1};
        }
        int left = findLeftIndex(nums, target);
        int right = findRightIndex(nums,target);
        return new int[]{left,right};
    }

    public static int findLeftIndex(int[] nums,int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = (left + right) /2;
            if(nums[mid] == target) {
                right = mid;
            }else if(nums[mid] > target) {
                right = mid ;
            } else if(nums[mid] < target) {
                left = mid +1;
            }
        }
        if(left == nums.length) {return -1;}
        return nums[left] == target ? left :-1;
    }

    public static int findRightIndex(int nums[], int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = (left + right) /2;
            if(nums[mid] == target) {
                left = mid +1;
            }else if(nums[mid] > target) {
                right = mid;
            }else if(nums[mid]< target) {
                left = mid +1;
            }
        }
        if(left == 0) {return -1;}
        return nums[left -1] == target ? left-1: -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int[] nums1 = new int[]{5,7,7,8,8,10};
       // System.out.println(searchRange(nums, 1).toString());
//        System.out.println(Arrays.toString(searchRange3(nums ,1)));
        System.out.println(Arrays.toString(searchRange2(nums1 ,8)));

    }
}
