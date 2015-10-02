/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

/**
 *
 * @author Keinan
 */

public class Cipher extends JFrame implements ActionListener {
    
    //Components
    JFrame window = new JFrame("Keyword Cipher");
    JTextField keywordField = new JTextField(20);
    JTextArea inputMessage = new JTextArea();
    JTextArea outputMessage = new JTextArea();
    JScrollPane inPane = new JScrollPane(inputMessage);
    JScrollPane outPane = new JScrollPane(outputMessage);
    JButton encript = new JButton("Encript");
    JButton decript = new JButton("Decript");
    JPanel buttonPanel = new JPanel();
    JPanel ioPanel = new JPanel();
    
    
        
    public Cipher(){
       
    }
    
    public void InitializeComponenets(){
        
        encript.addActionListener(this);
        decript.addActionListener(this);
        
        keywordField.setText("Keyword");
        
        inputMessage.setText("Input Message");
        inputMessage.setLineWrap(true);
        
        outputMessage.setText("Output Message");
        
        buttonPanel.add(encript);
        buttonPanel.add(decript);
        
        ioPanel.add(keywordField);
        ioPanel.setBorder(new TitledBorder("Pick a strong key"));
        
        window.setLayout(new GridLayout(4,1,0,10));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,350);
        window.setLocationRelativeTo(null);
        window.add(ioPanel);
        window.add(inPane);
        window.add(outPane);
        window.add(buttonPanel);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
