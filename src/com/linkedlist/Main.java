package com.linkedlist;

public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertFirst(4);
        list.insertFirst(7);
        list.insertLast(2);
        list.insertLast(1);
        list.insertMiddle(5,1);
        list.insertMiddle(10,3);

        list.display();
        list.deleteAtInd(4);
        list.display();
    }
}
