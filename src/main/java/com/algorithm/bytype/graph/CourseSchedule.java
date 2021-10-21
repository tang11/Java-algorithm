package com.algorithm.bytype.graph;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/10/20
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graphMapping = new ArrayList<>();
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphMapping.add(new ArrayList<>());
        }
        for (int[] tmp : prerequisites) {
            graphMapping.get(tmp[1]).add(tmp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graphMapping, flags, i)) {
                return false;
            }
        }
        return true;

    }

    public static boolean dfs(List<List<Integer>> graphMapping, int[] flags, int j) {
        if (flags[j] == 1) {
            return false;
        }
        if (flags[j] == -1) {
            return true;
        }
        flags[j] = 1;
        for (Integer i : graphMapping.get(j)) {
            if (!dfs(graphMapping, flags, i)) {
                return false;
            }

        }
        flags[j] = -1;
        return true;

    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graphMapping = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            graphMapping.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            graphMapping.get(cp[1]).add(cp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
            while (!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for (int cur : graphMapping.get(pre)) {
                    if (--indegrees[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 3}};
        System.out.println(canFinish(numCourses, prerequisites));
        System.out.println(canFinish1(numCourses, prerequisites));

    }
}
