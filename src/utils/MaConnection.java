/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tarek
 */
public class MaConnection {

    final static String URL = "jdbc:mysql://127.0.0.1:3306/donation";
    final static String LOGIN = "root";
    final static String PWD = "";
    static MaConnection instance = null;
    private Connection cnx;
    private MaConnection() {
        
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("cnx etablie  ");
        } catch (SQLException e) {
             System.out.println("erreur de cnx ");    
      

        }
    }

  public static MaConnection getInstance() {
        if (instance == null)
        {
            instance = new MaConnection();
        }
        return instance;
    }
    public  Connection getConnection(){
        return cnx;
    }
}


