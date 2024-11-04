package com.test;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsetsWithItteration {
    public static void main(String[] args) {
        System.out.println(subset(new int[] {1,2,3}).toString());
    }
    static List<List<Integer>> subset(int arr[]){
        List<List<Integer>> outer=new ArrayList<List<Integer>>();
        outer.add(new ArrayList<>());//[]added

        for (int num: arr){
            int n = outer.size();
            for(int i=0;i<n;i++){
            List<Integer> inner=new ArrayList<>(outer.get(i));//copy of ith list in outer
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }
}
