/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import controllers.*;

/**
 *
 * @author Owner
 */
public class Window extends JFrame {
    
    private Canvas canvas;
    private ActionBar actionBar;
    private ProgramController controller;
    
    public Window(ProgramController newController) {
        controller = newController;
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Binary Tree Viewer");
        addScreens();
        setVisible(true);
    }
    
    public void drawTree() {
      canvas.repaint();
    }
    
    private void addScreens() {
        canvas = new Canvas(controller);
        actionBar =  new ActionBar();
        add(canvas, BorderLayout.CENTER);
        add(actionBar, BorderLayout.SOUTH);
    }
    
}
