package com.linkedlist;

public class LL {

    private class Node {
       private int value;
       private Node next;
       
       Node(int value){
        this.value=value;
       }
       Node(int value,Node next){
        this.value=value;
        this.next=next;
       }
        
    }

    private Node head;
    private Node tail;
    private int size;
    LL(){
        this.size=0;
    }

    ////////////////////////////////////////
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        //for adding first ele to list
        if(tail==null){
            tail=head;
            //tail will be the first added ele
        }
        size++;
    }
    ////////////////////////////////////////
    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    ////////////////////////////////////////
    public void insertMiddle(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        int ind=1;
        Node temp=head;
        while(ind<index){
            temp=temp.next;
            ind++;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        size++;

    }
    ////////////////////////////////////////
    public void deleteFirst(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        System.out.println(val);
    }
    ////////////////////////////////////////
    public void deleteLast(){
        int val=tail.value;
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        tail=temp;
        tail.next=null;
        size--;
        System.out.println(val);
    }
    ////////////////////////////////////////
    public void deleteAtInd(int index){
        if(index==0){
            deleteFirst();
        }
        Node prenode=getNodeAtInd(index-1);
        System.out.println(prenode.next.value);
        prenode.next=prenode.next.next;
        size--;
    }
    ////////////////////////////////////////
    public Node getNodeAtInd(int index){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    ////////////////////////////////////////
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }




    
    
}