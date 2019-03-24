/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class dBClass {
    private static Connection connection;
    public static Connection getConnection() 
    {
        if (connection == null) 
        {
            try 
            {
                String url=new String();
                String user=new String();
                String password=new String();
                url="jdbc:mysql://localhost:3306/score"; //give your database name and port number at which mysql is installed 
                user="root"; // give your mysql root name
                password="********"; // give your mysql root password
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection=DriverManager.getConnection(url,user,password);
                //System.out.println("Connected");
                JOptionPane.showMessageDialog(null,"Connected");
            }
            catch (SQLException t) 
            {
                JOptionPane.showMessageDialog(null,t.getMessage());
            }
        }
     return connection;
    }
}
