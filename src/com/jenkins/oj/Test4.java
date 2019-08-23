package com.jenkins.oj;

import com.jenkins.oj.util.TreeNode;

public class Test4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[startPre]);
        int i = 0;
        for (i = startIn; i <= endIn; i++) {
            if (in[i] == treeNode.val)
                break;
        }
        treeNode.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn,
                in, startIn, i - 1);
        treeNode.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre,
                in,  i + 1, endIn);
        return treeNode;
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(test4.reConstructBinaryTree(pre, in).val);
    }
}
