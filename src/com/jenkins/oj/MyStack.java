package com.jenkins.oj;

import java.util.Stack;

public class MyStack {
    Stack<Integer> stack = new Stack<>();
    int[] minList = new int[1000];
    int top = 0;

    public void push(int node) {
        stack.push(node);
        if (top == 0) {
            minList[top] = node;
        } else {
            minList[top] = Math.min(minList[top - 1], node);
        }
        top++;
    }

    public void pop() {
        stack.pop();
        top--;
    }

    public int top() {
        top--;
        return stack.pop();
    }

    public int min() {
        return minList[top - 1];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        System.out.println(stack.top);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }
}
