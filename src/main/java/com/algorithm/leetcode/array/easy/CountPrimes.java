package com.algorithm.leetcode.array.easy;

/**
 * leetcodeCount the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

    public static int countPrimes(int n) {

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count ++;
            }
        }
        return count;
    }

    private static boolean isPrime(int i) {
        for(int j = 2; j * j <=i; j++ ) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        int result = 4;
        System.out.println("result "+ (countPrimes(n) == result));
    }
}
