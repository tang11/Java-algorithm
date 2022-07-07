package com.algorithm.tenAlgorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenli
 * @date 2022/2/9
 */
public class CombinationSum {

    /**
     * leetcode39 link https://leetcode.com/problems/combination-sum/
     * <p>
     * given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen number sum to target.
     * <p>
     * the same number may be chosen from candidates an unlimited number of times, two combinations are unique if the
     * frequency of at least one of the chosen number is different.
     * <p>
     * example:
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * <p>
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     *
     * @param candidates
     * @param target
     * @return
     */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>());
        return result;
    }

    public static void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(result, candidates, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates =new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));

    }
}
