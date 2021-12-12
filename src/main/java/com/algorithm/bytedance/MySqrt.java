package com.algorithm.bytedance;

/**
 * @author tanglijuan
 * @date 2021/12/7
 */
public class MySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static double mySqrt3(int x) {
        double precision = 0.001;
        double l = 0, r = x, ans = -1;
        while (l <= r) {
            double mid = l + (r - l) / 2.00;
            if (Math.abs(mid * mid - x) < precision) {
                return mid;
            } else if (mid * mid > x){
                r = mid - 1;
            } else if (mid * mid < x) {
                l = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt3(8));
    }

}
