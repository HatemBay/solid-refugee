/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Siss_Ima
 */
public class MyConnections {
    
     String url = "jdbc:mysql://localhost:3306/donation";
     String login = "root";
     String pwd = "";
    public  static MyConnections db;
    public Connection con;
    private MyConnections() {
         try {
             con=DriverManager.getConnection(url, login, pwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
    public Connection  getConnection()
    {
    return con;
    }     
    public static MyConnections getInstance()
    {if(db==null)
        db=new MyConnections();
    return db;
    
    
    }     
}
