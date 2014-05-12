/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import controllers.*;
import models.*;
/**
 *
 * @author Owner
 */
public class Canvas extends JPanel {
    
    private IntTree tree;
    
    public Canvas(ProgramController controller) {
        tree = controller.getTree();
        setBackground(new Color(20, 20, 20));
        setVisible(true);
    }
   
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        
        drawTree(g2d, tree.getRoot(), 1, this.getWidth()/2, this.getWidth());
    }
    
    private void drawNode(Graphics2D g, Int currentInt, int level, int xPosition, int colWidth) {
        
        Circle node = new Circle();
        
        if (colWidth > 60) {
            node.setRadius(30);
        }
        else {
            node.setRadius((colWidth/2) - 10);
        }
        
        node.setXPosition((xPosition) - (node.getRadius()));
        node.setYPosition(level * 120);
        
        String number = String.valueOf(currentInt.getValue());
        Font numberFont = new Font("Helvetica", Font.PLAIN, 14);
        g.setFont(numberFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        int numberWidth = fontMetrics.stringWidth(number);
        int numberHeight = fontMetrics.getHeight();
        
        g.setColor(Color.GRAY);
        g.fillOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);
        System.out.println("current number is " + number + " and the level is " + level);
        System.out.println("xPosition is " + xPosition + "\n");
        g.setColor(Color.WHITE);
        g.drawOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);
        g.drawString(
                number,
                node.getXPosition() + (node.getRadius() - (numberWidth/2)),
                node.getYPosition() + (node.getRadius() + (numberHeight/2))
        );
    }
    
    public void drawTree(Graphics2D g, Node root, int level, int xPosition, int colWidth) {
        
        drawNode(g, (Int)root, level, xPosition, colWidth);
        
        if (root.getLeft() != null) {
            drawTree(g, root.getLeft(), level + 1, (xPosition - (colWidth/4)), colWidth/2);
        }
        
        if (root.getRight() != null) {
            drawTree(g, root.getRight(), level + 1, (xPosition + (colWidth/4)), colWidth/2);
        }
    }
    
    private int powerOf2(int power) {
        int value = 2;
        
        for(int i = 1; i < power; i++) {
            value = value * 2;
        }
        return value;
    }
}
