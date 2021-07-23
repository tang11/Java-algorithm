package com.algorithm.service;

public class Test {
     public  static int fibonacci(int n) {
        if(n ==1 || n == 2) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
  public  static   int fibonacciDynamic(int n) {
       int[] dp = new int[n+1];
       dp[1]= 1; dp[2]= 2;
       for (int i = 3; i<= n; i ++) {
           dp[i] = dp[i-1] + dp[i-2];
       }
       return dp[n];
    }

    public static int climbingStairs(int n) {
         int[] dp = new int[n+1];
         dp[1] = 1;
         dp[2]= 2;
         for(int i = 3; i<= n; i ++) {
             dp[i] = dp[i-1] + dp[i-2];
         }
         return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println("result  " + fibonacci(5));
//        System.out.println("result  " + fibonacciDynamic(5));
        System.out.println("result  " + climbingStairs(3));

    }
}
