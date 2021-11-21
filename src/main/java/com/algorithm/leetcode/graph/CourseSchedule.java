package com.algorithm.leetcode.graph;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/11/17
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1]
 */
public class CourseSchedule {
    HashMap<Integer, Integer> indegress = new HashMap<>();
    HashMap<Integer, List<Integer>> adj = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[]{};
        }
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
            indegress.put(i,0);
        }
        for (int[] item : prerequisites) {
            int cur = item[1];
            int next = item[0];
            indegress.put(next, indegress.getOrDefault(next, 0) + 1);
            adj.get(cur).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegress.get(i) == 0) {
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> adjNode= adj.get(cur);
            res.add(cur);
            for (int j: adjNode){
                indegress.put(cur,indegress.getOrDefault(j,0) -1);
                if (indegress.get(cur)==0) {
                    queue.offer(j);
                }
            }
        }
        if (res.size() == numCourses) {
            int[] arr = new int[res.size()];
            for (int i=0;i< res.size();i++) {
                arr[i]= res.get(i);
            }
            return  arr;
        }
        return new int[]{};

    }
}
