package com.algorithm.bytype.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author tanglijuan
 * @date 2021/8/29
 */
public class CloneGraph {
    /**
     * DFS
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Node,Node>());
    }
    public Node dfs(Node node, HashMap<Node,Node> map) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)){ return map.get(node);}
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node,cloneNode);
        for(Node tep: node.neighbors) {
            cloneNode.neighbors.add(dfs(tep, map));
        }
        return cloneNode;
    }


    /**
     * BFS
     * @param node
     * @return
     */
    public Node cloneGraph1(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node clone  = new Node(node.val, new ArrayList<>());
        map.put(node,clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node tmp: cur.neighbors){
                if(!map.containsKey(tmp)){
                    map.put(tmp, new Node(tmp.val,new ArrayList<>()));
                    queue.offer(tmp);
                }
                map.get(cur).neighbors.add(map.get(tmp));
            }

        }
        return clone;
    }

}
