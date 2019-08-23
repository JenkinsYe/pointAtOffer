package com.jenkins.oj;

import com.jenkins.oj.util.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllPathSum {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result;
        result = dfs(root, 0, target, new ArrayList<>());
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

        return result;
    }

    public ArrayList<ArrayList<Integer>> dfs(TreeNode root, int weight, int target, ArrayList<Integer> temp) {
        if (root.left == null && root.right == null) {
            if ((weight + root.val) == target) {
                temp.add(root.val);
                ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
                ArrayList<Integer> newList = new ArrayList<>();
                for (int i = 0; i < temp.size(); i++) {
                    newList.add(temp.get(i));
                }
                arrayLists.add(newList);
                temp.remove(temp.size() - 1);
                return arrayLists;
            } else {
                return new ArrayList<>();
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        temp.add(root.val);
        if (root.left != null) {
            result.addAll(dfs(root.left, weight + root.val, target, temp));
        }
        if (root.right != null) {
            result.addAll(dfs(root.right, weight + root.val, target, temp));
        }
        temp.remove(temp.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        AllPathSum allPathSum = new AllPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        System.out.println(allPathSum.FindPath(root, 4).toString());

    }
}
