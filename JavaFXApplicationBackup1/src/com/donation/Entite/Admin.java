/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Entite;

import java.sql.Date;

/**
 *
 * @author Hatem
 */
public class Admin {

    private int Id_admin;
    private String Login_admin, Password_admin, First_name, Last_name;
    public static String session;


    public Admin(int Id_admin, String Login_admin, String Password_admin, String First_name, String Last_name) {
        this.Id_admin = Id_admin;
        this.Login_admin = Login_admin;
        this.Password_admin = Password_admin;
        this.First_name = First_name;
        this.Last_name = Last_name;
    }

    public Admin(String Login_admin, String Password_admin, String First_name, String Last_name) {
        this.Login_admin = Login_admin;
        this.Password_admin = Password_admin;
        this.First_name = First_name;
        this.Last_name = Last_name;
    }

    public Admin(int Id_admin) {
        this.Id_admin = Id_admin;
    }

    public int getId_admin() {
        return Id_admin;
    }

    public void setId_admin(int Id_admin) {
        this.Id_admin = Id_admin;
    }

    public String getLogin_admin() {
        return Login_admin;
    }

    public void setLogin_admin(String Login_admin) {
        this.Login_admin = Login_admin;
    }

    public String getPassword_admin() {
        return Password_admin;
    }

    public void setPassword_admin(String Password_admin) {
        this.Password_admin = Password_admin;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public static String getSession() {
        return session;
    }

    public static void setSession(String session) {
        Admin.session = session;
    }

    @Override
    public String toString() {
        return "Admin{" + "Id_admin=" + Id_admin + ", Login_admin=" + Login_admin + ", Password_admin=" + Password_admin + ", First_name=" + First_name + ", Last_name=" + Last_name + '}';
    }

    

}
