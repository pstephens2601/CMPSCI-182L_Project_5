/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Owner
 */
public class ActionBar extends JPanel implements ActionListener {
    
    private JButton insertButton;
    private JButton deleteButton;
    private JButton findButton;
    private JTextField inputField;
    
    public ActionBar() {
        addControls();
    }
    
    //Adds buttons and text input
    private void addControls() {
        insertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");
        findButton = new JButton("Find");
        inputField = new JTextField(5);
        
        add(inputField);
        add(insertButton);
        add(deleteButton);
        add(findButton);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
