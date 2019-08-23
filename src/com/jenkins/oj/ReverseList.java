package com.jenkins.oj;

import com.jenkins.oj.util.ListNode;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode dummyHeader = new ListNode(0);
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = dummyHeader.next;
            dummyHeader.next = temp;
        }
        return dummyHeader.next;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode listNode = ListNode.createListFromArray(new int[]{});
        ListNode.printList(reverseList.ReverseList(listNode));
    }
}
