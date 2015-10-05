/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keinan
 */
public class MainClass {
    public MainClass(){
        
    }
    public static void main(String[] args){
        Cipher cipher = new Cipher();
        cipher.InitializeComponenets();
        System.out.println(cipher.format("september keinan"));
    }
}
