/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Admin;
import com.donation.Entite.Association2;
import com.donation.IService.IService;
import com.donation.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hatem
 */
public class ServiceAssociation2 implements IService<Association2> {
    
    private final Connection con;
    private Statement ste;

    public ServiceAssociation2() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Association2 t) throws SQLException {
        ste = con.createStatement();
        String addAssociation = "INSERT INTO `donation`.`association2` (`Id_Association`, `Nom_Association`, `Email_Association`, `Password_Association`, `Address_Association`, `Type_Association`, `Object_Association`, `Description_Association`) "
                + "VALUES (NULL, '" + t.getNom_Association() + "', '" + t.getEmail_Association() + "', '" + t.getPassword_Association() + "', '" + t.getAddress_Association() + "', '" + t.getType_Association() + "', '" + t.getObject_Association() + "', '" + t.getDescription_Association() + "');";
        ste.executeUpdate(addAssociation);
    }

    @Override
    public boolean delete(Association2 t) throws SQLException {
        ste = con.createStatement();
        String deleteAssociation = "DELETE FROM `donation`.`association2` WHERE `Id_admin` = " + t.getId_Association();
        ste.executeUpdate(deleteAssociation);
        return ste.execute(deleteAssociation); //check*************************************** 
    }

    @Override
    public boolean update(Association2 t) throws SQLException {
        ste = con.createStatement();
        String updateAssociation = "UPDATE `donation`.`association2` SET `Nom_Association` = '" + t.getNom_Association() + "', `Email_Association` = '" + t.getEmail_Association() + "', `Password_Association` = '" + t.getPassword_Association() + "', `Address_Association` = '" + t.getAddress_Association() + "', `Type_Association` = '" + t.getType_Association() + "', `Object_Association` = '" + t.getObject_Association() + "', `Description_Association` = '" + t.getDescription_Association() + "'" 
                            + "WHERE `Id_Association` = " + t.getId_Association();
        ste.executeUpdate(updateAssociation);
        return ste.execute(updateAssociation); //check*************************************** 
    }

    @Override
    public List<Association2> readAll() throws SQLException {
        List<Association2> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from association2");
        while (rs.next()) {
            int Id_Association = rs.getInt("Id_Association");
            String Nom_Association = rs.getString("Nom_Association");
            String Email_Association = rs.getString("Email_Association");
            String Password_Association = rs.getString("Password_Association");
            String Address_Association = rs.getString("Address_Association");
            String Type_Association = rs.getString("Type_Association");
            String Object_Association = rs.getString("Object_Association");
            String Description_Association = rs.getString("Description_Association");
            Association2 a = new Association2(Id_Association, Nom_Association, Email_Association, Password_Association, Address_Association, Type_Association, Object_Association, Description_Association);
            arr.add(a);
        }
        return arr;
    }
    
    public List<String> readAllEmails() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from association2 ;");
        while (rs.next()) {
            String emails = "" + rs.getString("Email_Association");
            arr.add(emails);
        }
        return arr;
    }
    
    
   

}
