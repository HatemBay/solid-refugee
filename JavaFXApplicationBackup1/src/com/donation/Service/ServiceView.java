/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donation.Service;

import com.donation.Entite.Admin;
import com.donation.Entite.View;
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
public class ServiceView implements IService<View> {

    private Connection con;
    private Statement ste;

    public ServiceView() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void add(View t) throws SQLException {
        ste = con.createStatement();
        String addView = "INSERT INTO `donation`.`view` (`Id_view`, `Id_user`, `Text`) "
                + "VALUES (NULL, '" + t.getId_user() + "', '" + t.getText() + "');";
        ste.executeUpdate(addView);
    }

    @Override
    public boolean delete(View t) throws SQLException {
        ste = con.createStatement();
        String deleteView = "DELETE FROM `donation`.`view` WHERE `Id_view` = " + t.getId_view();
        ste.executeUpdate(deleteView);
        return ste.execute(deleteView); //check*************************************** 
    }

    @Override
    public boolean update(View t) throws SQLException {
        ste = con.createStatement();
        String updateView = "UPDATE `donation`.`view` SET `Id_user` = '" + t.getId_user() + "', `Text` = '" + t.getText() + "'" 
                + "WHERE `Id_view` = " + t.getId_view();
        ste.executeUpdate(updateView);
        return ste.execute(updateView); //check*************************************** 
    }

    @Override
    public List<View> readAll() throws SQLException {
        List<View> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from view");
        while (rs.next()) {
            int Id_view = rs.getInt("Id_view");
            int Id_user = rs.getInt("Id_user");
            String Text = rs.getString("Text");
            View v = new View(Id_view, Id_user, Text);
            arr.add(v);
        }
        return arr;
    }

}
