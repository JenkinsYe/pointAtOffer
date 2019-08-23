package com.jenkins.oj;

public class Test6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(test6.minNumberInRotateArray(array));
    }
}
