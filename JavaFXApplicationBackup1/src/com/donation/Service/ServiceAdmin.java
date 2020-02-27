/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Admin;
import com.donation.IService.IService;
import java.sql.SQLException;
import java.util.List;
import com.donation.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hatem
 */
public class ServiceAdmin implements IService<Admin> {
    
    private final Connection con;
    private Statement ste;

    public ServiceAdmin() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Admin t) throws SQLException {
        ste = con.createStatement();
        String addAdmin = "INSERT INTO `donation`.`admin` (`Id_admin`, `Login_admin`, `Password_admin`, `First_name`, `Last_name`) "
                + "VALUES (NULL, '" + t.getLogin_admin() + "', '" + t.getPassword_admin() + "', '" + t.getFirst_name() + "', '" + t.getLast_name() + "');";
        ste.executeUpdate(addAdmin);
    }

    @Override
    public boolean delete(Admin t) throws SQLException {
        ste = con.createStatement();
        String deleteAdmin = "DELETE FROM `donation`.`admin` WHERE `Id_admin` = " + t.getId_admin();
        ste.executeUpdate(deleteAdmin);
        return ste.execute(deleteAdmin); //check*************************************** 
    }

    @Override
    public boolean update(Admin t) throws SQLException {
        ste = con.createStatement();
        String updateAdmin = "UPDATE `donation`.`admin` SET `Login_admin` = '" + t.getLogin_admin() + "', `Password_admin` = '" + t.getPassword_admin() + "'" 
                            + "WHERE `Id_admin` = " + t.getId_admin();
        ste.executeUpdate(updateAdmin);
        return ste.execute(updateAdmin); //check*************************************** 
    }

    @Override
    public List<Admin> readAll() throws SQLException {
        List<Admin> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from admin");
        while (rs.next()) {
            int Id_admin = rs.getInt("Id_admin");
            String Login_admin = rs.getString("Login_admin");
            String Password_admin = rs.getString("Password_admin");
            String First_name = rs.getString("First_name");
            String Last_name = rs.getString("Last_name");
            Admin a = new Admin(Id_admin, Login_admin, Password_admin, First_name, Last_name);
            arr.add(a);
        }
        return arr;
    }
    
    public List<String> readAllLogins() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from admin ;");
        while (rs.next()) {
            String logins = "" + rs.getString("Login_admin");
            arr.add(logins);
        }
        return arr;
    }
    
    public boolean session(Admin t) throws SQLException {
        ste = con.createStatement();
        String sessionAdmin = "UPDATE `donation`.`admin` SET `session` = 1 WHERE `Login_admin` = " + t.getLogin_admin();
        ste.executeUpdate(sessionAdmin);
        return ste.execute(sessionAdmin); //check*************************************** 
    }
   

}
