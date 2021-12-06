package com.algorithm.abytype.recursion.permute;

import java.util.*;

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
            dfs(res, digits, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> letterCombinationsSolutionTwo(String digits) {
        //store the result
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        //put mapping in a map
        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            queueLetterCombine(queue,map.get(digits.charAt(i)));
        }
        for (String tmp: queue) {
            combinations.add(tmp);
        }
        return combinations;
    }

    public static Queue<String> queueLetterCombine(Queue<String> queue, String[] letters) {
        if (queue.size() == 0) {
            for (String letter : letters) {
                queue.offer(letter);
            }
        } else {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String tmp = queue.poll();
                for (String s : letters) {
                    queue.add(tmp +s );
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
        System.out.println(letterCombinationsSolutionTwo(digits));
    }
}
