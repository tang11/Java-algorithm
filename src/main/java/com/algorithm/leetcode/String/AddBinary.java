package com.algorithm.leetcode.String;

import java.io.StringBufferInputStream;

/**
 *leetcode67
 * @date 2021/8/3
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static String addBinary2(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int length = m>n ? m+1 : n+1;
        int sum = 0;
        int carry = 0;
        StringBuilder sb =new StringBuilder();
        while(length > 0) {

            int num1 = m >=0 ? a.charAt(m) -'0': 0;

            int num2 = (n>=0)?b.charAt(n)-'0':0;
            char k  = (char) ((num1 + num2 + carry) %2 +'0');

            carry = (num1 + num2 + carry ) /2;
            sb.append(k);
            length --;
            m--;
            n--;
        }
        if(carry>0){
            sb.append("1");
        }
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        String result = "100";
        System.out.println(addBinary2(a, b));
    }
}
