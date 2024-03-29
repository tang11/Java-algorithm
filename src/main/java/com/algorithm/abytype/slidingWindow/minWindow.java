package com.algorithm.abytype.slidingWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
//                    start = left;
//                    len = right - left;
                }
                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    window.put(d, window.getOrDefault(d, 0) - 1);
                    if (window.get(d) < need.get(d)) {
                        valid--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 23, 10, 1, 3};
        System.out.println(ArrayChallenge(array));
    }


    public static int ArrayChallenge(int[] arr) {
        Arrays.sort(arr);
        int maxNum = arr[arr.length - 1];
        int tot = 0;

        for (int i = 0; i < arr.length; i++) {
            tot += arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    tot += arr[j];
                    if (tot == maxNum) {
                        return 1;
                    }
                }
            }

            for (int k = 0; k < arr.length; k++) {
                if (i != k) {
                    tot -= arr[k];
                    if (tot == maxNum) {
                        return 0;
                    }
                }
            }
            tot = 0;
        }

        return 0;

    }
}


