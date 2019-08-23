package com.jenkins.oj;

import java.util.Stack;

public class Test5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int target = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return target;
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.push(3);
        test5.push(2);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        test5.push(1);
        System.out.println(test5.pop());
    }
}
