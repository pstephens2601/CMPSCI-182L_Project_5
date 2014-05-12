/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.awt.*;
/**
 *
 * @author Owner
 */
public class Circle {
    
    private Color color;
    private int xPosition;
    private int yPosition;
    private int radius;
    
    
    public Circle() {
        
    }
    
    public void setRadius(int newRadius) {
        if (newRadius > 0) {
            radius = newRadius;
        }
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setXPosition(int newXPosition) {
        if (newXPosition > 0) {
            xPosition = newXPosition;
        }
    }
    
    public int getXPosition() {
        return xPosition;
    }
    
    public void setYPosition(int newYPosition) {
        if (newYPosition > 0) {
            yPosition = newYPosition;
        }
    }
    
    public int getYPosition() {
        return yPosition;
    }
    
    public void setColor(Color newColor) {
        color = newColor;
    }
    
    //sets color based on given RGB values
    public void setColor(int r, int g, int b) {
        color = new Color(r, g, b);
    }
}
