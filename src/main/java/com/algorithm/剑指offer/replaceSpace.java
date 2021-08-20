package com.algorithm.剑指offer;

/**
 *
 * @date 2021/8/15
 */
public class replaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < s.length(); i++) {
            if(s.charAt(i)==' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
