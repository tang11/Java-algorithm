package com.algorithm.bytype.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * @date 2021/8/24
 */
public class GenerateParenthesis {
    /**
     * recursion
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurseParenthesis(res, new StringBuffer(), n,n);
        return res;
    }
    public void recurseParenthesis(List<String> res ,StringBuffer sb, int left,int right){

    }


    public static void main(String[] args) {
        int n = 3;

    }
}
