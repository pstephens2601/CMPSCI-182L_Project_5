/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package models;

public class Node {
    
    private Node left;
    private Node right;
    
    public Node() {
        
    }
    
    public void setLeft(Node newLeft) {
        left = newLeft;
    }
    
    public void setRight(Node newRight) {
        right = newRight;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public Node getRight() {
        return right;
    }
}
