package com.algorithm.shoppe;

import java.util.HashMap;

/**
 * @author tanglijuan
 * @date 2021/12/3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    static HashMap<Character, Integer> window = new HashMap<>();

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            max = Math.max(right - left, max);

        }
        return max;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = 3;

        System.out.println(lengthOfLongestSubstring(s));

    }
}
