/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.on;
import database.dBClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.Border;

/**
 *
 * @author Asus
 */
public class Result extends JFrame 
{
    Container c;
    JLabel result_show,main_name,game_over,player_1,player_2,won,lose;
    JLabel highScore1,message;
    JButton top3Scores,exit;
    Font f,f1;
    Border border1;
    
    
    public Result()
    {
        setTitle("Dual Snake 2.0");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200, 905, 710);
        ImageIcon icon = new ImageIcon("src/drawable/snake.png");
        setIconImage(icon.getImage());
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(184,176,50));
        
        f=new Font("Showcard Gothic",Font.BOLD,25);
        f1=new Font("Showcard Gothic",Font.BOLD,42);
        border1 = BorderFactory.createLineBorder(new Color(32,79,22), 2);
        
        
        main_name=new JLabel("Dual   Snake   2.0");
        main_name.setFont(f1);
        main_name.setBounds(250,20,500,100);
        c.add(main_name);
        
        
        game_over=new JLabel("Game   Over");
        game_over.setFont(f);
        game_over.setBorder(border1);
        game_over.setBounds(360,125,170,50);
        c.add(game_over);
        
        result_show=new JLabel("Current Match Result");
        result_show.setFont(f);
        result_show.setBorder(border1);
        result_show.setBounds(280,185,330,50);
        c.add(result_show);
        
        //player_1,player_2,won
        player_1=new JLabel("Player 1 - " + 
                Credentials.player1Name.toUpperCase()+"       Score - "+
                Integer.toString(MainGamePlay.score2));
        player_1.setBounds(250,265,600,30);
        player_1.setFont(f);
        c.add(player_1);
        
        player_2=new JLabel("Player 2 - " + 
                Credentials.player2Name.toUpperCase()+"       Score - "+
                Integer.toString(MainGamePlay.score));
        player_2.setBounds(250,315,600,30);
        player_2.setFont(f);
        c.add(player_2);
        
        won=new JLabel(">> "+ 
                MainGamePlay.Winner.toUpperCase()+"  wins  the  match!!!");
        won.setBounds(200,365,600,30);
        won.setFont(f);
        c.add(won);
        
        lose=new JLabel(">> "+ 
                MainGamePlay.Reason.toUpperCase()+"  collided with something!!!");
        lose.setBounds(200,415,600,30);
        lose.setFont(f);
        c.add(lose);
        updateScore();
        
    }
    
    public void updateScore()
    {
        int checkScore1=0,checkScore2=0;
        try 
        {            
            Connection c=dBClass.getConnection();
            Statement s=(Statement)c.createStatement();
            String query="Select * from score where name = '" + Credentials.player1Name.toUpperCase() +"'";
            ResultSet r=s.executeQuery(query);
            if (r.next())
            {
                int p1Score = Integer.parseInt(r.getString("score"));
                if (MainGamePlay.score2 <= p1Score)
                {
                      checkScore1=1;
                }
                else
                {
                    checkScore1=10;
                    String sqel = "UPDATE score Set score ='" + MainGamePlay.score2 +"' where name = '" + Credentials.player1Name.toUpperCase()+ "'";     
                    s.executeUpdate(sqel); 
                }
                      
            }            
            
            
            
            String query1="Select * from score where name = '" + Credentials.player2Name.toUpperCase() +"'";
            ResultSet r1=s.executeQuery(query1);
            if (r1.next())
            {
                int p2Score = Integer.parseInt(r1.getString("score"));
                if (MainGamePlay.score <= p2Score)
                {
                    checkScore2=1;
                }
                else
                {
                    checkScore2=10;
                    String sqel = "UPDATE score Set score ='" + MainGamePlay.score +"' where name = '" + Credentials.player2Name.toUpperCase()+ "'";     
                    s.executeUpdate(sqel); 
                }
                      
            }            
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
        
        if((checkScore1==10) && (checkScore2==10))
        {
            //highScore1,message
            highScore1=new JLabel(">>  Congrats   "+Credentials.player1Name+"   &   "+Credentials.player2Name);
            highScore1.setBounds(100,455,600,30);
            highScore1.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(highScore1);
            
            message=new JLabel("Both of you have reached a new score");
            message.setBounds(100,495,600,30);
            message.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(message);
        }
        if((checkScore1==10) && (checkScore2!=10))
        {
            //highScore1,message
            highScore1=new JLabel(">>  Congrats   "+Credentials.player1Name);
            highScore1.setBounds(100,455,600,30);
            highScore1.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(highScore1);
            
            message=new JLabel("you have reached a new score");
            message.setBounds(100,495,600,30);
            message.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(message);
        }
        if((checkScore1!=10) && (checkScore2==10))
        {
            //highScore1,message
            highScore1=new JLabel(">>  Congrats   "+Credentials.player2Name);
            highScore1.setBounds(100,455,600,30);
            highScore1.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(highScore1);
            
            message=new JLabel("you have reached a new score");
            message.setBounds(100,495,600,30);
            message.setFont(new Font("Showcard Gothic",Font.BOLD,25));
            c.add(message);
        }
        
        //top3Scores,exit
        
        top3Scores=new JButton("Leaderboard");
        top3Scores.setBounds(100, 555, 200, 40);
        top3Scores.setFont(f);
        top3Scores.setBorder(border1);
        c.add(top3Scores);
        
        top3Scores.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ImageIcon icon_image = new ImageIcon("src/drawable/snake.png");
        
        
                JFrame leader=new JFrame("Dual Snake 2.0");
                leader.setBounds(650,350, 400, 500);
                leader.setResizable(false);
                leader.setIconImage(icon_image.getImage());


                Container container=leader.getContentPane();
                container.setLayout(null);
                container.setBackground(new Color(184,176,50));

                Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
                border1 = BorderFactory.createLineBorder(new Color(32,79,22), 2);
                f=new Font("Showcard Gothic",Font.BOLD,32);
                f1=new Font("Showcard Gothic",Font.BOLD,20);
                
                JLabel label=new JLabel("Name                           Score");
                label.setBounds(20,10,350,40);
                label.setFont(f1);
                label.setBorder(border1);
                label.setBackground(new Color(184,176,50));
                container.add(label);
                
                JTextArea names=new JTextArea();
                names.setBounds(20,60,350,380);
                try
                {
                    Connection c=dBClass.getConnection();
                    Statement s=(Statement)c.createStatement();
                    String query="Select * from score order by score DESC";
                    ResultSet r=s.executeQuery(query);
                    for(int i=0;i<5;i++)
                    {
                        r.next();
                        names.append(""+r.getString("name") + "                        " +r.getString("score")+"\n\n\n");
                    }
                       
                }
                catch(Exception e1)
                {
                    System.out.println(e1);
                }
                names.setFont(f1);
                names.setBorder(border1);
                names.setBackground(new Color(184,176,50));
                container.add(names);
                
                leader.setVisible(true);
            }
        });
        
        
        exit=new JButton("Exit");
        exit.setBounds(700, 555, 80, 40);
        exit.setFont(f);
        exit.setBorder(border1);
        c.add(exit);
        
        exit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
    }
}
