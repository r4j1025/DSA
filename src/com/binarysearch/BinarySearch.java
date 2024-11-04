package com.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,4,6,8,9,88};
        int[] arr1={3,5,6,7,8,51,66,77,88,92,132};
        int target =88;
        System.out.println(binsrch(arr,target));
        System.out.println(binsrch(arr1,target));
    }
    private static int binsrch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        while(start<=end){

            int mid=(start+end)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                end=mid-1;
            }else if(arr[mid]<target){
                start=mid+1;
            }
        }
        return -1;
    }
}
