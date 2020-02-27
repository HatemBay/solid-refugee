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
public class Image {
    private int Id_image,Id_view;
    private String Name;

    public Image(int Id_image, int Id_view, String Name) {
        this.Id_image = Id_image;
        this.Id_view = Id_view;
        this.Name = Name;
    }

    public Image(int Id_view, String Name) {
        this.Id_view = Id_view;
        this.Name = Name;
    }

    public Image(int Id_image) {
        this.Id_image = Id_image;
    }

    public int getId_image() {
        return Id_image;
    }

    public void setId_image(int Id_image) {
        this.Id_image = Id_image;
    }

    public int getId_view() {
        return Id_view;
    }

    public void setId_view(int Id_view) {
        this.Id_view = Id_view;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Image{" + "Id_image=" + Id_image + ", Id_view=" + Id_view + ", Name=" + Name + '}';
    }

    
}
