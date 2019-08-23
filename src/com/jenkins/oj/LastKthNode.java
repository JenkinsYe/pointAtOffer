package com.jenkins.oj;

import com.jenkins.oj.util.ListNode;

public class LastKthNode {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        if (head == null || k == 0)
            return null;
        while(k > 1) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            k--;
        }

        while(fast.next != null) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createListFromArray(new int[]{1, 2, 3, 4});
        LastKthNode lastKthNode = new LastKthNode();
        System.out.println(lastKthNode.FindKthToTail(listNode, 5).val);
    }
}
