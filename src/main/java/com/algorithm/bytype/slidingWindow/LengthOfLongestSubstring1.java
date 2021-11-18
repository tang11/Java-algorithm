package com.algorithm.bytype.slidingWindow;

import java.util.HashMap;

/**
 * @author tanglijuan
 * @date 2021/11/18
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LengthOfLongestSubstring1 {

    HashMap<Character, Integer> window = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
         while (window.get(c)>1) {
             char d =  s.charAt(left);
             window.put(d,window.getOrDefault(d,0)-1);
             left++;
         }
            length= Math.max(right -left, length);
        }

        return  length;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";

    }
}



