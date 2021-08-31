package com.algorithm.bytype.recursion.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
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
