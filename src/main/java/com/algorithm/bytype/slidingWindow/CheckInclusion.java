package com.algorithm.bytype.slidingWindow;

import java.util.HashMap;

/**
 * @author tanglijuan
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class CheckInclusion {

    static HashMap<Character, Integer> window = new HashMap<>();
    static HashMap<Character, Integer> need = new HashMap<>();

    public static boolean checkInclusion(String s, String t) {
        int left = 0;
        int right = 0;
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            //右边窗口移动
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //左边收缩-不同的题这里收缩条件会不一样，
            while (left - right > s.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(c, window.getOrDefault(d, 0) - 1);

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
