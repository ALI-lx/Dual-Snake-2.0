/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.on;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class MainGamePlay extends JPanel implements KeyListener,ActionListener 
{
    
    static String Winner,Reason;
    
    JLabel name_main;
    int[] snakexlength=new int[750];
    int[] snakeylength=new int[750];
    int lengthofsnake=3;//initial length=3
    
    int[] snakexlength2=new int[750];
    int[] snakeylength2=new int[750];
    int lengthofsnake2=3;//initial length=3
    
    
    int moves=0;
    int moves2=0;
    
    int[] foodxpos= {   25,50,75,100,
                        125,150,175,200,
                        225,250,275,300,
                        325,350,375,400,
                        425,450,475,500,
                        525,550,575,600,
                        625,650,675,700,
                        725,750,775,800,
                        825,850
                    };
    
    int[] foodypos= {   75,100,125,150,
                        175,200,225,250,
                        275,300,325,350,
                        375,400,425,450,
                        475,500,525,550,
                        575,600,625
                    };
    
    Random random=new Random();
    int xpos=random.nextInt(34);
    int ypos=random.nextInt(23);
    
    
    boolean up=false,down=false,right=true,left=false;
    
    boolean up2=true,down2=false,right2=false,left2=false;
    
    ImageIcon rightmouth,leftmouth,upmouth,downmouth,snakeimage,food_of_snake;
    
    ImageIcon rightmouth2,leftmouth2,upmouth2,downmouth2,snakeimage2,food_of_snake2;
    
    Timer timer;
    int delay=100;
    
    static int score=0;
    static int score2=0;
    
   
    public MainGamePlay()
    {
        addKeyListener(this);
        setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    {
        if(moves==0)
        {
            snakexlength[0]=100;
            snakexlength[1]=75;
            snakexlength[2]=50;
            snakeylength[0]=100;
            snakeylength[1]=100;
            snakeylength[2]=100;
           
        }
        if(moves2==0)
        {
            snakexlength2[0]=500;
            snakexlength2[1]=500;
            snakexlength2[2]=500;
            snakeylength2[0]=500;
            snakeylength2[1]=525;
            snakeylength2[2]=550;
        }
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Showcard Gothic",Font.BOLD,45));
        g.drawString("Dual Snake 2.0", 260, 55);
        
      
        g.drawRect(22,72,855,580);
        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);
        g.setColor(new Color(4,6,118));
        g.setFont(new Font("Arial",Font.BOLD,22));
        g.drawString(Credentials.player2Name , 650, 30);
        if(score==0)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("Scores : " + score, 650, 60);
        }
        else
        {
            
            g.clearRect(650, 35, 120, 29);
            g.setColor(new Color(184,176,50));
            g.fillRect(650, 35, 120, 29);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("Scores : "+score, 650, 60);
        }
        
        g.setColor(new Color(6,64,9));
        g.setFont(new Font("Arial",Font.BOLD,22));
        g.drawString(Credentials.player1Name , 30, 30);
        
        if(score2==0)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("Scores : "+score2, 30, 60);
        }
        else
        {
            
            g.clearRect(60, 45, 100, 19);
            g.setColor(new Color(184,176,50));
            g.fillRect(60, 45, 100, 19);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.PLAIN,20));
            g.drawString("Scores : "+score2, 30, 60);
        }
        
        
        
        
        
        
//        rightmouth=new ImageIcon("rightmouth.png");
//        rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
        
        for(int a=0;a<lengthofsnake;a++)
        {
            if(a==0)
            {
                if(left)
                {
                    leftmouth=new ImageIcon("src/drawable/leftmouth.png");
                    leftmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
                }
                if(right)
                {
                    rightmouth=new ImageIcon("src/drawable/rightmouth.png");
                    rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
                }
                if(up)
                {
                    upmouth=new ImageIcon("src/drawable/upmouth.png");
                    upmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
                }
                if(down)
                {
                    downmouth=new ImageIcon("src/drawable/downmouth.png");
                    downmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
                }
            }
            else
            {
                snakeimage=new ImageIcon("src/drawable/snakeimage_1.png");
                snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
            }
        }
        
        
        
        for(int a=0;a<lengthofsnake2;a++)
        {
            if(a==0)
            {
                if(left2)
                {
                    leftmouth2=new ImageIcon("src/drawable/leftmouthgreen.png");
                    leftmouth2.paintIcon(this, g, snakexlength2[0], snakeylength2[0]);
                }
                if(right2)
                {
                    rightmouth2=new ImageIcon("src/drawable/rightmouthgreen.png");
                    rightmouth2.paintIcon(this, g, snakexlength2[0], snakeylength2[0]);
                }
                if(up2)
                {
                    upmouth2=new ImageIcon("src/drawable/upmouthgreen.png");
                    upmouth2.paintIcon(this, g, snakexlength2[0], snakeylength2[0]);
                }
                if(down2)
                {
                    downmouth2=new ImageIcon("src/drawable/downmouthgreen.png");
                    downmouth2.paintIcon(this, g, snakexlength2[0], snakeylength2[0]);
                }
            }
            else
            {
                snakeimage2=new ImageIcon("src/drawable/snakeimagegreen.png");
                snakeimage2.paintIcon(this, g, snakexlength2[a], snakeylength2[a]);
            }
        }
        
        
        if((foodxpos[xpos] == snakexlength[0] && foodypos[ypos] == snakeylength[0]) || (foodxpos[xpos] == snakexlength2[0] && foodypos[ypos] == snakeylength2[0]))
        {
            if((foodxpos[xpos] == snakexlength[0] && foodypos[ypos] == snakeylength[0]))
            {
                if(score!=0 && score%20==0)
                {
                    score+=6;
                }
                else
                {
                    score+=2;
                }
                
                lengthofsnake++;
            }
            if((foodxpos[xpos] == snakexlength2[0] && foodypos[ypos] == snakeylength2[0]))
            {
                if(score2!=0 && score2%20==0)
                {
                    score2+=6;
                }
                else
                {
                    score2+=2;
                }

                lengthofsnake2++;
            }
            
            xpos=random.nextInt(34);
            ypos=random.nextInt(23);
            
        }
        if(score!=0 && score%20==0)
        {
            food_of_snake=new ImageIcon("src/drawable/enemy.png");
        }
        else
        {
            food_of_snake=new ImageIcon("src/drawable/enemy.png");
        }
        food_of_snake.paintIcon(this,g,foodxpos[xpos],foodypos[ypos]);
        //repaint();
        
        for(int b=1;b<lengthofsnake;b++)
        {
            if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0])
            {
                Winner=Credentials.player1Name;
                Reason=Credentials.player2Name;
                
                right=false;
                up=false;
                down=false;
                left=false;
                right2=false;
                up2=false;
                down2=false;
                left2=false;
                gameOver(g);
            }
            if(snakexlength[b]==snakexlength2[0] && snakeylength[b]==snakeylength2[0])
            {
                Winner=Credentials.player2Name;
                Reason=Credentials.player1Name;
                right=false;
                up=false;
                down=false;
                left=false;
                right2=false;
                up2=false;
                down2=false;
                left2=false;
                gameOver(g);
            }
        }
        for(int b=1;b<lengthofsnake2;b++)
        {
            if(snakexlength2[b]==snakexlength2[0] && snakeylength2[b]==snakeylength2[0])
            {
                Winner=Credentials.player2Name;
                Reason=Credentials.player1Name;
                right2=false;
                up2=false;
                down2=false;
                left2=false;
                right=false;
                up=false;
                down=false;
                left=false;
                gameOver(g);
            }
            if(snakexlength2[b]==snakexlength[0] && snakeylength2[b]==snakeylength[0])
            {
                Winner = Credentials.player1Name;
                Reason=Credentials.player2Name;
                right=false;
                up=false;
                down=false;
                left=false;
                right2=false;
                up2=false;
                down2=false;
                left2=false;
                gameOver(g);
            }
        }
        
        g.dispose();
    }
    
    public void gameOver(Graphics g)
    {
      
      Credentials.maingameframe.dispose();
      JFrame res=new Result();
      res.setVisible(true);
      
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode()==KeyEvent.VK_W)
        {
            moves2++;
            //right=true;
            if(!down2)
            {
                up2=true;
                down2=false;
            }
            else
            {
                up2=false;
                down2=true;
            }
            right2=false;
            left2=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            moves2++;
            //right=true;
            if(!up2)
            {
                down2=true;
                up2=false;
            }
            else
            {
                up2=true;
                down2=false;
            }
            right2=false;
            left2=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_A)
        {
            moves2++;
            //right=true;
            if(!right2)
            {
                left2=true;
                right2=false;
            }
            else
            {
                left2=false;
                right2=true;
            }
            up2=false;
            down2=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_D)
        {
            moves2++;
            //right=true;
            if(!left2)
            {
                right2=true;
                left2=false;
            }
            else
            {
                right2=false;
                left2=true;
            }
            up2=false;
            down2=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            moves++;
            //right=true;
            if(!left)
            {
                right=true;
                left=false;
            }
            else
            {
                right=false;
                left=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            moves++;
            //right=true;
            if(!right)
            {
                left=true;
                right=false;
            }
            else
            {
                left=false;
                right=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            moves++;
            //right=true;
            if(!down)
            {
                up=true;
                down=false;
            }
            else
            {
                up=false;
                down=true;
            }
            right=false;
            left=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            moves++;
            //right=true;
            if(!up)
            {
                down=true;
                up=false;
            }
            else
            {
                up=true;
                down=false;
            }
            right=false;
            left=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(left)
        {
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakexlength[r] = snakexlength[r] - 25;
                }
                else
                {
                    snakexlength[r] = snakexlength[r-1];
                }
                if(snakexlength[r] < 25)
                {
                    snakexlength[r] = 850;
                }
                
            }
            repaint();
        }
        if(left2)
        {
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                snakeylength2[r+1] = snakeylength2[r];
            }
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakexlength2[r] = snakexlength2[r] - 25;
                }
                else
                {
                    snakexlength2[r] = snakexlength2[r-1];
                }
                if(snakexlength2[r] < 25)
                {
                    snakexlength2[r] = 850;
                }
                
            }
            repaint();
        }
        
        
        
        if(right)
        {
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                snakeylength[r+1] = snakeylength[r];
            }
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakexlength[r] = snakexlength[r] + 25;
                }
                else
                {
                    snakexlength[r] = snakexlength[r-1];
                }
                if(snakexlength[r] > 850)
                {
                    snakexlength[r] = 25;
                }
                
            }
            repaint();
            
        }
        if(right2)
        {
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                snakeylength2[r+1] = snakeylength2[r];
            }
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakexlength2[r] = snakexlength2[r] + 25;
                }
                else
                {
                    snakexlength2[r] = snakexlength2[r-1];
                }
                if(snakexlength2[r] > 850)
                {
                    snakexlength2[r] = 25;
                }
                
            }
            repaint();
            
        }
        
        
        
        
        if(up)
        {
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakeylength[r] = snakeylength[r] - 25;
                }
                else
                {
                    snakeylength[r] = snakeylength[r-1];
                }
                if(snakeylength[r] < 75 )
                {
                    snakeylength[r] = 625;
                }
                
            }
            repaint();
        }
        if(up2)
        {
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                snakexlength2[r+1] = snakexlength2[r];
            }
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakeylength2[r] = snakeylength2[r] - 25;
                }
                else
                {
                    snakeylength2[r] = snakeylength2[r-1];
                }
                if(snakeylength2[r] < 75 )
                {
                    snakeylength2[r] = 625;
                }
                
            }
            repaint();
        }
        
        
        
        
        if(down)
        {
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                snakexlength[r+1] = snakexlength[r];
            }
            for(int r = lengthofsnake-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakeylength[r] = snakeylength[r] + 25;
                }
                else
                {
                    snakeylength[r] = snakeylength[r-1];
                }
                if(snakeylength[r] > 625 )
                {
                    snakeylength[r] = 75;
                }
                
            }
            repaint();
        }
        if(down2)
        {
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                snakexlength2[r+1] = snakexlength2[r];
            }
            for(int r = lengthofsnake2-1; r >= 0; r--)
            {
                if(r==0)
                {
                    snakeylength2[r] = snakeylength2[r] + 25;
                }
                else
                {
                    snakeylength2[r] = snakeylength2[r-1];
                }
                if(snakeylength2[r] > 625 )
                {
                    snakeylength2[r] = 75;
                }
                
            }
            repaint();
        }
    }
    
}
