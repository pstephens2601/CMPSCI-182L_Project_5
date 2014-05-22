/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package models;

import java.awt.*;

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
