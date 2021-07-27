package com.algorithm.leetcode.array.easy;

/**
 * leetcode66
 */
public class PlusOne {
    /**
     * 分为有9 的情况和其他情况
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >=0; i-- ) {
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {return  digits;}
        }
        digits = new int[digits.length +1];
        digits[0] = 1;
        return  digits;
    }

}
