/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package models;

import java.util.Stack;

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
            else if (compareInt(parent, newNode) > 0) {
                parent.setRight(newNode);
            }
            else {
                System.out.println("User attempted to enter a duplicate value into the tree.");
            }
        }
    }
    
    @Override
    public String toString() {
        String tree = "";
        
        Stack treeStack = new Stack();
        treeStack.push(getRoot());
        int spaces = 32;
        boolean isRowEmpty = false;
        
        tree += "................................................................\n";
        
        while(isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for(int j = 0; j < spaces; j++) {
                tree += " ";
            }
            
            while(treeStack.isEmpty() == false) {
                Int temp = (Int)treeStack.pop();
                
                if(temp != null) {
                    tree += temp.getValue();
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    
                    if (temp.getLeft() != null || temp.getRight() !=  null) {
                        isRowEmpty = false;
                    }
                }
                else {
                    tree += "--";
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < spaces * 2 - 2; j++) {
                    tree += " ";
                }
            }
            tree += "\n";
            spaces /= 2;
            
            while(localStack.isEmpty() == false) {
                treeStack.push(localStack.pop());
            }
      
        }

        tree += "................................................................\n";
        return tree;
    }
    
    private Node findParent(Int child) {
       
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
