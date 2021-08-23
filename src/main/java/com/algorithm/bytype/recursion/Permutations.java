package com.algorithm.bytype.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenli
 * @date 2021/8/23
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] num, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            //参数传递是 值传递，对象类型变量在传参的过程中，
            // 复制的是变量的地址。这些地址被添加到 res 变量，但实际上指向的是同一块内存地址
            // ，因此我们会看到空的列表对象。解决的方法很简单，在add时; 这里做一次拷贝即可。
            res.add(new ArrayList<>(path));
            return;
        }
        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(num[i]);
                used[i] = true;
                System.out.println("  递归之前 => " + path);

                dfs(num, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);

            }
        }
    }

    public  static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        //终止条件
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(res, tempList,nums);
            tempList.remove(tempList.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations solution = new Permutations();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println("+++"+permute2(nums));
        System.out.println(lists);
    }

}
