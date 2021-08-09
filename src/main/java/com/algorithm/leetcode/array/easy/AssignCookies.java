package com.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**leetcode455
 * @date 2021/8/9
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childerAppetite = g.length;
        int cookieNum = s.length;
        int count =0;

        for(int i=0,j=0; i< childerAppetite && j< cookieNum; i++,j++) {
            while (j< cookieNum && s[j] < g[i]) {
                j++;
            }
            if(j< cookieNum){
                count ++;
            }
        }
        return count;
    }
}
