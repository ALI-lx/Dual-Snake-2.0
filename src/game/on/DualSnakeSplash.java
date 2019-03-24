/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.on;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 *
 * @author Asus
 */
public class DualSnakeSplash {

    /**
     * @param args the command line arguments
     */
    static JFrame mainframe;
    static JLabel name,image_label;
    static ImageIcon image,icon_image;
    static JButton play;
    static Container container;
    static Font f,f1;
    static Border border,border1;
    
    public static void main(String[] args) {
        
        icon_image = new ImageIcon("src/drawable/snake.png");
        
        
        mainframe=new JFrame("Dual Snake 2.0");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setBounds(700,300, 500, 400);
        mainframe.setResizable(false);
        mainframe.setIconImage(icon_image.getImage());
        
        
        container=mainframe.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(74,160,57));
        
        border = BorderFactory.createLineBorder(Color.BLUE, 3);
        border1 = BorderFactory.createLineBorder(new Color(32,79,22), 2);
        f=new Font("Showcard Gothic",Font.BOLD,32);
        f1=new Font("Showcard Gothic",Font.BOLD,20);
        
        
        name=new JLabel("Dual Snake 2.0");
        name.setFont(f);
        name.setBounds(120,20,300,100);
        container.add(name);
        
        
        //image=new ImageIcon("src/drawable/dual_snake.gif");
        
        
        image_label=new JLabel(icon_image);
        image_label.setBounds(180,110,150,160);
        image_label.setBorder(border1);
        container.add(image_label);
        
        play=new JButton("Play");
        play.setBounds(210,290,100,40);
        play.setFont(f1);
        play.setBorder(border1);
        play.setBackground(new Color(74,160,57));
        container.add(play);
        
        play.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainframe.dispose();
                JFrame cred=new Credentials();
                cred.setVisible(true);
            }
        });
        
        
        mainframe.setVisible(true);
        // TODO code application logic here
        
    }
    
}
