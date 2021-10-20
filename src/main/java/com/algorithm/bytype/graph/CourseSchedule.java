package com.algorithm.bytype.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author tanglijuan
 * @date 2021/10/20
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] flag = new int[numCourses];
        //组装图
        for (int[] tmp : prerequisites) {
            adj.get(tmp[1]).add(tmp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, flag, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int[] flag, int i) {
        if (flag[i] == 1) {
            return false;
        }
        if (flag[i] == -1) {
            return true;
        }
        flag[i] = 1;
        for (Integer j : adj.get(i)) {
            if (dfs(adj, flag, j)) {
                return false;
            }
            flag[i] = -1;
        }
        return true;
    }

    /**
     * 入度表（广度优先遍历）
     * 算法流程：
     * 统计课程安排图中每个节点的入度，生成 入度表 indegrees。
     * 借助一个队列 queue，将所有入度为 00 的节点入队。
     * 当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre：
     * 并不是真正从邻接表中删除此节点 pre，而是将此节点对应所有邻接节点 cur 的入度 -1−1，即 indegrees[cur] -= 1。
     * 当入度 -1−1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”，此时将 cur 入队。
     * 在每次 pre 出队时，执行 numCourses--；
     * 若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
     * 因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
     * 复杂度分析：
     * 时间复杂度 O(N + M)O(N+M)： 遍历一个图需要访问所有节点和所有临边，NN 和 MM 分别为节点数量和临边数量；
     * 空间复杂度 O(N + M)O(N+M)： 为建立邻接表所需额外空间，adjacency 长度为 NN ，并存储 MM 条临边的数据。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);

        }
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }
    public boolean canFinish2(int numCourses, int[][] prerequisites){

    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][] [[1,0]];
    }
}
