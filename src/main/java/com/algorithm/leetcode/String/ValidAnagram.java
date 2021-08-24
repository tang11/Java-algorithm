package com.algorithm.leetcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/8/10
 */
public class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] table  = new int[26];
        for(int i =0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] ++;
        }
        for(int j = 0; j < t.length(); j++) {
            table[t.charAt(j) - 'a']--;
            if( table[t.charAt(j) - 'a'] <0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) != null) {
                int count = sMap.get(s.charAt(i)) + 1;
                sMap.put(s.charAt(i), count);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < t.length(); j++) {
           Integer value= (sMap.getOrDefault(t.charAt(j), 0)) -1;
           if (value < 0) {
               return false;
           }
           sMap.put(t.charAt(j), value);
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }
}
