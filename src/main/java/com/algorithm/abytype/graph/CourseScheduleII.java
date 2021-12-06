package com.algorithm.abytype.graph;

import java.util.*;

/**
 * @author tanglijuan
 * @date 2021/10/21
 */
public class CourseScheduleII {

//    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> graphMapping = new ArrayList<>();
//        int[] inDegrees = new int[numCourses];
//        if (numCourses <= 0) {
//            return new int[0];
//        }
//        for (int i = 0; i < numCourses; i++) {
//            graphMapping.add(new ArrayList<>());
//        }
//        for (int[] tmp : prerequisites) {
//            graphMapping.get(tmp[1]).add(tmp[0]);
//            inDegrees[tmp[1]]++;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegrees[i] == 0) {
//                queue.add(i);
//            }
//        }
//    }
//
//
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (numCourses <= 0) {
//            return new int[0];
//        }
//        HashSet<Integer>[] adj = new HashSet[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            adj[i] = new HashSet<>();
//        }
//        int[] indegrees = new int[numCourses];
//        for (int[] p : prerequisites) {
//            adj[p[1]].add(p[0]);
//            indegrees[p[0]]++;
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegrees[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        int[] res = new int[numCourses];
//        int count = 0;
//        while (!queue.isEmpty()) {
//            Integer head = queue.poll();
//            res[count] = head;
//            count++;
//            Set<Integer> successors = adj[head];
//            for (Integer nextCourse : successors) {
//                indegrees[nextCourse]--;
//                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
//                if (indegrees[nextCourse] == 0) {
//                    queue.offer(nextCourse);
//                }
//            }
//        }
//
//        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
//        if (count == numCourses) {
//            return res;
//        }
//        return new int[0];
//    }
//
//    /*
//     *   如果使用DFS遍历，在选择下一步的结点的时候只能选择入度为0（更新后）的结点，需要注意到
//     * 可能在最外层的for循环中会重复出现入度为0的结点，因此可以在遍历了入度为0的结点之后将其
//     * 入度修改为-1这样就可以避免重复遍历了
//     * */
//    static int order;
//
//    public static int[] findOrderDFS(int num, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> graph = new HashMap<>();
//
//
//        int[] inDegree = new int[num];
//        for (int i = 0; i < prerequisites.length; i++) {
//            int first = prerequisites[i][1], next = prerequisites[i][0];
//            inDegree[next]++;
//            if (!graph.containsKey(first)) {
//                graph.put(first, new ArrayList<>());
//            }
//            graph.get(first).add(next);
//        }//根据有向关系建图并记录每个结点的入度大小
//        int[] visitOrder = new int[num];
//        for (int i = 0; i < num; i++) {
//            if (order == num) {
//                break;
//            }
//            if (inDegree[i] == 0) {
//                dfs(i, inDegree, visitOrder, graph);
//            }//只有入度为0的结点可以被立刻遍历
//        }
//        if (order == num) {
//            return visitOrder;
//        } else {
//            return new int[0];
//        }
//    }
//
//    public static void dfs(int pos, int[] inDegree, int[] visitOrder, Map<Integer, List<Integer>> graph) {
//        visitOrder[order++] = pos;
//        inDegree[pos]--;    //将入度为0的结点入度改为-1，这样就不会在for循环中被再次遍历
//        for (int next : graph.getOrDefault(pos, new ArrayList<>())) {
//            if (--inDegree[next] == 0) {
//                dfs(next, inDegree, visitOrder, graph);
//            }//仍然只能立即遍历入度为0的结点
//        }
//    }
//

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjMap = new HashMap<>();
        Map<Integer,Integer> inDegrees = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i< numCourses;i++) {
            inDegrees.put(i,0);
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] tmp: prerequisites) {
            int cur = tmp[1];
            int next = tmp[0];
            inDegrees.put(next, inDegrees.get(next)+1);
            adjMap.get(cur).add(next);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int j=0;j< numCourses;j++) {
            if(inDegrees.get(j) == 0) {
                queue.offer(j);
                res.add(j);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> adjEdge = adjMap.get(cur);
            for(int tmp:adjEdge) {
                int inDegree = inDegrees.get(tmp)-1;
                inDegrees.put(tmp,inDegree);
                if(inDegree ==0) {
                    queue.offer(tmp);
                    res.add(tmp);
                }
            }

        }
        if(res.size()==numCourses){
            int[] result = new int[numCourses];
            for(int i:res){
                result[i]=res.get(i);
            }
            return result;
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));

        int numCourses2 = 4;
        int[][] prerequisites2 = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses2, prerequisites2)));
        //   System.out.println(Arrays.toString(findOrderDFS(numCourses2, prerequisites2)));

    }
}
