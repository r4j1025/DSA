package com.doublylinkedlist;


public class DLL {


    private class Node {
        private int value;
        private Node prev;
        private Node next;
        Node(int value){
            this.value=value;
        }
        Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }

    }

    private Node head;
    private Node last;
    private int size;
    DLL(){
        this.size=0;
    }

    ////////////////////////////////////////
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        size++;
    }
    ////////////////////////////////////////
    public void display() {
        Node node = head;
        System.out.print("null<-> ");
        while(node.next!=null){
            System.out.print(node.value+" <-> ");
            node=node.next;
        }
        last=node;
        System.out.println(node.value+" <->null");
    }
    ////////////////////////////////////////
    public void displayRev() {
        //we need last so finding last node wile running display()
        Node node = last;
        System.out.print("null");
        while(node.prev!=null){
            System.out.print(" <-> "+node.value);
            node=node.prev;
        }
        System.out.println(" <-> "+node.value+" <->null");
    }
}
