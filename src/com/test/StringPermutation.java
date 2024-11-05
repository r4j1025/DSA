package com.test;

public class StringPermutation {
    public static void main(String[] args) {
        permute("","abc");
    }
    static void permute(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch= up.charAt(0);
        for (int i=0;i<=p.length();i++){
            String firstPart = p.substring(0,i);
            String lastPart = p.substring(i,p.length());
            permute(firstPart+ch+lastPart,up.substring(1));
        }
    }
}
