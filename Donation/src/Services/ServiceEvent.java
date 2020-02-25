/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Interfaces.IService;
import Uties.MyConnections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.GeoCoordinates;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siss_Ima
 */
public class ServiceEvent implements IService<Event> {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet results;
    private static ServiceEvent instance;

    public ServiceEvent() {
        connection = MyConnections.getInstance().getConnection();
    }

    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
        }
        return instance;
    }

    @Override
    public void insert(Event event) {
        try {
            String query = "INSERT INTO `donation`.`event` (`Name_ev`, `location_x`, `location_y`, `date_ev`, `Description_ev`, `Poster`, `Type_ev`, `Equipement_ev`) VALUES (?,?,?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, event.getName_ev());
            preparedStatement.setDouble(2, event.getLocation_ev().getLatitude());
            preparedStatement.setDouble(3, event.getLocation_ev().getLongitude());
            preparedStatement.setTimestamp(4, event.getDate_ev());
            preparedStatement.setString(5, event.getDescription_ev());
            preparedStatement.setString(6, event.getPoster());
            preparedStatement.setString(7, event.getType_ev());
            preparedStatement.setString(8, event.getEquipement_ev());
            preparedStatement.executeUpdate();
            
            
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
           
    }
  @Override
  public void update(Event event) {
        try {
            String query = "UPDATE `donation`.`event` SET `Name_ev` = ?, `location_x` = ?, `location_y` = ?, `date_ev` = ?, `Description_ev` = ?, `Poster` = ?, `Type_ev` = ? WHERE `Id_ev` = '" + event.getId_ev()+ "';";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, event.getName_ev());
            preparedStatement.setDouble(2, event.getLocation_ev().getLatitude());
            preparedStatement.setDouble(3, event.getLocation_ev().getLongitude());
            preparedStatement.setTimestamp(4, event.getDate_ev());
            preparedStatement.setString(5, event.getDescription_ev());
            preparedStatement.setString(6, event.getPoster());
            preparedStatement.setString(7, event.getType_ev());
            preparedStatement.executeUpdate();
            
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                
                }

    public Boolean deletei(Event t) throws SQLException {
        statement= connection.createStatement();
        String requeteRemove = "DELETE FROM `donation`.`event` WHERE Id_ev = " +t.getId_ev();
        statement.executeUpdate(requeteRemove);
        return statement.execute(requeteRemove);
    }

    @Override
    // Use UserService Toch User Intel Instead
    public List<Event> displayAll() {
        
            List<Event> ar=new ArrayList<>();
            try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from `event`");
            while (rs.next()) {
      Event event = new Event(rs.getInt("Id_ev"), rs.getString("Name_ev"), new GeoCoordinates(rs.getDouble("location_x"), rs.getDouble("location_y")), rs.getTimestamp("Date_ev"), rs.getString("Description_ev"), rs.getString("Equipement_ev"),rs.getString("Poster"), rs.getString("Type_ev"));
                
                ar.add(event);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ar;
    }   
    @Override
    public void delete(int id) {
         try {
            String query = "DELETE FROM `donation`.`event` WHERE Id_ev='"+id+"';";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
        } catch (SQLException e) {
             System.out.println(e);
        }
}
}
    
        
 
    





