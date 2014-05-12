/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

/**
 *
 * @author Owner
 */
public class IntTree extends BinaryTree {
    
    public IntTree() {
        
    }
    
    public IntTree(int root) {
        insert(root);
    }
    
    public void insert(int value) {
        Int newNode = new Int(value);
        newNode.setValue(value);
        
        if (getRoot() == null) {
            setRoot(newNode);
        }
        else {
            Int parent = (Int)findParent(newNode);
            
            if (compareInt(parent, newNode) < 0) {
                parent.setLeft(newNode);
            }
            else {
                parent.setRight(newNode);
            }
            
        }
    }
    
    public Node findParent(Int child) {
       
        Int currentInt = (Int)getRoot();
        Int parent;
        
        while(true) {
            if (currentInt.getLeft() != null || currentInt.getRight() != null) {
                if (compareInt(currentInt, child) < 0) {
                    if(currentInt.getLeft() != null) {
                        currentInt = (Int)currentInt.getLeft();
                    }
                    else {
                        return currentInt;
                    }
                }
                else {
                    if(currentInt.getRight() != null) {
                        currentInt = (Int)currentInt.getRight();
                    }
                    else {
                        return currentInt;
                    }
                }
            }
            else {
                return currentInt;
            }
        }
    }
    
    private int compareInt(Int parentInt, Int newInt) {
        
        if (parentInt.getValue() > newInt.getValue()) {
            return -1;
        }
        else if (parentInt.getValue() == newInt.getValue()) {
            return 0;
        }
        else {
            return 1;
        }  
    }   
}
