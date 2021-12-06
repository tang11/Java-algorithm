package com.algorithm.abytype.graph;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/10/20
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(numCourses);
        HashMap<Integer, Integer> inDegrees = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }
        for (int[] tmp : prerequisites) {
            //(3,0)要学3先学0
            int cur = tmp[1];
            int next = tmp[0];
            inDegrees.put(next, inDegrees.get(next) + 1);
            map.get(cur).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees.get(i) == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> successorList = map.get(node);
            for (Integer tmp : successorList) {
                inDegrees.put(tmp, inDegrees.get(tmp) - 1);
                if (inDegrees.get(tmp) == 0) {
                    queue.offer(tmp);
                }
            }
        }
        for (int tmp : inDegrees.keySet()) {
            if (inDegrees.get(tmp) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}};
        System.out.println(canFinish(numCourses, prerequisites));

    }
}
