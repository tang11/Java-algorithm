package com.algorithm.nineType.arecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/29
 */
public class PermutationsII {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited,0);
        return res;

    }

    public static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visited,int level) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i!=level && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(res, nums, path, visited,i);
            visited[i]=false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permute(nums));
    }


}
