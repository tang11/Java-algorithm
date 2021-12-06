package com.algorithm.abytype.recursion.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode77
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 *
 * @date 2021/8/25
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int index) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            System.out.println("递归之前 => " + tempList);

            backtrack(res, tempList, n, k, index+1);
            tempList.remove(tempList.size() - 1);
            System.out.println("递归之后 => " + tempList);

        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        Combine combine = new Combine();
        System.out.println(combine.combine(n, k));
    }
}
