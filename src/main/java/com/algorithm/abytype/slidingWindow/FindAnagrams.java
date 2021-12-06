package com.algorithm.abytype.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tanglijuan 438
 * @date 2021/11/4
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int tLen = p.length();
        int sLen = s.length();
        if (tLen == 0 || sLen == 0) {
            return res;
        }
        for (int i = 0; i < tLen; i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
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
                // 如果 window 的大小合适
                // 就把起始索引 left 加入结果
                if (right - left == p.length()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d) .equals( need.get(d))) {
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
}
