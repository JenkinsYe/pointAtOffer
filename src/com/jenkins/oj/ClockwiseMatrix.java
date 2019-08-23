package com.jenkins.oj;

import java.util.ArrayList;
import java.util.Arrays;

public class ClockwiseMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length == 0) return null;
        int width = matrix.length;
        int length = matrix[0].length;
        boolean[][] flag = new boolean[width][length];
        int i, j;
        for (i = 0; i < width; i++){
            for (j = 0; j < length; j++){
                flag[i][j] = false;
            }
        }
        i = j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        boolean end = false;
        while (!end) {
            int si = i;
            int sj = j;
            // 一直往右走
            while (j + 1 < length && !flag[i][j+1]) {
                flag[i][j] = true;
                result.add(matrix[i][j]);
                j++;
            }

            // 一直往下走
            while (i + 1 < width && !flag[i+1][j]) {
                flag[i][j] = true;
                result.add(matrix[i][j]);
                i++;
            }

            while (j - 1 >=0 && !flag[i][j-1]) {
                flag[i][j] = true;
                result.add(matrix[i][j]);
                j--;
            }

            while (i - 1 >= 0 && !flag[i-1][j]) {
                flag[i][j] = true;
                result.add(matrix[i][j]);
                i--;
            }

            if (si == i && sj == j){
                result.add(matrix[i][j]);
                end = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ClockwiseMatrix clockwiseMatrix = new ClockwiseMatrix();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(clockwiseMatrix.printMatrix(matrix).toString());
    }
}
