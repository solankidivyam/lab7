//Divyam Solanki
//29 Sept 2020

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;
import java.util.Scanner;

class BST_class {

    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    // root node
    Node root;

    // Constructor for BST
    BST_class(){
        root = null;
    }
    //deleting a node
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }


    Node delete_Recursive(Node root, int key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor
            root.key = minValue(root.right);

            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root)  {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    // insert a node in BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    // inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);
    }

    // recursive traversal
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    public static void main(String[] args)  {
        // BST object
        BST_class bst = new BST_class();

        //print the BST

//        Arrays.sort(val);
//
//        for (int i = 0; i < val.length; i++) {
//            val[i] = val[i] * (-1);
//        }
//
//        Arrays.sort(val);
//
//        for (int i = 0; i < val.length; i++) {
//            val[i] = val[i] * (-1);
//        }
//


//        for(int j=0; j<val.length; j++)
//        {
//            bst.insert(val[j]);
//        }


//        System.out.println("The BST Created with input data(Left-root-right):");
//        bst.inorder();

        //delete leaf node

        int[] val = new int[10000];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(100000);
        }
        long startTime = System.nanoTime();
        for(int i=0; i < 500; i++){
            int k = new Random().nextInt(10000);
            bst.deleteKey(k);
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);


        bst.deleteKey(12);
//        bst.inorder();
//        //delete the node with one child
//        System.out.println("\nThe BST after Delete 90 (node with 1 child):");
//        bst.deleteKey(90);
//        bst.inorder();
//
//        //delete node with two children
//        System.out.println("\nThe BST after Delete 45 (Node with two children):");
//        bst.deleteKey(45);
//        bst.inorder();

    }
}
