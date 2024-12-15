package com.test;

import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int m = arr.length;
        int n=arr[0].length;
        int[][] res = new int[n][m];

        for(int j = 0; j<n ; j++){
            for (int i = m-1 ; i >=0 ; i--) {
                arr[j][m-1-i] = arr[i][j];
            }
        }
        for (int[] a:res){
            System.out.println(Arrays.toString(a));
        }

    }
}
