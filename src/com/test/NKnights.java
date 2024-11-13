package com.test;

import java.util.Arrays;

public class NKnights {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[4][4];
        System.out.println(knight(board,0,0,4));
    }
     static int knight(boolean[][] board,int r,int c,int knights){
         if (knights == 0) {
             for (boolean[] arr:board){
                 for (boolean b:arr){
                     if(b){
                         System.out.print("K ");
                     }else {
                         System.out.print("x ");
                     }
                 }
                 System.out.println();
             }
             System.out.println();
             return 1;
         }
        int count=0;

         if (r == board.length - 1 && c == board.length) {
             return 0;
         }

         if (c == board.length) {
             knight(board, r + 1, 0, knights);
             return 0;
         }

         if (canPlace(board, r, c)) {
             board[r][c] = true;
             count+=knight(board, r, c + 1, knights - 1);
             board[r][c] = false;
         }

         count+=knight(board, r, c + 1, knights);
         
        return count;
     }
     static boolean canPlace(boolean[][] board,int r,int c){
        //check for first point
         if(r-2>=0&&c-1>=0&& board[r - 2][c - 1]){
             return false;
         }
         if(r-2>=0&&c+1<board[0].length&& board[r-2][c+1]){
             return false;
         }
         if(r-1>=0&&c-2>=0&&board[r-1][c-2]){
             return false;
         }
         if(r-1>=0&&c+2<board[0].length&&board[r-1][c+2]){
             return false;
         }
        return true;
     }
}
