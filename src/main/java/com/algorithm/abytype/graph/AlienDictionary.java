package com.algorithm.abytype.graph;

import java.util.Arrays;

/**
 * @author tanglijuan
 * @date 2021/10/22
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        boolean[][] graph = new boolean[26][26];
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        buildGraph(words, graph, visited);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0) {
                if (!dfs(graph, visited, i, sb)) return "";
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] graph, int[] visited, int i, StringBuilder sb) {
        visited[i] = 1;
        for (int j = 0; j < 26; j++) {
            if (visited[j] == -1) continue;
            if (!graph[i][j]) continue;
            if (visited[j] == 1) return false;
            if (visited[j] == 0) {
                if (!dfs(graph, visited, j, sb)) return false;
            }
        }
        sb.append((char) ('a' + i));
        visited[i] = 2;
        return true;
    }

    private void buildGraph(String[] words, boolean[][] graph, int[] visited) {
        for (int i = 0; i < words.length - 1; i++) {
            int[] relation = compareWords(words[i], words[i + 1]);
            if (relation == null) continue;
            graph[relation[0]][relation[1]] = true;
            markLetters(words[i], visited);
        }
        if (words.length != 0) markLetters(words[words.length - 1], visited);
    }

    private void markLetters(String w1, int[] visited) {
        for (char ch : w1.toCharArray()) visited[ch - 'a'] = 0;
    }

    private int[] compareWords(String w1, String w2) {
        int pt1 = 0, pt2 = 0;

        while (pt1 < w1.length() && pt2 < w2.length()) {
            if (w1.charAt(pt1) != w2.charAt(pt2)) {
                return new int[]{w1.charAt(pt1) - 'a', w2.charAt(pt2) - 'a'};
            }
            pt1++;
            pt2++;
        }
        return null;
    }

}
