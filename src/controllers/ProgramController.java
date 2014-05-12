/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import views.*;
import models.*;
/**
 *
 * @author Owner
 */
public class ProgramController {
    
    private Window programWindow;
    private IntTree tree;
    
    public ProgramController() { 
        tree = new IntTree(50);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(15);
        tree.insert(1);
        tree.insert(80);
        
        
        programWindow = new Window(this);
        drawTree();
    }
    
    public IntTree getTree() {
        return tree;
    }
    
    public final void drawTree() {
        programWindow.drawTree();
    }
}
