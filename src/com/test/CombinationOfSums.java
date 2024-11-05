package com.test;

public class CombinationOfSums {
    public static void main(String[] args) {
     recur("",4);
    }
    static void recur(String p,int up){
        if(up==0){
            System.out.println(p);
            return;
        }

        for (int i=1;i<=up;i++){
            recur(p+i,up-i);
        }

    }
}


