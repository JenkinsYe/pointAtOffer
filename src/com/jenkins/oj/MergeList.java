package com.jenkins.oj;

import com.jenkins.oj.util.ListNode;

public class MergeList {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHeader = new ListNode(0);
        ListNode tail = dummyHeader;
        ListNode temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            tail.next = temp;
            tail = temp;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummyHeader.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createListFromArray(new int[]{1, 3, 5, 7, 9});
        ListNode listNode2 = ListNode.createListFromArray(new int[]{});
        ListNode.printList(MergeList.Merge(listNode1, listNode2));
    }
}
