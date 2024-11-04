package com.test;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(40,3));
    }
    static double sqrt(int n,int p){
        double root=0.0;
        int start=0;
        int end=n;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==n) return mid;

            if(mid*mid>n) end=mid-1;
            else start=mid+1;
        }
        root=end;
        double inc=0.1;
        for(int i=0;i<p;i++){//run for 3 decimail points
            while(root*root<n){
                root+=inc;
            }
            root-=inc;
            inc/=10;//0.01-next decimal point
        }

        return root;
    }
}
