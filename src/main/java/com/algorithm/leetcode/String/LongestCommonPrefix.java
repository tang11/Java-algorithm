package com.algorithm.leetcode.String;

/**
 *leetcode14
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null) {
            return "";
        }
        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            for(; j< commonPrefix.length() && j< strs[i].length(); j++ ){
                if(commonPrefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            commonPrefix = commonPrefix.substring(0,j);
            if(commonPrefix == ""){
                return "";
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        String[] testExamples1  = new String[]{"flower","flow","flight"};
        String[] testExample2 = new String[]{"dog","racecar","car"};
        System.out.println("result " +  longestCommonPrefix(testExamples1).equals("fl"));
        System.out.println("result " +  longestCommonPrefix(testExample2).equals(""));

    }
}
