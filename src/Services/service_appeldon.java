/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Appel_don;
//import Entities.Cause;
import Entities.belousovr_messages;
import Utils.Connexion;
import Views.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Oussama
 */
public class service_appeldon {
    Statement ste ;
    Connection C;
     private ObservableList<Appel_don> list;
    public service_appeldon()
    {
        C =MyConnection.getInstance().getConn();
    }
    public void ajoutappeldon(Appel_don a)
    {
             try {
             Statement st = C.createStatement();
    String req = "insert into appels_don (name,image,description,Category,user_id) values ('" +a.getNom()+ "','" +a.getImage()+ "','"+a.getDescription()+ "','" +a.getCategory()+ "','" +a.getUser_id()+ "')";
   
       System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
              //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    public void modifieappeldon(Appel_don a)
    {
          try {
            PreparedStatement pt = C.prepareStatement("update appels_don set name='"+a.getNom()+"',image='"+a.getImage()+"',description='"+a.getDescription()+"',Category='"+a.getCategory()+"'  where id ='"+a.getId()+"'");
           System.out.println(pt);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerappeldon(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from appels_don  where id=?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ObservableList<Appel_don> afficherappeldon(int idUser)
    {
         list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from appels_don WHERE user_id !="+idUser; 
            
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
             
                list.add(new Appel_don(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
              
            }   
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
       public int getid(String titre)
      {
         
            try {
          String req="select * from appels_don where name='"+titre+"'";
          System.out.println(req);
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 while(rs.next()) {
                 
                        return rs.getInt(1);
                      
                       
                    
                    
                }
                    
                  } catch (SQLException ex) {
                
            }
          
         return 0; 
      }
        public String getImage(int id)
    {
           try {
          String req="select image from appels_don where id="+id+"";
          System.out.println(req);
           Statement stl = C.createStatement();
                ResultSet rs = stl.executeQuery(req);
                 while(rs.next()) {
                 
                        return rs.getString(1);
                      
                       
                    
                    
                }
                    
                  } catch (SQLException ex) {
                
            }
           return "";
    }

    public ObservableList<Appel_don> afficheparid(int id) {
           list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from appels_don where user_id='"+id+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                  list.add(new Appel_don(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
              
               }   
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
     public void ajoutmessage(belousovr_messages m)
    {
             try {
             Statement st = C.createStatement();
    String req = "insert into belousovr_messages (idDon,author_id,addressee_id,messageText,reading) values ('" +m.getIdDon()+ "','" +m.getAuthor_id()+ "','"+m.getAddressee_id()+ "','" +m.getMessageText()+ "','" +m.getReading()+ "')";
   
       System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
              //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    } 
     
     
         public ObservableList<belousovr_messages> selectMessage()
    {                
ObservableList<belousovr_messages> lis =FXCollections.observableArrayList();

             try  
          { 
             Statement st = C.createStatement();
    String req = "select * from belousovr_messages WHERE addressee_id= "+LoginController.iduser;
   ResultSet rs = st.executeQuery(req);
            while(rs.next())
             {
   lis.add(new belousovr_messages(0, rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),  rs.getInt(6))); 
             }
          } 
             catch (SQLException ex) {
              //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
          }
     return lis;    
    } 
         
          public String afficherNom(int idUser)
    { 
                    String res=""; 
         list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from appels_don WHERE id ="+idUser; 
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
             
                 res=rs.getString(3); 
            }   
        } catch (SQLException ex) {
           // Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    }
     
 public List<Appel_don> recherche (String nom) {
        List<Appel_don> mylist = new ArrayList();
try {
    String req="select * from appels_don";
    ResultSet res = ste.executeQuery(req);
    
    
    while(res.next()){
        Appel_don s = new Appel_don();
        System.out.println(res.getInt(1)+" "+res.getString(2)+ " "+res.getString(3)+" ");
       s.setId(res.getInt(1));
     s.setDescription(res.getString(2));
     s.setNom(res.getString(3));
//     s.set(res.getString(4));
//    s.setEmail(res.getString(5));
//     s.setPassword(res.getString(6));
//     s.setRole(res.getString(7));
//     s.setAdress(res.getString(8));
//     s.setNumtel(res.getString(9));
//      s.setImage(res.getString(10));
     
   
    mylist.add(s);
    }
}
catch (SQLException ex){
    System.out.println(ex.getMessage());
}

  return mylist;
    }
 
 
 
    
}
