package com.algorithm.abytype.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tanglijuan
 * @date 2021/10/20
 */
public class TopologicalSort {
    /**
     * Get topological ordering of the input directed graph
     *
     * @param n             number of nodes in the graph
     * @param adjacencyList adjacency list representation of the input directed graph
     * @return topological ordering of the graph stored in an List<Integer>.
     */
    public static List<Integer> topologicalSort(int n, int[][] adjacencyList) {
        List<Integer> res = new ArrayList<>();
        int[] inDegrees = new int[n];
        for (int[] tmp : adjacencyList) {
                inDegrees[tmp[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] ==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res.add(cur);
            for (int i: adjacencyList[cur]) {
                inDegrees[i]--;
                if (inDegrees[i]==0){
                    queue.offer(i);
                }
            }
        }
        return queue.size() ==n? res: new ArrayList<>();
    }

    public static void main(String[] args) {
        int n =5;
        int[][] adj = new int[][]{{0,1},{2,3},{3,4}};
        System.out.println(topologicalSort(n,adj));
    }
}