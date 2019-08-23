package com.jenkins.oj;

import com.jenkins.oj.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.createListFromArray(array);
        System.out.println(test3.printListFromTailToHead(listNode));
    }

}

