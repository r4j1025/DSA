package com.test;

import java.util.Arrays;

public class AllPathsUsingBacktracking {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        findPath("",maze,path,0,0,1);
    }
    static void findPath(String up,boolean[][] maze,int[][] path,int r,int c,int step){
        if(r==maze.length-1&&c==maze[0].length-1){
            path[r][c]=step;
            for (int i=0;i<path.length;i++){
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(up);
            System.out.println();
            return;
        }
        if (maze[r][c]==false) return;

        maze[r][c]=false;

        if (r<maze.length-1){
            path[r][c]=step;
            findPath(up+"D",maze,path,r+1,c,step+1);
        }
        if (c<maze[0].length-1){
            path[r][c]=step;
            findPath(up+"R",maze,path,r,c+1,step+1);
        }
        if (r>0){
            path[r][c]=step;
            findPath(up+"U",maze,path,r-1,c,step+1);
        }
        if (c>0){
            path[r][c]=step;
            findPath(up+"L",maze,path,r,c-1,step+1);
        }
        maze[r][c]=true;//backtracking
        path[r][c]=0;
    }
}
