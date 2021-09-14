package com.algorithm.bytype.slidingWindow;

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
        Map<Character,Integer> map  = new HashMap<>();
        int maxLen = 0;
        int left =0;
        for (int i =0;i< s.length();i++){
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) +1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s) == 3);
    }
}
