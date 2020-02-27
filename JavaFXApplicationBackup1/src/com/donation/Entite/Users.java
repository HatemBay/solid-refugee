/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Entite;

/**
 *
 * @author Hatem
 */
public class Users {

    private int Id_user;
    private String Login_user, Password_user, First_name, Last_name;
    private int Tel;
    private String Address, Blood_type;
    private int role;

    public Users() {
    }

    public Users(int Id_user, String Login_user, String Password_user, String First_name, String Last_name, int Tel, String Address, String Blood_type, int role) {
        this.Id_user = Id_user;
        this.Login_user = Login_user;
        this.Password_user = Password_user;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Tel = Tel;
        this.Address = Address;
        this.Blood_type = Blood_type;
        this.role = role;
    }

    public Users(String Login_user, String Password_user, String First_name, String Last_name, int Tel, String Address, String Blood_type, int role) {
        this.Login_user = Login_user;
        this.Password_user = Password_user;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Tel = Tel;
        this.Address = Address;
        this.Blood_type = Blood_type;
        this.role = role;
    }

    public Users(String Login_user, String Password_user, String First_name, String Last_name, int Tel, String Address, String Blood_type) {
        this.Login_user = Login_user;
        this.Password_user = Password_user;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Tel = Tel;
        this.Address = Address;
        this.Blood_type = Blood_type;
    }
    

    public Users(int Id_user) {
        this.Id_user = Id_user;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public String getLogin_user() {
        return Login_user;
    }

    public void setLogin_user(String Login_user) {
        this.Login_user = Login_user;
    }

    public String getPassword_user() {
        return Password_user;
    }

    public void setPassword_user(String Password_user) {
        this.Password_user = Password_user;
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

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBlood_type() {
        return Blood_type;
    }

    public void setBlood_type(String Blood_type) {
        this.Blood_type = Blood_type;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "Id_user=" + Id_user + ", Login_user=" + Login_user + ", Password_user=" + Password_user + ", First_name=" + First_name + ", Last_name=" + Last_name + ", Tel=" + Tel + ", Address=" + Address + ", Blood_type=" + Blood_type + ", role=" + role + '}';
    }

    
    



}
