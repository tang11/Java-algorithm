package com.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * @date 2021/11/16
 *
 *       7
 *     /-2
 *    5
 *  /-2\-3
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates,target,0);
        return res;
    }

    void backtrack( List<List<Integer>> res, List<Integer> path,int[] candidates, int target,int begin) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i =begin;i< candidates.length;i++) {
            if(target>0) {
                path.add(candidates[i]);
                backtrack(res,path,candidates,target-candidates[i],i);
                path.remove(path.size()-1);
        }
    }
}
