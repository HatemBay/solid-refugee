/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Admin;
import com.donation.Entite.Users;
import com.donation.IService.IService;
import com.donation.Utils.DataBase;
import com.donation.Utils.UserSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hatem
 */
public class ServiceUsers implements IService<Users> {

    private Connection con;
    private Statement ste;
    public static Users currentUser = new Users();

    public ServiceUsers() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(Users t) throws SQLException {
        ste = con.createStatement();
        String addUser = "INSERT INTO `donation`.`users` (`Id_user`, `Login_user`, `Password_user` , `First_name` , `Last_name` , `Tel` , `Address` , `Blood_type`) "
                + "VALUES (NULL, '" + t.getLogin_user() + "', '" + t.getPassword_user() + "', '" + t.getFirst_name() + "', '" + t.getLast_name()  + "', '" + t.getTel() + "', '" + t.getAddress() + "', '" + t.getBlood_type() + "');";
        ste.executeUpdate(addUser);
    }


    @Override
    public boolean delete(Users t) throws SQLException {
        ste = con.createStatement();
        String deleteAdmin = "DELETE FROM `donation`.`users` WHERE `Id_user` = " + t.getId_user();
        ste.executeUpdate(deleteAdmin);
        return ste.execute(deleteAdmin); //check*************************************** 
    }

    @Override
    public boolean update(Users t) throws SQLException {
        ste = con.createStatement();
        String updateUser = "UPDATE `donation`.`users` SET `Login_user` = '" + t.getLogin_user() + "', `Password_user` = '" + t.getPassword_user() + "', `First_name` = '" + t.getFirst_name() + "', `Last_name` = '" + t.getLast_name() + "', `Tel` = '" + t.getTel() + "', `Address` = '" + t.getAddress() + "', `Blood_type` = '" + t.getBlood_type() + "'"
                + "WHERE `Id_user` = " + t.getId_user();
        ste.executeUpdate(updateUser);
        return ste.execute(updateUser); //check*************************************** 
    }

    @Override
    public List<Users> readAll() throws SQLException {
        List<Users> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users");
        while (rs.next()) {
            int Id_user = rs.getInt("Id_user");
            String Login_user = rs.getString("Login_user");
            String Password_user = rs.getString("Password_user");
            String First_name = rs.getString("First_name");
            String Last_name = rs.getString("Last_name");
            int Tel = rs.getInt("Tel");
            String Address = rs.getString("Address");
            String Blood_type = rs.getString("Blood_type");
            int role = rs.getInt("role");
            Users u = new Users(Id_user, Login_user, Password_user, First_name, Last_name, Tel, Address, Blood_type, role);
            arr.add(u);
        }
        return arr;
    }
    
    
    public HashMap<List<String>, List<String>> chercher(String str) throws SQLException {
        List<Users> s = readAll().stream().filter(e-> e.getFirst_name().contains(str)).collect(Collectors.toList());
        List<String> res1 = (List<String>) s.stream().map(e -> e.getFirst_name()).collect(Collectors.toList());
        List<String> res2 = (List<String>) s.stream().map(e -> e.getLast_name()).collect(Collectors.toList());
        HashMap<List<String>, List<String>> res = new HashMap<List<String>, List<String>>(){{
            put(res1 , res2);
        }};
        
        return res;
    }
    
    public List<String> searchByName(String str) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select `First_name`, `Last_name` from users where `First_name` like '%" +str+ "%' or `Last_name` like '%" +str+ "%';");
        while (rs.next()) {
            String Full_name = "" + rs.getString("First_name") + rs.getString("Last_name");
            arr.add(Full_name);
        }
        return arr;
    }
    
    
    
    public List<String> readAllLogins() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users ;");
        while (rs.next()) {
            String logins = "" + rs.getString("Login_user");
            arr.add(logins);
        }
        return arr;
    }
    
    public List<String> readAllFN() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users ;");
        while (rs.next()) {
            String logins = "" + rs.getString("First_name");
            arr.add(logins);
        }
        return arr;
    }
    
    public List<String> readAllLN() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users ;");
        while (rs.next()) {
            String logins = "" + rs.getString("Last_name");
            arr.add(logins);
        }
        return arr;
    }
    
    public List<String> readAllTels() throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from users ;");
        while (rs.next()) {
            String tels = rs.getString("Tel");
            arr.add(tels);
        }
        return arr;
    }
    
    public List<String> searchById(int Id) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select `First_name`, `Last_name` from users where `First_name` like '" +Id+ "';");
        while (rs.next()) {
            String Full_name = "" + rs.getString("First_name") + rs.getString("Last_name");
            arr.add(Full_name);
        }
        return arr;
    }
    
    public List<String> searchByTel(int Tel) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select `First_name`, `Last_name` from users where `First_name` like '%" +Tel+ "%';");
        while (rs.next()) {
            String Full_name = "" + rs.getString("First_name") + rs.getString("Last_name");
            arr.add(Full_name);
        }
        return arr;
    }
    
    public List<String> searchByBloodType(String Bt) throws SQLException {
        List<String> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select `First_name`, `Last_name` from users where `First_name` like '%" +Bt+ "%';");
        while (rs.next()) {
            String Full_name = "" + rs.getString("First_name") + rs.getString("Last_name");
            arr.add(Full_name);
        }
        return arr;
    }
    
    public List<Users> trier() throws SQLException {
        Statement stm = con.createStatement();
        String query = "select * from `users` ORDER BY First_name ASC";
        ResultSet rs = stm.executeQuery(query);
        List<Users> arr = new ArrayList<>();
        while (rs.next()) {
            
            int Id_user = rs.getInt("Id_user");
            String Login_user = rs.getString("Login_user");
            String Password_user = rs.getString("Password_user");
            String First_name = rs.getString("First_name");
            String Last_name = rs.getString("Last_name");
            int Tel = rs.getInt("Tel");
            String Address = rs.getString("Address");
            String Blood_type = rs.getString("Blood_type");
            int  role = rs.getInt("role");
            Users u = new Users(Id_user, Login_user, Password_user, First_name, Last_name, Tel, Address, Blood_type, role);
            
            arr.add(u);
        }
     return arr;
    }
    
    public boolean EmailExists(String Email) throws SQLException {
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select `Login_user` from users where `Login_user` like '" + Email + "';");
        if (rs == null)
            return false;
        return true;
    }
    
   public void SignIn(String mail, String password) throws SQLException {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("SELECT * FROM users WHERE  Login_user = '" + mail + "' and Password_user = '" + password + "'" );
            
            if (rs != null) {
                while (rs.next()) {       
                    currentUser.setId_user(rs.getInt("Id_user"));
                    currentUser.setLogin_user(rs.getString("Login_user"));
                    currentUser.setPassword_user(rs.getString("Password_user"));
                    currentUser.setFirst_name(rs.getString("First_name"));
                    currentUser.setLast_name(rs.getString("Last_name"));
                    currentUser.setTel(rs.getInt("Tel"));
                    currentUser.setAddress(rs.getString("Address"));
                    currentUser.setBlood_type(rs.getString("Blood_type"));
                }
         }   
    }
   public void SignInWithCode(String mail, String code) throws SQLException {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery("SELECT * FROM users WHERE  Login_user = '" + mail + "' and redeem = '" + code + "'" );
            
            if (rs != null) {
                while (rs.next()) {       
                    currentUser.setId_user(rs.getInt("Id_user"));
                    currentUser.setLogin_user(rs.getString("Login_user"));
                    currentUser.setPassword_user(rs.getString("Password_user"));
                    currentUser.setFirst_name(rs.getString("First_name"));
                    currentUser.setLast_name(rs.getString("Last_name"));
                    currentUser.setTel(rs.getInt("Tel"));
                    currentUser.setAddress(rs.getString("Address"));
                    currentUser.setBlood_type(rs.getString("Blood_type"));
                    currentUser.setRole(rs.getInt("role"));
                }
         }   
    }
   
   public void SignOut() throws SQLException {
        currentUser.setId_user(0);
        currentUser.setLogin_user("");
        currentUser.setPassword_user("");
        currentUser.setFirst_name("");
        currentUser.setLast_name("");
        currentUser.setTel(0);
        currentUser.setAddress("");
        currentUser.setBlood_type("");
    }
   
}
