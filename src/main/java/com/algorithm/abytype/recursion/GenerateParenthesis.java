package com.algorithm.abytype.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * @date 2021/8/24
 */
public class GenerateParenthesis {
    /**
     * recursion
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "", n, n);
        return res;
    }

    public static void dfs(List<String> res, String sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(res, sb + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(res, sb + (")"), left, right - 1);
        }
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtracking(new StringBuffer(), res, n, n);
        return res;
    }

    public static void backtracking(StringBuffer path, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            path.append("(");
            backtracking(path, res, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0) {
            path.append(")");
            backtracking(path, res, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs2("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs2(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs2(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs2(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
        System.out.println(generateParenthesis1(n));
        System.out.println(generateParenthesis2(n));
    }
}
