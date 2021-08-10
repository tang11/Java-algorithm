package com.algorithm.leetcode.String;

import java.util.HashMap;

/**
 * leetcode205
 *
 * @date 2021/8/10
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();
        for (int i =0; i < s.length(); i++){
            char k = s.charAt(i);
            char j = t.charAt(i);
            if((sMap.containsKey(k) && sMap.get(k) != j) || (tMap.containsKey(j) && tMap.get(j) != k)) {
                return false;
            }
            sMap.put(k, j);
            tMap.put(j, k);

        }
        return true;
    }

}
