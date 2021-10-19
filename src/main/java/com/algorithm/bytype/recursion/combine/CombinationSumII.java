package com.algorithm.bytype.recursion.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * 
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 * @date 2021/8/31
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(res, candidates, len, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int len, int begin, int target, List<Integer> tempList) {
        if (target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            dfs(res, candidates, len, i + 1, target - candidates[i], tempList);
            tempList.remove(tempList.size() - 1);
        }

    }

}
