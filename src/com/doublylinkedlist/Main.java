package com.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DLL list=new DLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        list.displayRev();
        //1.37
    }
}
