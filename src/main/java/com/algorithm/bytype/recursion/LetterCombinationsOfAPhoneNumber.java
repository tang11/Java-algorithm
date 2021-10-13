package com.algorithm.bytype.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authortanglijuan
 * @date 2021/10/13
 */
public class LetterCombinationsOfAPhoneNumber {

    static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }
        dfs(res, digits, new StringBuffer(), 0);
        return res;
    }

    public static void dfs(List<String> res, String digits, StringBuffer sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char letter = digits.charAt(index);
        String letters = phoneMap.get(letter);
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(res, digits, sb, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
