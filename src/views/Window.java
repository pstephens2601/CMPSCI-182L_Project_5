/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package views;

import javax.swing.*;
import java.awt.*;
import controllers.*;

public class Window extends JFrame {
    
    private Canvas canvas;
    private ActionBar actionBar;
    private ProgramController controller;
    
    public Window(ProgramController newController) {
        controller = newController;
        setSize(1024, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        canvas.setPreferredSize(new Dimension(0, 1000));
        actionBar =  new ActionBar(controller);
        JScrollPane scrollPane = new JScrollPane(canvas);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scrollPane, BorderLayout.CENTER);
        add(actionBar, BorderLayout.SOUTH);
    }
    
}
