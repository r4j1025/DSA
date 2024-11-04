package com.test;

public class PrintSubsets {
    public static void main(String[] args) {
        subset("","abc");
//        String str="a";
//        System.out.println(str.substring(1));
    }
    public static void subset(String str1,String str2){
        if(str2.isEmpty()){
            System.out.print(str1+" ");
            return;
        }
        subset(str1+str2.charAt(0),str2.substring(1));
        subset(str1,str2.substring(1));
    }
}
