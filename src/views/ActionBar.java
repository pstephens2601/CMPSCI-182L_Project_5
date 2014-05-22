/*------------------------------------------------------------------------------
Programmer: Patrick Stephens
Development Date: 5/13/2014
Project: CMPSCI 182L - Project #5 - Professor Ferguson
Project Description: GUI program that graphically displays a inary tree.
------------------------------------------------------------------------------*/

package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controllers.*;

public class ActionBar extends JPanel implements ActionListener {
    
    private JButton insertButton;
    private JButton clearButton;
    private JButton exitButton;
    private JTextField inputField;
    private ProgramController controller;
    
    public ActionBar(ProgramController newController) {
        controller = newController;
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        addControls();
    }
    
    //Adds buttons and text input
    private void addControls() {
        insertButton = new JButton("Insert");
        insertButton.addActionListener(this);
       
        clearButton = new JButton("Clear Tree");
        clearButton.addActionListener(this);
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        inputField = new JTextField(5);
        
        JLabel prompt = new JLabel("Enter an Integer to insert it into the tree: ");
        prompt.setForeground(Color.WHITE);
        
        add(prompt);
        add(inputField);
        add(insertButton);
        add(clearButton);
        add(exitButton);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertButton) {
            controller.addNode(Integer.parseInt(inputField.getText()));
            inputField.setText(null);
        }
        else if (e.getSource() == clearButton) {
            controller.clearTree();
        }
        else if (e.getSource() == exitButton) {
            controller.exitProgram();
        }
    }
}
