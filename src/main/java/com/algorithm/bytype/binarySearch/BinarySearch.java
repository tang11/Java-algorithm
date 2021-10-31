package com.algorithm.bytype.binarySearch;

/**
 * @author tanglijuan
 * @date 2021/10/28
 */
public class BinarySearch {
    public static int findNumberIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        //为什么是<= 而不是<,因为初始化end是nums.length - 1,即最后一个元素的索引，而不是nums.length；
        // 这二者可能出现在不同的二分查找中，前者相当于两端都闭区间【start,end】,
        // 后者相当于左闭右开【start,end),因为索引==nums.length 是越界的
        // while (start <= end) 终止条件时start = end+1; 写成区间【right+1,right】
        // while (start < end)终止条件是start = end,写成区间[right,right],换成具体数字[2,2]
        //这时候区间非空，还有一个数字2，但此时while循环终止了，也就是区间【2，2】被漏掉了，索引2并没有被搜索，如果直接返回-1就是错误的，
        // 如果非要用while(start<end)也可，返回的时候增加个判断 return nums[start] == target?start:-1; 参考findNumberIndex1
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int findNumberIndex1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - 1) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return nums[start] == target ? start : -1;
    }


    public static int findLeftIndex(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    public static int findLeftIndex1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //搜索区间为【left,right】
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                //搜索区间为【mid+1,right】
                left = mid + 1;
            } else if (nums[mid] > target) {
                //搜索区间为【left,mid-1】
                right = mid - 1;
            } else if (nums[mid] == target) {
                //搜索右侧边界
                right = mid - 1;
            }
        }
        //检查出界情况
        if (left > nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int findRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 5};
        int target = 5;
        System.out.println(findNumberIndex(nums, target));
        System.out.println(findNumberIndex1(nums, target));
        System.out.println(findRightIndex(nums, target));


        int[] nums1 = new int[]{2, 3, 5, 7};
        System.out.println("lefIndex" + findLeftIndex(nums1, 8));
        System.out.println("rightIndex" + findRightIndex(nums1, 8));
        System.out.println("lefIndex" + findLeftIndex(nums, target));
        System.out.println("rightIndex" + findRightIndex(nums, target));
    }
}
