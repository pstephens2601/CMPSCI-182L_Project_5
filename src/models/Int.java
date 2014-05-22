/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package models;

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