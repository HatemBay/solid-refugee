/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Admin;
import com.donation.Entite.Comment;
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
public class ServiceComment implements IService<Comment> {

    private Connection con;
    private Statement ste;

    public ServiceComment() {
        con = DataBase.getInstance().getConnection();
    }
    
    @Override
    public void add(Comment t) throws SQLException {
        ste = con.createStatement();
        String addComment = "INSERT INTO `donation`.`comment` (`Id_comment`, `Text_comment`, `Id_user`, `Id_view`) "
                + "VALUES (NULL, '" + t.getText_comment() + "', '" + t.getId_user() + "', '" + t.getId_view() + "');";
        ste.executeUpdate(addComment);
    }

    @Override
    public boolean delete(Comment t) throws SQLException {
        ste = con.createStatement();
        String deleteComment = "DELETE FROM `donation`.`comment` WHERE `Id_comment` = " + t.getId_comment();
        ste.executeUpdate(deleteComment);
        return ste.execute(deleteComment); //check*************************************** 
    }

    @Override
    public boolean update(Comment t) throws SQLException {
        ste = con.createStatement();
        String updateComment = "UPDATE `donation`.`comment` SET `Text_comment` = '" + t.getText_comment() + "', `Id_user` = '" + t.getId_user() + "', `Id_view` = '" + t.getId_view() + "' " 
                + "WHERE `Id_comment` = " + t.getId_comment();
        ste.executeUpdate(updateComment);
        return ste.execute(updateComment); //check*************************************** 
    }

    @Override
    public List<Comment> readAll() throws SQLException {
        List<Comment> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from comment");
        while (rs.next()) {
            int Id_comment = rs.getInt("Id_comment");
            String Text_comment = rs.getString("Text_comment");
            int Id_user = rs.getInt("Id_user");
            int Id_view = rs.getInt("Id_view");
            Comment a = new Comment(Id_comment, Text_comment, Id_user, Id_view);
            arr.add(a);
        }
        return arr;
    }
    
}
