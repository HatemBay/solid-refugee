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
public class View {

    private int Id_view, Id_user;
    private String Text;

    public View(int Id_user, String Text) {
        this.Id_user = Id_user;
        this.Text = Text;
    }

    public View(int Id_view, int Id_user, String Text) {
        this.Id_view = Id_view;
        this.Id_user = Id_user;
        this.Text = Text;
    }

    public View(int Id_view) {
        this.Id_view = Id_view;
    }

    public int getId_view() {
        return Id_view;
    }

    public void setId_view(int Id_view) {
        this.Id_view = Id_view;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    @Override
    public String toString() {
        return "View{" + "Id_view=" + Id_view + ", Id_user=" + Id_user + ", Text=" + Text + '}';
    }

}
