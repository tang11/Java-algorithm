package com.algorithm.abytype.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/9/8
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            //如果window中出现重复字符，开始移动left缩小窗口
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                if (window.containsKey(c1)) {
                    window.put(c1, window.get(c1) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s) == 3);
    }
}
