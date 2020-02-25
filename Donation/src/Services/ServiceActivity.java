/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Activity;
import Interfaces.IService;
import Uties.MyConnections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siss_Ima
 */
public class ServiceActivity implements IService<Activity> {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet results;
    private static ServiceActivity instance;

    public ServiceActivity() {
        connection = MyConnections.getInstance().getConnection();
    }

    public static ServiceActivity getInstance() {
        if (instance == null) {
            instance = new ServiceActivity();
        }
        return instance;
    }

    @Override
    public void insert(Activity activity) {
        try {
            String query = "INSERT INTO `donation`.`activity`(`Name_ac`, `Duration`, `Description_ac`, `Type_ac`) VALUES (?,?,?,?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, activity.getName_ac());
            preparedStatement.setFloat(2, activity.getDuration());
            preparedStatement.setString(3, activity.getDescription_ac());
            preparedStatement.setString(4, activity.getType_ac());
            preparedStatement.executeUpdate();
            
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
           
    }
  @Override
  public void update(Activity activity) {
        try {
            String query = "UPDATE `donation`.`activity` SET `Name_ac` = ?, Duration = ?, Description_ac = ?, Type_ac = ? WHERE Id_ac = '" +activity.getId_ac()+ "';";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, activity.getName_ac());
            preparedStatement.setFloat(2, activity.getDuration());
            preparedStatement.setString(3, activity.getDescription_ac());
            preparedStatement.setString(4, activity.getType_ac());
           
            preparedStatement.executeUpdate();
            
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                
                }
  @Override
  public void delete(int id) {
         try {
            String query = "DELETE FROM `donation`.`activity` WHERE `Id_ac`='"+id+"';";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch (SQLException e) {
             System.out.println(e);
        }
}
    
    @Override
    // Use UserService Toch User Intel Instead
    public List<Activity> displayAll() {
        
            List<Activity> ar=new ArrayList<>();
            try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from activity");
            while (rs.next()) {
                
                Activity t = new Activity(
                        rs.getString("Name_ac"), rs.getInt("Duration"), rs.getString("Description_ac"), rs.getString("Type_ac"));
                
                
                ar.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ar;
    }           
        
    }