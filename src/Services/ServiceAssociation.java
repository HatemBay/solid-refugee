/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Interfaces.IServiceAssociation;
import Entity.Association;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;

/**
 *
 * @author tarek
 */
public class ServiceAssociation implements IServiceAssociation {
    Connection cnx;

    public ServiceAssociation() {
        cnx = MaConnection.getInstance().getConnection();
    }
 
    @Override
    public void addAssociation(Association a) throws SQLException {
        
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `association` (`Id_Association`, `Nom_Association`, `Objectif_Association`, `Email_Association`, `Password_Association`, `Address_Association`, `Type_Association`, `Description_Association`, `Logo_Association`)"
                + "     VALUES (NULL, '"+a.getNom_Association()+"', '"+a.getObjectif_Association()+"', '"+a.getEmail_Association()+"', '"+a.getPassword_Association()+"', '"+a.getAddress_Association()+"', '"+a.getType_Association()+"', '"+a.getDescription_Association()+"', '"+a.getLogo_Association()+"')";
         stm.executeUpdate(query);     
         System.out.println("Ajoutee");
    }

    @Override
    public List<Association> getAssociations() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `association`";
        ResultSet rst = stm.executeQuery(query);
        List<Association> associations = new ArrayList<>();
        while (rst.next()) {
            
            Association a2 = new Association();
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setNom_Association(rst.getString("Nom_Association"));
            a2.setObjectif_Association(rst.getString("Objectif_Association"));
            a2.setEmail_Association(rst.getString("Email_Association"));
            a2.setAddress_Association(rst.getString("Address_Association"));
            a2.setPassword_Association(rst.getString("Password_Association"));            
            a2.setType_Association(rst.getString("Type_Association"));
            a2.setDescription_Association(rst.getString("Description_Association"));
            a2.setLogo_Association(rst.getString("Logo_Association"));
            a2.setDate_inscrit(rst.getTimestamp("Date_inscrit"));
            
            associations.add(a2);
        }
     return associations;
    }

    @Override
    public Association getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `association` where Id_Association= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Association a2 = new Association();
        
        while (rst.next()) {
            
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setNom_Association(rst.getString("Nom_Association"));
            a2.setObjectif_Association(rst.getString("Objectif_Association"));
            a2.setEmail_Association(rst.getString("Email_Association"));
            a2.setPassword_Association(rst.getString("Password_Association"));
            a2.setAddress_Association(rst.getString("Address_Association"));
            a2.setType_Association(rst.getString("Type_Association"));
            a2.setDescription_Association(rst.getString("Description_Association"));
            a2.setLogo_Association(rst.getString("Logo_Association"));
            a2.setDate_inscrit(rst.getTimestamp("Date_inscrit"));
             
        }
     return a2;
    }

    public Association getByName(String name) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `association` where Nom_Association= '"+name+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Association a2 = new Association();
        
        while (rst.next()) {
            
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setNom_Association(rst.getString("Nom_Association"));
            a2.setObjectif_Association(rst.getString("Objectif_Association"));
            a2.setEmail_Association(rst.getString("Email_Association"));
            a2.setPassword_Association(rst.getString("Password_Association"));
            a2.setAddress_Association(rst.getString("Address_Association"));
            a2.setType_Association(rst.getString("Type_Association"));
            a2.setDescription_Association(rst.getString("Description_Association"));
            a2.setLogo_Association(rst.getString("Logo_Association"));
            a2.setDate_inscrit(rst.getTimestamp("Date_inscrit"));
             
        }
     return a2;
    }
    
    @Override
    public void deleteAssociation(Association a) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM association where Id_Association= '"+a.getId_Association()+"'";
        stm.executeUpdate(query);    
    }

    @Override
    public void deleteAssociation(int id) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM association where Id_Association= '"+id+"'";
        stm.executeUpdate(query);          
    }

    @Override
    public void updateAssociation(Association a) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "UPDATE association SET Nom_Association= '"+a.getNom_Association()+"', Objectif_Association= '"+a.getObjectif_Association()+"', Email_Association= '"+a.getEmail_Association()+"', Password_Association= '"+a.getPassword_Association()+"', Address_Association= '"+a.getAddress_Association()+"', Type_Association= '"+a.getType_Association()+"', Description_Association= '"+a.getDescription_Association()+"', Logo_Association= '"+a.getLogo_Association()+"' WHERE Id_Association='"+a.getId_Association()+"'";
        stm.executeUpdate(query); 
    }

    
    @Override
    public List<Association> TrierAssociations(int i) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "";
        if (i==1) {
            query = "select * from `association` ORDER BY Date_inscrit ASC";
        }else if (i==2) {
            query = "select * from `association` ORDER BY Nom_Association ASC";
        }
        
        ResultSet rst = stm.executeQuery(query);
        List<Association> associations = new ArrayList<>();
        while (rst.next()) {
            
            Association a2 = new Association();
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setNom_Association(rst.getString("Nom_Association"));
            a2.setObjectif_Association(rst.getString("Objectif_Association"));
            a2.setEmail_Association(rst.getString("Email_Association"));
            a2.setAddress_Association(rst.getString("Address_Association"));
            a2.setType_Association(rst.getString("Type_Association"));
            a2.setDescription_Association(rst.getString("Description_Association"));
            a2.setLogo_Association(rst.getString("Logo_Association"));
            a2.setDate_inscrit(rst.getTimestamp("Date_inscrit"));
            
            associations.add(a2);
        }
     return associations;
    }
    @Override
    public List<Association> SearchAssociations(String character) throws SQLException  {
        Statement stm = cnx.createStatement();
        String req="select * from association where Nom_Association  LIKE '%"+character+"%'" ;
        ResultSet rst = stm.executeQuery(req);
        List<Association> associations = new ArrayList<>();
        while (rst.next()) {
            Association a2 = new Association();
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setNom_Association(rst.getString("Nom_Association"));
            a2.setObjectif_Association(rst.getString("Objectif_Association"));
            a2.setEmail_Association(rst.getString("Email_Association"));
            a2.setAddress_Association(rst.getString("Address_Association"));
            a2.setType_Association(rst.getString("Type_Association"));
            a2.setDescription_Association(rst.getString("Description_Association"));
            a2.setLogo_Association(rst.getString("Logo_Association"));
            a2.setDate_inscrit(rst.getTimestamp("Date_inscrit"));
            associations.add(a2);
        }
     return associations;
    }

    @Override
    public List<String> SearchAssociationsNames(String character) throws SQLException {
       Statement stm = cnx.createStatement();
        String req="select * from association where Nom_Association  LIKE '%"+character+"%'" ;
        ResultSet rst = stm.executeQuery(req);
        List<String> associations = new ArrayList<>();
        while (rst.next()) {
            String a2 = "";
            a2=rst.getString("Nom_Association");
            associations.add(a2);
        }
     return associations;
    }
    
}
