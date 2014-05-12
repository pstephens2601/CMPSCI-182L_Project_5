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
        tree.insert(200);
        tree.insert(90);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(15);
        tree.insert(1);
        tree.insert(80);
        tree.insert(100);
        tree.insert(70);
        tree.insert(30);
        tree.insert(75);
        tree.insert(60);
        tree.insert(35);
        tree.insert(27);
        tree.insert(25);
        tree.insert(29);
        tree.insert(31);
        tree.insert(24);
        tree.insert(26);
        
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
