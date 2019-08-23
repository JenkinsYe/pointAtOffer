package com.jenkins.oj;

public class IsPostOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length-1);
    }

    public boolean verify(int[] sequence, int start, int end){
        if (start >= end) return true;
        int target = sequence[end];
        int i = 0;
        while (sequence[i] < target && i < end) i++;
        int j = i;
        while (j < end) {
            if (sequence[j] < target)
                return false;
            j++;
        }

        return verify(sequence, start, i - 1) && verify(sequence, i, end -1);
    }

    public static void main(String[] args) {
        IsPostOrder isPostOrder = new IsPostOrder();
        int[] order = new int[]{5,4,3,2,1};
        System.out.println(isPostOrder.VerifySquenceOfBST(order));
    }
}
