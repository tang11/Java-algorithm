package com.algorithm.bytype.binarySearch;

/**
 * @author tanglijuan
 * @date 2021/9/3
 */
public class MySqrt {
    public static int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println(mySqrt(x));

    }
}
