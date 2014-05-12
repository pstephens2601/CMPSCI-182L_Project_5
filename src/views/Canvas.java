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
        
        node.setRadius(findRadius(colWidth));
        
        node.setXPosition((xPosition) - (node.getRadius()));
        node.setYPosition(level * 120);
        
        String number = String.valueOf(currentInt.getValue());
        Font numberFont = new Font("Helvetica", Font.PLAIN, 14);
        g.setFont(numberFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        int numberWidth = fontMetrics.stringWidth(number);
        int numberHeight = fontMetrics.getHeight();
        
        if (node.getRadius() > fontMetrics.stringWidth(number) - 5) {
            g.setColor(new Color(65, 159, 221));
            g.fillOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);

            g.setColor(Color.WHITE);
            g.drawOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);
        }
        
            g.drawString(
                    number,
                    node.getXPosition() + (node.getRadius() - (numberWidth/2)),
                    node.getYPosition() + (node.getRadius() + (numberHeight/2))
            );
    }
    
    public void drawTree(Graphics2D g, Node root, int level, int xPosition, int colWidth) {
        
        g.setColor(Color.WHITE);
        
        if (root.getLeft() != null) {
            drawLine(g, root, xPosition, xPosition - (colWidth/4),level, colWidth);
            drawTree(g, root.getLeft(), level + 1, (xPosition - (colWidth/4)), colWidth/2); 
        }
        
        if (root.getRight() != null) {
            drawLine(g, root, xPosition, xPosition + (colWidth/4),level, colWidth);
            drawTree(g, root.getRight(), level + 1, (xPosition + (colWidth/4)), colWidth/2);
        }
        
        drawNode(g, (Int)root, level, xPosition, colWidth);
    }
    
    private void drawLine(Graphics2D g, Node root, int xPosition, int childXPosition, int level, int colWidth) {
        g.drawLine(xPosition, (level * 120) + findRadius(colWidth), childXPosition, ((level + 1) * 120) + (findRadius(colWidth/2) - 5));
    }
    
    private int findRadius(int colWidth) {
        if (colWidth > 90) {
            return 30;
        }
        else {
            int dynamicWidth = (colWidth/2) - 2;
            if (dynamicWidth < 30) {
                return dynamicWidth;
            }
            else {
                return 30;
            }
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
