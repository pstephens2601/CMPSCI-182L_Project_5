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
import models.*;

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
        Color color1 = new Color(0,0,0);
        Color color2 = new Color(42,128,201);
        int width = this.getWidth();
        int height = 1000;
        
        GradientPaint gp = new GradientPaint(width, 0, color1, width, 1000, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        
        drawTree(g2d, tree.getRoot(), 1, this.getWidth()/2, this.getWidth());
    }
    
    private void drawNode(Graphics2D g, Int currentInt, int level, int xPosition, int colWidth) {
        
        Circle node = new Circle();
        
        node.setRadius(findRadius(colWidth));
        node.setXPosition((xPosition) - (node.getRadius()));
        node.setYPosition(level * 120);
        
        String number = String.valueOf(currentInt.getValue());
        Font numberFont = new Font("Helvetica", Font.BOLD, 14);
        g.setFont(numberFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        int numberWidth = fontMetrics.stringWidth(number);
        int numberHeight = fontMetrics.getHeight();
        
        if (node.getRadius() > fontMetrics.stringWidth(number) - 2) {
            g.setColor(new Color(42,128,201));
            g.fillOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);

            g.setColor(Color.WHITE);
            g.drawOval(node.getXPosition(), node.getYPosition(), node.getRadius() * 2, node.getRadius() * 2);
        }
        
            g.drawString(
                    number,
                    node.getXPosition() + (node.getRadius() - (numberWidth/2)),
                    node.getYPosition() + (node.getRadius() + (numberHeight/3))
            );
    }
    
    public void drawTree(Graphics2D g, Node root, int level, int xPosition, int colWidth) {
        
        if (root != null) {
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
}