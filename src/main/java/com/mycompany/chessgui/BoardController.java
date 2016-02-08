/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chessgui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author hexvaara
 */
public class BoardController extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    public int topkek = 0;
    
    public BoardController()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    /**
     * tätä kutsutaan kun repaint();
     * 
     * @param g 
     */
    public void paintComponent(Graphics g)
    {
        // saattaa olla väärässä järjestyksessä, super.paintComp pitäis olla tod näk viimeisenä.
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g.drawRect(10+topkek, 10+topkek, 10+topkek, 10+topkek);
        
        //g.drawImage <- tolla kuvia tjsp.
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("mouse clicked");
        topkek += 10;
        repaint();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
