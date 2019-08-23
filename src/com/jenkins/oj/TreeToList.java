package com.jenkins.oj;

import com.jenkins.oj.util.TreeNode;

import java.util.ArrayList;

public class TreeToList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(pRootOfTree, list);

        TreeNode head = list.get(0);
        TreeNode tail = head;
        head.left = null;
        for (int i = 1; i < list.size(); i++) {
            tail.right = list.get(i);
            list.get(i).left = tail;
            tail = list.get(i);
        }
        tail.right = null;
        return head;
    }

    public void inOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root.left != null) {
            inOrder(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode proot = new TreeToList().Convert(root);
        System.out.println(proot.val);
        System.out.println(proot.right.val);
    }
}
