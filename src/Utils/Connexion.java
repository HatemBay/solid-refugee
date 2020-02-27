/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
  import java.sql.*;  
/**
 *
 * @author Oussama
 */ 

public class Connexion {
    static String url="jdbc:mysql://127.0.0.1:3306/eco2"; 
static String name ="root"; 

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
static String password ="";    
private Connection cnx; 
 static  Connexion conInstance; 
 
 
 private Connexion()  
  { 
         try 
      {   
 
           cnx= DriverManager.getConnection(url, name, password); 
          System.out.println("Connexion etablie");
      }catch(SQLException ex)     
      { 
      }
  } 

      public static Connexion getInstance() 
        { 
        if (conInstance==null) 
        {    
        conInstance =new Connexion(); 
        } 
        return conInstance;  
        } 
 
  
 }
