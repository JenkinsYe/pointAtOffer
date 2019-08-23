package com.jenkins.oj;

import com.jenkins.oj.util.TreeNode;

public class HasSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubStructure(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        return (root1.val == root2.val) && isSubStructure(root1.left, root2.left) && isSubStructure(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.right.right = new TreeNode(12);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(7);
        HasSubTree hasSubTree = new HasSubTree();
        System.out.println(hasSubTree.HasSubtree(root1, root2));
    }
}
