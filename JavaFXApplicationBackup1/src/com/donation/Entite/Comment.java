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
public class Comment {

    private int Id_comment;
    private String Text_comment;
    private int Id_user, Id_view;

    public Comment(String Text_comment, int Id_user, int Id_view) {
        this.Text_comment = Text_comment;
        this.Id_user = Id_user;
        this.Id_view = Id_view;
    }

    public Comment(int Id_comment, String Text_comment, int Id_user, int Id_view) {
        this.Id_comment = Id_comment;
        this.Text_comment = Text_comment;
        this.Id_user = Id_user;
        this.Id_view = Id_view;
    }

    public Comment(int Id_comment) {
        this.Id_comment = Id_comment;
    }

    public int getId_comment() {
        return Id_comment;
    }

    public void setId_comment(int Id_comment) {
        this.Id_comment = Id_comment;
    }

    public String getText_comment() {
        return Text_comment;
    }

    public void setText_comment(String Text_comment) {
        this.Text_comment = Text_comment;
    }

    public int getId_user() {
        return Id_user;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public int getId_view() {
        return Id_view;
    }

    public void setId_view(int Id_view) {
        this.Id_view = Id_view;
    }

    @Override
    public String toString() {
        return "Comment{" + "Id_comment=" + Id_comment + ", Text_comment=" + Text_comment + ", Id_user=" + Id_user + ", Id_view=" + Id_view + '}';
    }

}
