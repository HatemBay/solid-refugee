/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.Action;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tarek
 */
public interface IServiceAction {
    public void addAction(Action p) throws SQLException;

    public List<Action> getActions() throws SQLException;
    
    public List<Action> TrierActions(int i) throws SQLException;

    public Action getById(int id) throws SQLException;

    public void deleteAction(Action p) throws SQLException;

    public void deleteAction(int id) throws SQLException;

    public void updateAction(Action p) throws SQLException;  
    
    public List<Action> SearchActions(String character) throws SQLException;
    
}
