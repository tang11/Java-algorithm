package com.algorithm.abytype.priorityQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tanglijuan
 * @date 2021/11/1
 */
public class MyStack {
    Queue<Integer> queue;
    Queue<Integer> helper;
    public MyStack() {
       queue  = new LinkedList<Integer>();
       helper = new LinkedList<Integer>();
    }

    public void push(int x) {
        helper.offer(x);
        while(!queue.isEmpty()){
            helper.offer(queue.poll());
        }
        Queue<Integer> temp = queue;
        queue = helper;
        helper = temp;

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    class MyStackUsingOnQueue{
        Queue<Integer> queue;
        public MyStackUsingOnQueue() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i<n;i++) {
                queue.offer(queue.poll());
            };

        }

        public int pop() {
          return   queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
