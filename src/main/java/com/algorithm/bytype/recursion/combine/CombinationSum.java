package com.algorithm.bytype.recursion.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * 给定一个无重复元素的正整数数组ccandidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * @date 2021/8/31
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList,int[] candidates,int target, int index) {
        if(index == candidates.length){
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        dfs(res, tempList, candidates, target, index+1);
        if(target -candidates[index] >=0) {
            tempList.add(candidates[index]);
            dfs(res, tempList, candidates, target - candidates[index], index);
            tempList.remove(tempList.size()-1);
        }
    }
}
