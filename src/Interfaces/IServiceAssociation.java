/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import java.sql.SQLException;
import java.util.List;
import Entity.Association;

/**
 *
 * @author tarek
 */
public interface IServiceAssociation {
    
    public void addAssociation(Association p) throws SQLException;

    public List<Association> getAssociations() throws SQLException;
    
    public List<Association> TrierAssociations(int i) throws SQLException;

    public Association getById(int id) throws SQLException;

    public void deleteAssociation(Association p) throws SQLException;

    public void deleteAssociation(int id) throws SQLException;

    public void updateAssociation(Association p) throws SQLException;   
    
    public List<Association> SearchAssociations(String character) throws SQLException;
    
    public List<String> SearchAssociationsNames(String character) throws SQLException;
    
    
    
}
