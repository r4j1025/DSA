package com.trees;

public class Main {
    public static void main(String[] args) {
//        BST tree = new BST();
//        tree.insert(15);
//        tree.insert(16);
//        tree.insert(17);
//        tree.insert(18);
//        tree.insert(19);
//        tree.insert(20);
//        tree.insert(21);
//        tree.preOrderTraversal();
//        tree.postOrderTraversal();
//        tree.inOrderTraversal();//print in sorted order

//        for(int i=1;i<20;i++) tree.insert(i);
//        tree.display();
//        System.out.println(tree.height());

        SegmentTree tree = new SegmentTree(new int[]{3,8,7,6,-2,-8,4,9});

        System.out.println(tree.query(3,6));
    }
}
