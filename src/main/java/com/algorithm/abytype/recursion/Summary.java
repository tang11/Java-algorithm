package com.algorithm.abytype.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/10/19
 */
public class Summary {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumDfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public static void combinationSumDfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                combinationSumDfs(res, path, candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public static void combinationSum2Dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                //不允许重复使用就i+1,如果允许重复使用就i
                combinationSum2Dfs(res, path, candidates, i + 1, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

    public static List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subSetDfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void subSetDfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, int index) {
        res.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            subSetDfs(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> subSet2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subSet2Dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void subSet2Dfs(List<List<Integer>> res, List<Integer> tempList, int[] nums, int index) {
        res.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            subSet2Dfs(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteDfs(res, new ArrayList<>(), nums, visited);
        return res;
    }

    public static void permuteDfs(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            permuteDfs(res, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUniqueDfs(res, new ArrayList<>(), nums, visited);
        return res;
    }

    public static void permuteUniqueDfs(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (path.contains(nums[i]) && i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            permuteUniqueDfs(res, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        int[] candidates2 = new int[]{2, 3, 6, 2, 7};
        System.out.println(combinationSum(candidates, target));
        System.out.println(combinationSum2(candidates2, target));

        int[] nums = new int[]{1, 2, 3};
        System.out.println(subSet(nums));
        int[] nums2 = new int[]{1, 2, 3, 1};

        System.out.println(subSet2(nums2));

        int[] num = new int[]{1, 1, 3};
        System.out.println(permute(nums));
        System.out.println(permuteUnique(num));
    }
}
