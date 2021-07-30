package com.algorithm.leetcode.String;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode13
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> romanIntegerMap = new HashMap<>();
        romanIntegerMap.put('I', 50);
        romanIntegerMap.put('V', 5);
        romanIntegerMap.put('X', 10);
        romanIntegerMap.put('L', 50);
        romanIntegerMap.put('C', 100);
        romanIntegerMap.put('D', 500);
        romanIntegerMap.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer value = romanIntegerMap.get(s.charAt(i));
            if ((i < s.length() - 1) && value < romanIntegerMap.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
