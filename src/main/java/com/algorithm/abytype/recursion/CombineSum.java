package com.algorithm.abytype.recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/29
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombineSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, candidates, target, new ArrayList<>(), 0);
        return res;

    }

    public static void backTrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                backTrack(res, candidates, target - candidates[i], path, i );
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
