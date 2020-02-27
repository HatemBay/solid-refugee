/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entity.Action;
import Interfaces.IServiceAction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MaConnection;

/**
 *
 * @author Tarek
 */
public class ServiceAction implements IServiceAction{
     Connection cnx;

    public ServiceAction() {
        cnx = MaConnection.getInstance().getConnection();
    }
 
    @Override
    public void addAction(Action a) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "INSERT INTO `action` (`Id_Action`, `Id_Association`, `Name_Action`, `Date_Action`, `Location_Action`, `NbV_Action`, `description`)"
                + "     VALUES (NULL, '"+a.getId_Association()+"', '"+a.getName_Action()+"', '"+a.getDate_Action()+"', '"+a.getLocation_Action()+"', '"+a.getNbV_Action()+"', '"+a.getDescription()+"')";
         stm.executeUpdate(query);      
    }

    public void addtypemat(int idaction ,int idtype) throws SQLException {
         Statement stm = cnx.createStatement();
         String query = "INSERT INTO `typemataction` (`id_Action`, `idTypeMat`) VALUES ('"+idaction+"','"+idtype+"')";
         stm.executeUpdate(query);      
    }    

    public void addtypevol(int idaction ,int idtype) throws SQLException {
         Statement stm = cnx.createStatement();
         String query = "INSERT INTO `typevolaction` (`id_Action`, `idTypeVol`) VALUES ('"+idaction+"','"+idtype+"')";
         stm.executeUpdate(query);      
    }

    public int getTypevolByName(String type) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `type_vol` where type= '"+type+"'";
        ResultSet rst = stm.executeQuery(query);    
        int id = 0;     
        while (rst.next()) {
            id=rst.getInt("idTypeVol");        
        }
     return id;
    } 
    
    public List<Integer> getactionbytypevol(Action a) throws SQLException{
        Statement stm = cnx.createStatement();
        String query = "select * from `typevolaction` where id_Action= '"+a.getId_Action()+"'";
        ResultSet rst = stm.executeQuery(query);   
        List<Integer> result = new ArrayList<>();
        while (rst.next()) {
            int res = 0;
            res=rst.getInt("idTypeVol"); 
            result.add(res);
        }        
    return result;    
    }
    public List<String> gettypevol(List<Integer> previousresult) throws SQLException{
        
        List<String> thisresult = new ArrayList<>();
        for (int i = 0; i < previousresult.size(); i++) {
        Statement stm = cnx.createStatement();
        String query = "select * from `type_vol` where idTypeVol= '"+previousresult.get(i)+"'";
        ResultSet rst = stm.executeQuery(query);   
            while (rst.next()) {
                String res = "";
                res=rst.getString("type"); 
                thisresult.add(res);
            }         
        }
    return thisresult;       
    }
 
    
    
    
    public List<Integer> getactionbytypemat(Action a) throws SQLException{
        Statement stm = cnx.createStatement();
        String query = "select * from `typemataction` where id_Action= '"+a.getId_Action()+"'";
        ResultSet rst = stm.executeQuery(query);   
        List<Integer> result = new ArrayList<>();
        while (rst.next()) {
            int res = 0;
            res=rst.getInt("idTypeMat"); 
            result.add(res);
        }        
    return result;    
    }
    public List<String> gettypemat(List<Integer> previousresult) throws SQLException{
        
        List<String> thisresult = new ArrayList<>();
        for (int i = 0; i < previousresult.size(); i++) {
        Statement stm = cnx.createStatement();
        String query = "select * from `type_mat` where idTypeMat= '"+previousresult.get(i)+"'";
        ResultSet rst = stm.executeQuery(query);   
            while (rst.next()) {
                String res = "";
                res=rst.getString("type"); 
                thisresult.add(res);
            }         
        }
    return thisresult;       
    }    
    
    
    
    
    
    
    
    public int getTypematByName(String type) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `type_mat` where type= '"+type+"'";
        ResultSet rst = stm.executeQuery(query);    
        int id = 0;     
        while (rst.next()) {
            id=rst.getInt("idTypeMat");        
        }
     return id;
    }    
    
    
    
    
    
    
    @Override
    public List<Action> getActions() throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `action`";
        ResultSet rst = stm.executeQuery(query);
        List<Action> Actions = new ArrayList<>();
        while (rst.next()) {
            
            Action a2 = new Action();
            a2.setId_Action(rst.getInt("Id_Action"));
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setName_Action(rst.getString("Name_Action"));
            a2.setDate_Action(rst.getString("Date_Action"));
            a2.setLocation_Action(rst.getString("Location_Action"));
            a2.setNbV_Action(rst.getInt("NbV_Action"));
            
            Actions.add(a2);
        }
     return Actions;
    }

    @Override
    public Action getById(int id) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `action` where Id_Action= '"+id+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Action a2 = new Action();
        
        while (rst.next()) {

            a2.setId_Action(rst.getInt("Id_Action"));
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setName_Action(rst.getString("Name_Action"));
            a2.setDate_Action(rst.getString("Date_Action"));
            a2.setLocation_Action(rst.getString("Location_Action"));
            a2.setNbV_Action(rst.getInt("NbV_Action"));
        
            
        }
     return a2;
    }
    public Action getByName(String name) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "select * from `action` where Name_Action= '"+name+"'";
        ResultSet rst = stm.executeQuery(query);
        
        Action a2 = new Action();
        
        while (rst.next()) {

            a2.setId_Action(rst.getInt("Id_Action"));
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setName_Action(rst.getString("Name_Action"));
            a2.setDate_Action(rst.getString("Date_Action"));
            a2.setLocation_Action(rst.getString("Location_Action"));
            a2.setNbV_Action(rst.getInt("NbV_Action"));
            
            
            
        }
     return a2;
    }
    @Override
    public void deleteAction(Action a) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM action where Id_Action= '"+a.getId_Action()+"'";
        stm.executeUpdate(query);    
    }

    @Override
    public void deleteAction(int id) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "DELETE FROM action where Id_Action= '"+id+"'";
        stm.executeUpdate(query);          
    }

    @Override
    public void updateAction(Action a) throws SQLException {
         Statement stm = cnx.createStatement();
        String query = "UPDATE action SET Name_Action = '"+a.getName_Action()+"',Date_Action= '"+a.getDate_Action()+"',Location_Action= '"+a.getLocation_Action()+"', NbV_Action='"+a.getNbV_Action()+"' WHERE Id_Action = '"+a.getId_Action()+"'";
        stm.executeUpdate(query); 
    }
    
    @Override
    public List<Action> TrierActions(int i) throws SQLException {
        Statement stm = cnx.createStatement();
        String query = "";
        if (i==1) {
          query = "select * from `action` ORDER BY Name_Action ASC";  
        }else if (i==2) {
           query = "select * from `action` ORDER BY Date_Action ASC"; 
        }

        ResultSet rst = stm.executeQuery(query);
        List<Action> Actions = new ArrayList<>();
        while (rst.next()) {
            
            Action a2 = new Action();
            a2.setId_Action(rst.getInt("Id_Action"));
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setName_Action(rst.getString("Name_Action"));
            a2.setDate_Action(rst.getString("Date_Action"));
            a2.setLocation_Action(rst.getString("Location_Action"));
            a2.setNbV_Action(rst.getInt("NbV_Action"));
            
            Actions.add(a2);
        }
     return Actions;
    }
    @Override
    public List<Action> SearchActions(String character) throws SQLException  {
        Statement stm = cnx.createStatement();
        String req="select * from action where Name_Action  LIKE '%"+character+"%'" ;
        ResultSet rst = stm.executeQuery(req);
        List<Action> actions = new ArrayList<>();
        while (rst.next()) {
            Action a2 = new Action();
            a2.setId_Action(rst.getInt("Id_Action"));
            a2.setId_Association(rst.getInt("Id_Association"));
            a2.setName_Action(rst.getString("Name_Action"));
            a2.setDate_Action(rst.getString("Date_Action"));
            a2.setLocation_Action(rst.getString("Location_Action"));
            a2.setNbV_Action(rst.getInt("NbV_Action"));
            
            actions.add(a2);
        }
     return actions;
    }
    public List<String> SearchActionsNames(String character) throws SQLException {
       Statement stm = cnx.createStatement();
        String req="select * from action where Name_Action  LIKE '%"+character+"%'" ;
        ResultSet rst = stm.executeQuery(req);
        List<String> actions = new ArrayList<>();
        while (rst.next()) {
            String a2 = "";
            a2=rst.getString("Name_Action");
            actions.add(a2);
        }
     return actions;
    }
    
}
