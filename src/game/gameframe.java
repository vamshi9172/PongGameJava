/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hello
 */
public class gameframe extends JFrame implements KeyListener,ActionListener{
    static int x=490,y=340;
    static boolean h=true,v=false;
    static int p1x=0,p1y=310,p2x=988,p2y=310;
    static JLabel p1s,p2s;
    gameframe() throws InterruptedException
    {
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        JPanel panel=new JPanel();
        add(panel);
        panel.setSize(1020,680);
        panel.setLocation(0,20);
        addKeyListener(this);
        setVisible(true);
        while(true)
        {
            vk();
            repaint();
            Thread.sleep(102);
        }
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0,0,1000,700);
         p1s=new JLabel("0");
         p1s.setBounds(450,20,40,30);
         p2s=new JLabel("0");
         p2s.setBounds(520,20,40,30);
       /* g.setColor(Color.white);
        g.fillRect(499,0,2,700);
        g.fillRect(0,349,1000,2);*/
        g.setColor(Color.white);
        g.setColor(Color.yellow);
        g.fillRect(p1x,p1y,12,80);
        g.fillRect(p2x,p2y,12,80);
        g.setColor(Color.white);
        g.fillOval(x,y,20,20);
    }

    static void vk() {
        boolean te=false;
        if(x+20>988){
            if(y<p2y || y>p2y+80){
            p1s.setText(Integer.toString(Integer.parseInt(p1s.getText())+1));
            x=490;
            y=340;
            Random rd=new Random();
            if(rd.nextInt(2)==1)
            //v=!v;
            h=!h;
            return;
            }
            x=980-12;
            if(v)
            y+=20;
            else
            y-=20;
            h=!h;
            te=true;
        }
        if(x<12){
            if(y<p1y || y>p1y+80){
            p2s.setText(Integer.toString(Integer.parseInt(p2s.getText())+1));
            x=490;
            y=340;
            return;
            }
            x=12 ;
            if(v)
            y+=20;
            else
            y-=20;
            h=!h;
            te=true;
        }
        
        if(y<0)
        {
            y=0;
            if(h)
            x+=20;
            else
            x-=20;
            v=!v;
            te=true;
        }
        if(y+20>700){
            y=680;
            if(h)
            x+=20;
            else
            x-=20;
            v=!v;
            te=true;
        }
        if(te==false)
        {
            if(v)
             y+=25;
            else
             y-=25;
            if(h)
             x+=25;
            else
             x-=25;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ke.getKeyCode()==KeyEvent.VK_SPACE){
           
        }
        if(ke.getKeyCode()==KeyEvent.VK_UP){
           if(p1y-50<0)
               p1y=0;
           else
               p1y-=50;           
        }
        else if(ke.getKeyCode()==KeyEvent.VK_DOWN){
            if(p1y+50>700)
                p1y=620;
            else
                p1y+=50;
            }
        if(ke.getKeyCode()==KeyEvent.VK_A){
           if(p2y-50<0)
               p2y=0;
           else
               p2y-=50;           
        }
        else if(ke.getKeyCode()==KeyEvent.VK_Z){
            if(p2y+50>700)
                p2y=620;
            else
                p2y+=50;
            }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
