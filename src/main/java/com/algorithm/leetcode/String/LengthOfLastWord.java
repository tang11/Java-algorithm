package com.algorithm.leetcode.String;

/**
 * leetcode58
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return 0;
    }
}
