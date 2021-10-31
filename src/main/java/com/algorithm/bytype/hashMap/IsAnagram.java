package com.algorithm.bytype.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanglijuan
 * @date 2021/8/29
 */
public class IsAnagram {
     static HashMap<Character,Integer> map = new HashMap<>();
    public static boolean isAnagram(String s, String t) {
        for(int i =0;i< s.length();i++) {
            if(map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }

        for(int j =0;j< t.length();j++) {
            if(map.get(t.charAt(j)) == null) {
                return false;
            }else {
                int num = map.get(t.charAt(j));
                if(num==1) {
                    map.remove(t.charAt(j));
                }else{
                    map.put(t.charAt(j),num-1);
                }
            }

        }
        return map.size()>0 ? false:true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t= "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
