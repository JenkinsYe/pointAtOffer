package com.jenkins.oj;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        if (stack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 3, 5, 1, 2};
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.IsPopOrder(push, pop));
    }
}
