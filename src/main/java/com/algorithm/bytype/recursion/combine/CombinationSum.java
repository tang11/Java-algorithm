package com.algorithm.bytype.recursion.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * 给定一个无重复元素的正整数数组ccandidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * @date 2021/8/31
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void dfs1(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        dfs1(res, tempList, candidates, target, index + 1);
        if (target - candidates[index] >= 0) {
            tempList.add(candidates[index]);
            dfs1(res, tempList, candidates, target - candidates[index], index);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs2(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void dfs2(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                dfs2(res, path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs3(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public static void dfs3(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (curSum > target) {
            return;
        }
        if (index == candidates.length) {
            return;
        }

        path.add(candidates[index]);
        dfs3(res, path, candidates, target, index, curSum + candidates[index]);
        path.remove(path.size() - 1);

        dfs3(res, path, candidates, target, index + 1, curSum);

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum1(candidates, target));
        System.out.println(combinationSum2(candidates, target));
        System.out.println(combinationSum3(candidates, target));

    }
}
