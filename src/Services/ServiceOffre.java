/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;



import Entities.Appel_don;
import Entities.Offre;
import Entities.belousovr_messages;
import Views.LoginController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author OusSama
 */
public class ServiceOffre {
      Statement ste ;
    Connection C;
     
    public ServiceOffre()
    {
        C =MyConnection.getInstance().getConn();
    }
    public void addoffre(Offre a)
    {
             try {
             Statement st = C.createStatement();
    String req = "insert into offre (type,contact,state,id_user) values ('" +a.getType()+ "','" +a.getContact()+"','" +a.getState()+"','" +a.getId_user()+ "')";
   
       System.out.println(req);
              st.executeUpdate(req);
          } catch (SQLException ex) {
              //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    
    
    public void modifieoffre(Offre a)
    {
          try {
            PreparedStatement pt = C.prepareStatement("update offre set type='"+a.getType()+"',contact='"+a.getContact()+"',state='"+a.getState()+'"');
           System.out.println(pt);
            
            pt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimeroffre(int id)
    {
        try {
            PreparedStatement pt = C.prepareStatement("delete  from offre  where id=?");
            pt.setInt(1,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ObservableList<Offre> afficheroffre(int idUser)
    {
         List<Offre> list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from offre WHERE user_id !="+idUser; 
            
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
             
                list.add(new Offre(rs.getString(1),rs.getString(2),rs.getString(3)));
              
            }   
        } catch (SQLException ex) {
            //Logger.getLogger(Service_cause.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ObservableList<Offre>) list;
        
    }
       public int getid(String titre)
      {
         
            try {
          String req="select * from offre  where contact='"+titre+"'";
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
          String req="select image from offre where id="+id+"";
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

    public ObservableList<Offre> afficheparid(int id) {
          ObservableList<Offre> list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from offre where user_id='"+id+"'";
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                 list.add(new Offre(rs.getString(1),rs.getString(2),rs.getString(3)));
              
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
         List<Offre> list=FXCollections.observableArrayList();
        try {
            Statement st = C.createStatement();
            String req="select * from offre WHERE id ="+idUser; 
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
     
 public List<Offre> recherche (String nom) {
        List<Offre> mylist = new ArrayList();
try {
    String req="select * from offre";
    ResultSet res = ste.executeQuery(req);
    
    
    while(res.next()){
        Offre s = new Offre();
        System.out.println(res.getInt(1)+" "+res.getString(2)+ " "+res.getString(3)+" ");
       s.setType(res.getString(1));
     s.setContact(res.getString(2));
     s.setState(res.getString(3));
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
