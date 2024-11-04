package com.sorting;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int arr[]={2,8,5,3,6,7};
        System.out.println( Arrays.toString(mergesort_1(arr)) );
    }

    private static int[] mergesort_1(int[] arr) {//original array was not modified
        if(arr.length==1){
            return arr;
        }
        int mid= arr.length/2;
        int arr1[]=mergesort_1(Arrays.copyOfRange(arr,0,mid));
        int arr2[]=mergesort_1(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(arr1,arr2);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int i=0;
        int j=0;
        int ind=0;
        int new_arr[]=new int[arr1.length+arr2.length];
        while(i<arr1.length||j<arr2.length){
            if(i<arr1.length && j<arr2.length && arr1[i]<arr2[j]){
                new_arr[ind++]=arr1[i];
                i++;
            } else if (i<arr1.length && j<arr2.length && arr2[j]<arr1[i]) {
                new_arr[ind++]=arr2[j];
                j++;
            }
            if (i>=arr1.length){
                new_arr[ind++]=arr2[j];
                j++;
            }else if(j>=arr2.length){
                new_arr[ind++]=arr1[i];
                i++;
            }
        }
        return new_arr;
    }

}
