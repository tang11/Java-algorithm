package com.algorithm.leetcode.String;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode20
 * Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == pairs.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String testExample1 = "()";

        String testExample2 = "()[]{}";
        String testExample3 = "(]";
        String testExample4 = "([)]";
        System.out.println("testResult1: "+ (isValid(testExample1) == true));
        System.out.println("testResult2: "+ (isValid(testExample2) == true));
        System.out.println("testResult3: "+ (isValid(testExample3) == false));
        System.out.println("testResult4: "+ (isValid(testExample4) == false));





    }

}
