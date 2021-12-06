package com.algorithm.bytedance;

import java.util.HashMap;

/**
 * @author tanglijuan
 * @date 2021/12/7
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max =0;

        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    window.put(d, window.getOrDefault(d, 1) - 1);
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
