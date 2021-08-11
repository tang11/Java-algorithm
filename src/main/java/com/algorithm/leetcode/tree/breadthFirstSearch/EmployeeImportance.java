package com.algorithm.leetcode.tree.breadthFirstSearch;

import java.util.*;

/**
 * leetcode690
 * @date 2021/8/11
 */
public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    Map<Integer,Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for(int i =0; i<employees.size(); i++ ) {
            map.put(employees.get(i).id,employees.get(i));
        }
        return dfs(id);
    }

    public int dfs(int id) {
        int total = 0;
        Employee employee= map.get(id);
        total += employee.importance;
        for(Integer i:employee. subordinates) {
            total += dfs(i);
        }
        return total;
    }

    public int getImportance1(List<Employee> employees, int id) {
        for(int i =0; i<employees.size(); i++ ) {
            map.put(employees.get(i).id,employees.get(i));
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int total = 0;
        while(!queue.isEmpty()) {
            Employee cur = queue.poll();
            total += cur.importance;
            for(int i : cur.subordinates) {
                queue.offer(map.get(i));
            }
        }
        return total;
    }
}
