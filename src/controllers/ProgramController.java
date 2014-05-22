/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package controllers;

import views.*;
import models.*;

public class ProgramController {
    
    private Window programWindow;
    private IntTree tree;
    
    public ProgramController() { 
        tree = new IntTree();
        tree.insert(50); 
        tree.insert(25); 
        tree.insert(75); 
        tree.insert(12); 
        tree.insert(37); 
        tree.insert(43); 
        tree.insert(30); 
        tree.insert(33); 
        tree.insert(87); 
        tree.insert(93); 
        tree.insert(9); 
        
        programWindow = new Window(this);
        drawTree();
        System.out.println(tree.toString());
        
    }
    
    public IntTree getTree() {
        return tree;
    }
    
    public final void drawTree() {
        programWindow.drawTree();
    }
    
    public void addNode(int value) {
        tree.insert(value);
        programWindow.repaint();
    }
    
    public void clearTree() {
        tree.setRoot(null);
        programWindow.repaint();
    }
    
    public void exitProgram() {
        System.exit(1);
    }
}
