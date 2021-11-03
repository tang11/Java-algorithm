package com.algorithm.bytype.slidingWindow;

import java.util.HashMap;

/**
 * @authortanglijuan
 * @date 2021/11/3
 */
public class minWindow {
    static HashMap<Character, Integer> need = new HashMap<>();
    static HashMap<Character, Integer> window = new HashMap<>();

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (tLen == 0 || sLen == 0) {
            return "";
        }
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        //已经成功匹配到的字符种类（非字符个数）
        int valid = 0;
        while (right < sLen) {
            char c = s.charAt(right);
            //右指针右滑
            right++;
            //如果右指针现在滑到的字符是目标字符串是目标字符串的一个，那么更新窗口中的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //窗口从左边开始收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = "a";
        String t1 = "aa";
        System.out.println(minWindow(s, t));
        System.out.println(minWindow(s1, t1));
    }
}
