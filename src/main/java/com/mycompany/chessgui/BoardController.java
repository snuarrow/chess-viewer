/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chessgui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BoardController extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
   public boolean processClick;
   public int prevX;
   public int prevY;
   public int clickX;
   public int clickY;
   
   public Piece[][] pieces;
    
    public BoardController()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        
        // tän vastuu ei pitäis olla täällä
        
        // gen pawns
        pieces = new Piece[6][6];
        for (int x=0; x<6; x++) {
            pieces[x][1] = new Piece('b', 'p');
            pieces[x][4] = new Piece('b', 'p');
        }
        // gen rooks
        pieces[0][0] = new Piece('b', 'r');
        pieces[5][0] = new Piece('b', 'r');
        pieces[5][5] = new Piece('w', 'r');
        pieces[0][5] = new Piece('w', 'r');
        // gen knights
        pieces[1][0] = new Piece('b', 'n');
        pieces[4][0] = new Piece('b', 'n');
        pieces[4][5] = new Piece('w', 'n');
        pieces[1][5] = new Piece('w', 'n');
        // gen queens
        pieces[2][0] = new Piece('b', 'q');
        pieces[2][5] = new Piece('w', 'q');
        // gen kings
        pieces[3][0] = new Piece('b', 'k');
        pieces[3][5] = new Piece('w', 'k');
    }

    public void paintComponent(Graphics g)
    {
        // saattaa olla väärässä järjestyksessä, super.paintComp pitäis olla tod näk viimeisenä.
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // tätä ei käytetä?
        
        int size = 50;
        int topLeftX = 80;
        int topLeftY = 30;
        
        // if user clicked to move pieces, do it now
        if (processClick) {
            int a = (prevX - topLeftX) / size;
            int b = (prevY - topLeftY) / size;
            int i = (clickX - topLeftX) / size;
            int j = (clickY - topLeftY) / size;
            try {
                if (pieces[a][b] != null) {
                    pieces[i][j] = pieces[a][b];
                    pieces[a][b] = null;
                    processClick = false;
                    clickX = 0;
                    clickY = 0;
                }
            } catch (Exception e) {
                // previous or current click is outside board
            }
        }
        
        for (int i=0; i<6; i++) {
            boolean fill = (i%2 == 1 ? true : false);
            for (int j=0; j<6; j++) {
                int x = topLeftX + i*size;
                int y = topLeftY + j*size;
                if (fill) {
                    g.setColor(Color.gray);
                    g.fillRect(x, y, size, size);
                    g.setColor(Color.black);
                }
                Piece p = pieces[i][j];
                if (p != null) {
                    String code = (p.black ? "b" : "w") + p.symbol;
                    g.drawImage(givImage(code), x+3, y+3, this);
                }
                g.drawRect(x, y, size, size);
                fill = (fill ? false : true);
            }
        }
        
        
        // draw selection
        if (processClick) {
            int x = ((clickX - topLeftX) / size) * size + topLeftX;
            int y = ((clickY - topLeftY) / size) * size + topLeftY;
            g.setColor(Color.yellow);
            g.drawRect(x, y, size, size);
            g.drawRect(x+1, y+1, size, size);
            g.setColor(Color.black);
            processClick = false;
        }
        

        //g.drawImage <- tolla kuvia tjsp.
    }
    
    private Image givImage(String piece) {
        try {
            File input = new File("src/images/" + piece + ".svg.png");
            Image img = ImageIO.read(input);
            return img;
        } catch (Exception e) {
            System.out.println("nullaa");
            return null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        processClick = true;
        prevX = clickX;
        prevY = clickY;
        clickX = e.getX();
        clickY = e.getY();
        repaint();
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