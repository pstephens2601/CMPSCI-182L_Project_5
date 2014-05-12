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
