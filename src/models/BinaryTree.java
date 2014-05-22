/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package models;

public class BinaryTree {
    
    private Node root;
    
    public BinaryTree() {
        
    }  
    
    public void setRoot(Node newRoot) {
        root = newRoot;
    }
    
    public Node getRoot() {
        return root;
    }
}
