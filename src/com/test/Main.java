package com.test;
import java.util.*;
public class Main {
    static int[][] arr ={{'w','t','t','t','t','t'},
            {'t','w','w','w','w','w'},
            {'w','t','t','t','t','t'},
            {'w','w','w','w','w','t'},
            {'t','t','t','t','t','t'},
            {'t','w','w','w','w','w'}};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=6;
        int N=6;
        int x=1;
        int y=6;

        int[][] time =new int[M][N];
        count_time_of_each_tree(x-1,y-1,1,M,N,time); //func starts from the given position
        //printing max value in time array
        int max=-1;
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(time[i][j]>max){
                    max=time[i][j];
                }
            }
        }
        System.out.println(max);
    }
    public static void count_time_of_each_tree(int row,int col,int current_time,int M,int N,int[][] time ){
        if(row<0 || row>M-1||col<0||col>N-1){
            return;
        }
        if(arr[row][col]=='w'){
            return;
        }
        if(time[row][col]!=0 && current_time>=time[row][col]){
            return;
        }
        time[row][col]=current_time;
        current_time++;
        count_time_of_each_tree(row+1,col,current_time,M,N,time);
        count_time_of_each_tree(row-1,col,current_time,M,N,time);
        count_time_of_each_tree(row,col+1,current_time,M,N,time);
        count_time_of_each_tree(row,col-1,current_time,M,N,time);
        count_time_of_each_tree(row-1,col+1,current_time,M,N,time);
        count_time_of_each_tree(row-1,col-1,current_time,M,N,time);
        count_time_of_each_tree(row+1,col+1,current_time,M,N,time);
        count_time_of_each_tree(row+1,col-1,current_time,M,N,time);
    }
}
