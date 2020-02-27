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
public class Association2 {
    private int Id_Association;
    private String Nom_Association, Email_Association, Password_Association, Address_Association, Type_Association, Object_Association, Description_Association;

    public Association2(int Id_Association, String Nom_Association, String Email_Association, String Password_Association, String Address_Association, String Type_Association, String Object_Association, String Description_Association) {
        this.Id_Association = Id_Association;
        this.Nom_Association = Nom_Association;
        this.Email_Association = Email_Association;
        this.Password_Association = Password_Association;
        this.Address_Association = Address_Association;
        this.Type_Association = Type_Association;
        this.Object_Association = Object_Association;
        this.Description_Association = Description_Association;
    }

    public Association2(String Nom_Association, String Email_Association, String Password_Association, String Address_Association, String Type_Association, String Object_Association, String Description_Association) {
        this.Nom_Association = Nom_Association;
        this.Email_Association = Email_Association;
        this.Password_Association = Password_Association;
        this.Address_Association = Address_Association;
        this.Type_Association = Type_Association;
        this.Object_Association = Object_Association;
        this.Description_Association = Description_Association;
    }

    public Association2(int Id_Association) {
        this.Id_Association = Id_Association;
    }

    public int getId_Association() {
        return Id_Association;
    }

    public void setId_Association(int Id_Association) {
        this.Id_Association = Id_Association;
    }

    public String getNom_Association() {
        return Nom_Association;
    }

    public void setNom_Association(String Nom_Association) {
        this.Nom_Association = Nom_Association;
    }

    public String getEmail_Association() {
        return Email_Association;
    }

    public void setEmail_Association(String Email_Association) {
        this.Email_Association = Email_Association;
    }

    public String getPassword_Association() {
        return Password_Association;
    }

    public void setPassword_Association(String Password_Association) {
        this.Password_Association = Password_Association;
    }

    public String getAddress_Association() {
        return Address_Association;
    }

    public void setAddress_Association(String Address_Association) {
        this.Address_Association = Address_Association;
    }

    public String getType_Association() {
        return Type_Association;
    }

    public void setType_Association(String Type_Association) {
        this.Type_Association = Type_Association;
    }

    public String getObject_Association() {
        return Object_Association;
    }

    public void setObject_Association(String Object_Association) {
        this.Object_Association = Object_Association;
    }

    public String getDescription_Association() {
        return Description_Association;
    }

    public void setDescription_Association(String Description_Association) {
        this.Description_Association = Description_Association;
    }

    @Override
    public String toString() {
        return "Association{" + "Id_Association=" + Id_Association + ", Nom_Association=" + Nom_Association + ", Email_Association=" + Email_Association + ", Password_Association=" + Password_Association + ", Address_Association=" + Address_Association + ", Type_Association=" + Type_Association + ", Object_Association=" + Object_Association + ", Description_Association=" + Description_Association + '}';
    }

    
}
