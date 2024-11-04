package com.circularlinkedlist;

public class CLL {
    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    private Node head;
    private Node tail;

    public void insert(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            tail=node;
            tail.next=head;
            return;
        }
        node.next=head;
        head=node;
        tail.next=head;
    }
    public void display(){
        if(head==null){
            return;
        }
        Node temp=head;
        while (temp.next!=head){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println(temp.val);
    }
}
