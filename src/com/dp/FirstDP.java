package com.dp;

import java.util.Arrays;

public class FirstDP {
    public static void main(String[] args) {
        int n=30;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(fibo(n-1,dp));
    }
    public static int fibo(int n,int[] dp){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
    }
}
