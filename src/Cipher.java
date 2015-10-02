/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
    
    //Strings
    String keyword;
    String input;
    
    public Cipher(){
       
    }
    
    public char[] criptAlphabet (String keyword){
        //Takes in keyword and scrambles and returns the alphabet based on that word
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        keyword = format(keyword);
        char[] criptAlphabet = keyword.toCharArray();
        //Keep removing char in keyword from alphabet
        for(int j = 0; j<criptAlphabet.length; j++){
            for(int i =0; i<alphabet.length; i++){
                if(alphabet[i]==criptAlphabet[j]){
                    alphabet = removeElement(alphabet, alphabet[i]);
                }
            }
        }
        return(combine(criptAlphabet, alphabet));
    }
    
    public String format(String word){
        //convert string to char[] array
        char[] array = word.toCharArray();
        //remove capitol letters
        for(int i=0; i<array.length; i++){
            array[i]=java.lang.Character.toLowerCase(array[i]);
        }
        //remove repeated characters
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length;j++){
                if(array[i]==array[j]){
//                    System.out.println("removed "+array[j]);
                    array = removeElement(array, array[j]);
                }
            }
        }
        //Convert array back to string
        System.out.println(new String(array));
        return new String(array);
    }
    
    public char[] removeElement (char[] array, char removeMe){
        int breakPoint=0;
        //find value to be removed
        for(int i = 0; i<array.length; i++){
            if(array[i]==removeMe){
                breakPoint = i;
            }
        }
        //create two new arrays excluding the value to be removed
        char[] newArray1 = Arrays.copyOfRange(array, 0, breakPoint);
        char[] newArray2 = Arrays.copyOfRange(array, breakPoint+1, array.length);
        //return combination of those two arrays
        return(combine(newArray1, newArray2));
    }
    
    public String encrypt(String keyword, String input){
        //Create cript alphabet
        char[] alphabet = criptAlphabet(keyword);
        //replace letters with like position letters in cript alphabet
        System.out.println(alphabet);
        //return string new message
        String you=null;
        return(you);
    }
    
    public static char[] combine(char[] a, char[] b){
        //Combines two char arrays and returns the resulting char array
        int length = a.length + b.length;
        char[] result = new char[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
    
    public void InitializeComponenets(){
        //Set up the JFrame 
        encript.addActionListener(this);
        decript.addActionListener(this);
        
        keywordField.setText("Keyword");
        
        inputMessage.setText("Input Message");
        inputMessage.setLineWrap(true);
        
        outputMessage.setText("Output Message");
        
        buttonPanel.add(encript);
        buttonPanel.add(decript);
        
        ioPanel.add(keywordField);
        ioPanel.setBorder(new TitledBorder("Pick a strong keyword!"));
        
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
        //Deals with button presses
        if(e.getSource()==encript){
            //Take keyword and text from inputMessage, encript, and output encripted text through outputMessage                           fix not denying keyword "Keyword"
            if(!keywordField.getText().equals("keyword") && keywordField.getText().length()>4){
                keyword = keywordField.getText();
                input = keywordField.getText();
                encrypt(keyword, input);
            }
            else{
                keywordField.setText("Please enter a longer keyword");
            }
        }
        else if(e.getSource()==decript){
            //Take keyword and encripted text from inputMessage, decript, and output encripted text through outputMessage
            outputMessage.setText("Working on it!");
        }
        else{
            throw new UnsupportedOperationException("This button is not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
