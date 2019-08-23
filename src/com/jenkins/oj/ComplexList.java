package com.jenkins.oj;

import com.jenkins.oj.util.RandomListNode;

public class ComplexList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode temp = pHead;
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = pHead;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = pHead.next;
        while (temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next;
        head.next.random = head.next.next.next.next;
        head.next.next.random = null;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = null;
        ComplexList complexList = new ComplexList();
        RandomListNode phead = complexList.Clone(head);
        System.out.println(phead.next.random.label);
    }
}
