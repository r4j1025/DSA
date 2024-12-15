package com.trees;

public class AVL {
    public static class Node{
        private int val;
        private Node right;
        private Node left;
        private int height;
        public Node(int val){
            this.val = val;
        }
        public int getVal(){
            return this.val;
        }
    }

    private Node root;

    public int height(Node node){
        if(node==null) return -1;
        return node.height;
    }

    public int height(){
        if(root==null) return -1;
        return root.height;
    }

    public boolean isEmpty(){
        return (root==null);
    }

    public void insert(int val){
        root = insert(val,root);
    }
    //////////////////////////////////////////////////////////////////////////////
    private Node insert(int val,Node node){
        if(node == null){
            return new Node(val);
        }
        if(val < node.val){
            node.left = insert(val,node.left);
        }
        if(val > node.val){
            node.right = insert(val,node.right);
        }

        node.height = Math.max(height(node.left),height(node.right)) +1;
        return rotate(node);
    }

    private Node rotate(Node node){
        //left is heavy
        if(height(node.left) - height(node.right) >1){

            //left left case
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }

            //left right case
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        //right is heavy
        if(height(node.left) - height(node.right) < -1){

            //right right case
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }

            //right left case
            if(height(node.right.left) - height(node.right.right) > 0){
                node.left = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node node){
        Node p = node.right;
        Node temp = p.left;
        p.left = node;
        node.right = temp;
        node.height = Math.max(height(node.right) + 1,height(node.left));
        p.height = Math.max(height(p.right) + 1,height(p.left));
        return p;
    }

    private Node rightRotate(Node node){
        Node p = node.left;
        Node temp = p.right;
        p.right = node;
        node.left = temp;
        node.height = Math.max(height(node.right) + 1,height(node.left));
        p.height = Math.max(height(p.right) + 1,height(p.left));

        return p;
    }
    //////////////////////////////////////////////////////////////////////////////

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node node){
        if(node == null) return;
        System.out.println(node.val);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node node){
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.val);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node node){
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node == null) return true;
        return (Math.abs(height(node.left) - height(node.right)) <= 1   &&   isBalanced(node.left)   &&   isBalanced(node.right));
    }

    public void display(){
        display(root,0);
    }
    private void display(Node node,int lvl){
        if(node == null) return;

        display(node.right,lvl+1);
        if(lvl!=0){
            for(int i=0 ;i<lvl-1 ;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.val);
        }else {
            System.out.println(node.val);
        }
        display(node.left,lvl+1);
    }

}
