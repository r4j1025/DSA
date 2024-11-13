package com.test;

import java.util.Arrays;


public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueen(board,0));
    }
    static int nqueen(boolean[][] board,int r){
        if(r== board.length){
            for(boolean[] arr:board){
                for (boolean b: arr){
                    if(b){
                        System.out.print("Q ");
                    }else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return 1;
        }
        
        int count=0;
        for (int i=0;i<board[0].length;i++){
            if(canPlace(board,r,i)){
                board[r][i]=true;
                count+=nqueen(board,r+1);
                board[r][i]=false;
            }
        }
        return count;

    }

    static boolean canPlace(boolean[][] board,int r,int c){

        //check left diagonal
        int maxleft =Math.min(r,c);
        for (int i=1;i<=maxleft;i++){
            if(board[r - i][c - i]){
                return false;
            }
        }
        //check right diagonal
        int maxright =Math.min(r,board.length-c-1);
        for (int i=1;i<=maxright;i++){
            if(board[r - i][c + i]){
                return false;
            }
        }
        //check col
        for (int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        return true;
    }
}
