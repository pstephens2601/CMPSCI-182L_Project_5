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
public class Int extends Node {
    
    private int value;
    
    public Int(int newValue) {
        value = newValue;
    }
    
    public void setValue(int newValue) {
        value = newValue;
    }
    
    public int getValue() {
        return value;
    }
}