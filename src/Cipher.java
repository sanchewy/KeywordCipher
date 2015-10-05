/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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
       //Empty constructor
    }
    
    public void decript(String keyword, String input){
        //Create cript alphabet
        char[] criptAlphabet = criptAlphabet(keyword);
        char[] regularAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //Break input string into array
        char[] in = input.toCharArray();
        lowerCase(in);
        //replace letters with like position letters in regular alphabet
        for(int i = 0; i<in.length; i++){
            //get the position of each character from "in" in cipher alphabet, then replace with same position leter in regular alphabet
            //Check if char == " "
            if(!isSpace(in, i)){
                // if not space, swap with other alphabet
                int pos = getPosition(in[i], criptAlphabet);
                if(pos!=-1){
                    in[i]=regularAlphabet[pos];
                }
            }
            else{
                //do nothing (leave as a space "  "
            }
         }
        //Recreate string from array
        String out = new String(in);
        //return string new message
        outputMessage.setText(out);
        window.repaint();
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
                    alphabet = removeElement(alphabet, i);
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
            if(array[i]==' '){
                array=removeElement(array, i);
            }
            array[i]=java.lang.Character.toLowerCase(array[i]);
        }
        //remove repeated characters
        for(int i=0; i<array.length; i++){
            while(find(array, array[i], i+1)!=-1){
                array = removeElement(array, find(array, array[i], i+1));
            }
        }
        //Convert array back to string
        return new String(array);
    }
    
    public int find(char[] inputArray, char findMe, int beginRange){
        for(int i = beginRange; i<inputArray.length; i++){
            if (inputArray[i]==findMe){
                return i;
            }
        }
        return -1;
    }
    
    public char[] lowerCase(char[] array){
        for(int i=0; i<array.length; i++){
            array[i]=java.lang.Character.toLowerCase(array[i]);
        }
        return array;
    }
    
    public char[] removeElement (char[] array, int breakPoint){
        //create two new arrays excluding the value to be removed
        char[] newArray1 = Arrays.copyOfRange(array, 0, breakPoint);
        char[] newArray2 = Arrays.copyOfRange(array, breakPoint+1, array.length);
        //return combination of those two arrays
        return(combine(newArray1, newArray2));
    } 
    
    public void encript(String keyword, String input){
        //Create cript alphabet
        char[] criptAlphabet = criptAlphabet(keyword);
        char[] regularAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //Break input string into array
        char[] in = input.toCharArray();
        lowerCase(in);
        //replace letters with like position letters in cript alphabet
        for(int i = 0; i<in.length; i++){
            //get the position of each character from "in" in regular alphabet, then replace with same position leter in cipher alphabet
            //Check if char == " "
            if(!isSpace(in, i)){
                // if not space, swap with other alphabet
                int pos = getPosition(in[i],regularAlphabet);
                if(pos!=-1){
                    in[i]=criptAlphabet[pos];
                }
            }
            else{
                //do nothing (leave as a space "  "
            }
         }
        //Recreate string from array
        String out = new String(in);
        //return string new message
        outputMessage.removeAll();
        outputMessage.setText(out);
        window.repaint();
    }
    
    public static final boolean isSpace( char[] charArray, int index ){
        
      if ( ( charArray == null ) || ( charArray.length == 0 ) || ( index < 0 ) || ( index >= charArray.length ) )
      {
          return false;
      }
      else
      {
          return ( Character.isWhitespace( charArray[ index ] ) ? true : false );
      }
  }
    
    public int getPosition(char letter, char[] alphabet){
        for(int i =0; i<alphabet.length; i++){
            if(alphabet[i]==letter){
                return i;
            }
        }
        return -1;
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
        outputMessage.setEditable(false);
        
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
            //Take keyword and text from inputMessage, encript, and output encripted text through outputMessage
            //Check for poor keyword input
            if(!keywordField.getText().equals("Keyword") && keywordField.getText().length()>4 && !keywordField.getText().equals("Please enter a longer keyword")){
                keyword = keywordField.getText();
                input = inputMessage.getText();
                encript(keyword, input);
            }
            else{
                keywordField.setText("Please enter a longer keyword");
            }
        }
        else if(e.getSource()==decript){
            //Take keyword and encripted text from inputMessage, decript, and output encripted text through outputMessage
            //Check for poor keyword input
             if(!keywordField.getText().equals("Keyword") && keywordField.getText().length()>4 && !keywordField.getText().equals("Please enter a longer keyword")){
                 keyword = keywordField.getText();
                 input = inputMessage.getText();
                 decript(keyword, input);
            }
            else{
                keywordField.setText("Please enter a longer keyword");
            }
        }
        else{
            throw new UnsupportedOperationException("This button is not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
