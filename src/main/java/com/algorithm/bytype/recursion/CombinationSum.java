package com.algorithm.bytype.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * @author tanglijuan
 * @date 2021/8/23
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] cadidates, int target, int index) {
        if (index == cadidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        System.out.println("---->1");

        backtrack(res, tempList, cadidates, target, index + 1);
        System.out.println("------->2");

        if (target - cadidates[index] >= 0) {
            tempList.add(cadidates[index]);
            System.out.println("------------>3");
            backtrack(res, tempList, cadidates, target - cadidates[index], index);
            tempList.remove(tempList.size() - 1);
            System.out.println("---------------->4");

        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
