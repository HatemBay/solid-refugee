/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Oussama
 */
public class ServicesUser {
       Connection c =Connexion.getInstance().getCnx(); 
   public String afficherUser(int id)  
   {  
            String list  = ""; 

       try { 
              
        
            PreparedStatement pt= c.prepareStatement("select *  from  fos_user WHERE id=?  "); 
       pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.first())  
            {     
                list= rs.getString(2); 
                System.out.println("Services.ServiceCategorie.afficherPersonne()");  
                return list; 
            }
            
          
        }  
        catch (SQLException ex) {
ex.printStackTrace();
        } 
        return list ; 
    }   
   
}
