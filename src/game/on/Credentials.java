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
import java.sql.Statement;
import javax.swing.border.Border;

/**
 *
 * @author Asus
 */
public class Credentials extends JFrame{
    
    static JFrame maingameframe;
    JLabel main_name;
    JLabel player1_l,player2_l;
    JTextField player1_t,player2_t;
    static String player1Name="",player2Name="";
    JButton play_button;
    Border border,border1,border2;
    Font f,f1,f2;
    JTextField message;
    Container c;
    Image snake_body,snake_mouth,snake_food;
    public Credentials()
    {
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700,300, 500, 450);
        setTitle("Dual Snake 2.0");
        ImageIcon icon = new ImageIcon("src/drawable/snake.png");
        setIconImage(icon.getImage());
        
        initializeNames();
        
        
        
        
        
        
        
        
        //frame.setLocationRelativeTo(null);
        
    }
    
    
    public void initializeNames()
    {
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(201,87,12));
        
        
        border = BorderFactory.createLineBorder(Color.BLUE, 3);
        border1 = BorderFactory.createLineBorder(new Color(32,79,22), 2);
        border2 = BorderFactory.createLineBorder(new Color(201,87,12), 2);
        
        
        f=new Font("Showcard Gothic",Font.BOLD,32);
        f1=new Font("Showcard Gothic",Font.PLAIN,16);
        f2=new Font("Berlin Sans FB Demi",Font.BOLD,20);
        
        
        main_name=new JLabel("Dual Snake 2.0");
        main_name.setFont(f);
        main_name.setBounds(120,20,300,100);
        c.add(main_name);
        
        
        player1_l=new JLabel("  Player 1   Name : ");
        player1_l.setBounds(20,150,150,40);
        player1_l.setFont(f1);
        player1_l.setBorder(border1);
        c.add(player1_l);
        
        player1_t=new JTextField();
        player1_t.setBounds(180,150,300,40);
        player1_t.setFont(f1);
        player1_t.setBackground(Color.lightGray);
        player1_t.setBorder(border1);
        c.add(player1_t);
        
        
        player2_l=new JLabel("  Player 2   Name : ");
        player2_l.setBounds(20,220,150,40);
        player2_l.setFont(f1);
        player2_l.setBorder(border1);
        c.add(player2_l);
        
        
        player2_t=new JTextField();
        player2_t.setBounds(180,220,300,40);
        player2_t.setFont(f1);
        player2_t.setBackground(Color.lightGray);
        player2_t.setBorder(border1);
        c.add(player2_t);
        
        
        play_button=new JButton("  ENTER  ");
        play_button.setFont(f1);
        play_button.setBounds(330,280,150,50);
        play_button.setBackground(new Color(201,87,12));
        play_button.setBorder(border1);
        c.add(play_button);
        
        
        message=new JTextField();
        message.setFont(f2);
        message.setBackground(new Color(201,87,12));
        
        
        play_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(player1_t.getText().toString().toUpperCase().length()==0 || player2_t.getText().toString().toUpperCase().length()==0)
                {
                    message.setBounds(200,340,125,40);
                    message.setBorder(border1);
                    message.setText(" Empty Field");
                    c.add(message);
                }
                else if(player1_t.getText().toString().toUpperCase().equals(player2_t.getText().toString().toUpperCase()))
                {
                    message.setBounds(75,340,340,40);
                    message.setBorder(border1);
                    message.setText("  Player's  cant  have  the  same  name");
                    c.add(message);
                }
                else
                {
                    message.setText("");
                    message.setBorder(border2);
                    c.add(message);
                    insertNamesToDB();
                }
            }
        });
    }
    public void insertNamesToDB()
    {
        Connection c;
        Statement st;
        String query;
        ResultSet res;
        int suc=0;
        try
        {
            suc=1;
            c=dBClass.getConnection();
            st=(Statement)c.createStatement();
            query="Select * from score where name = '" + player1_t.getText().toString().toUpperCase() + "'";
            res=st.executeQuery(query);
            if(res.next())
            {
                
                    
            }
            else
            {
                try 
                {           
                    st.executeUpdate("Insert into score values('" + player1_t.getText().toString().toUpperCase() + "',0)");         
                }   
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }   
            }
            
            
            query="Select * from score where name = '" + player2_t.getText().toString().toUpperCase() + "'";
            res=st.executeQuery(query);
            if(res.next())
            {      
                    
            }
            else
            {
                try 
                {           
                    st.executeUpdate("Insert into score values('" + player2_t.getText().toString().toUpperCase() + "',0)");         
                }   
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }   
            }
        
         }
        catch(Exception e)
        {
            suc=9;
            System.out.println(e.getMessage());
        }
        if(suc==1)
        {
            
            startGame(player1_t.getText().toString(),player2_t.getText().toString());
            
            
        }
    }
    
    
    public void startGame(String f_name,String s_name)
    {
        player1Name=f_name.toUpperCase();
        player2Name=s_name.toUpperCase();
        this.dispose();
        
        maingameframe=new JFrame("Dual Snake 2.0");
        maingameframe.setResizable(false);
        maingameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maingameframe.setBounds(600,200, 905, 710);
        ImageIcon icon = new ImageIcon("src/drawable/snake.png");
        maingameframe.setIconImage(icon.getImage());
//        Container c1=maingameframe.getContentPane();
//        c1.setLayout(null);
        maingameframe.setBackground(new Color(184,176,50));
        maingameframe.add(new MainGamePlay());
        maingameframe.setVisible(true);
        
        
    }
    public final JFrame returnFrame()
    {
        return maingameframe;
    }
    
}
