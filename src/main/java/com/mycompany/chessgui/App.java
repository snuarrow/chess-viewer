/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chessgui;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author hexvaara
 */
public class App 
{
    
    
    
    public static void main(String args[])
    {
        JFrame f = new JFrame();
        BoardController c = new BoardController();
        c.setBackground(Color.white);
        f.add(c);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
    }
}
