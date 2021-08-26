package com.algorithm.bytype.recursion.permute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode
 * @date 2021/8/24
 */
public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combination = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combination;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(combination,phoneMap,digits,0,new StringBuffer());
        return combination;
    }

    public void backTrack(List<String> combination, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            combination.add(stringBuffer.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int letterCount = letters.length();
        for (int i =0; i < letterCount; i++){
            System.out.println("---->1 "+stringBuffer.toString());
            stringBuffer.append(letters.charAt(i));
            backTrack(combination,phoneMap,digits,index+1,stringBuffer);
            System.out.println("-------->2 "+stringBuffer.toString());

            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            System.out.println("--------->3 "+stringBuffer.toString());

        }
    }

    public static void main(String[] args) {
        String str= "23";
        PhoneNumber phoneNumber = new PhoneNumber();
        System.out.println(phoneNumber.letterCombinations(str));

    }
}
