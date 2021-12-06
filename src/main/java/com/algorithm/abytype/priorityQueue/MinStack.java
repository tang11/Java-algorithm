package com.algorithm.abytype.priorityQueue;

import java.util.Stack;

/**
 * @author tanglijuan
 * @date 2021/9/6
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(helper.isEmpty()) {
            helper.push(val);
        } else {
            if( helper.peek()>=val) {
                helper.push(val);
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        if(val == helper.peek()){
            helper.pop();
        }

    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(helper.isEmpty()){
            return -1;
        }
        return helper.peek();
    }

}

