package com.trees;

public class SegmentTree {

    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int startInterval,int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr,int start,int end){
        if(start==end){
            Node leaf = new Node(start,end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start,end);

        int mid = (start+end)/2;

        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);

        node.data = node.left.data + node.right.data;

        return node;
    }

    public int query(int qsi,int qei){
        return query(root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startInterval >=qsi && node.endInterval <=qei){
            //node lying inside query
            return node.data;
        } else if (node.endInterval<qsi || node.startInterval>qei) {
            //node completely lying outside
            return 0;
        }else {
            return query(node.left,qsi,qei) + query(node.right,qsi,qei);
        }
    }

}
