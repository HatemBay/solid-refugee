/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Oussama
 */
public class Inscription {
    private int id_inscription;
    private int formation_id;
    private String nom_ins;
    private String date_formation;
    private String nom_formation;
    
    public Inscription()
    {
        
    }

 public Inscription(int formation_id,String nom_ins,String date_formation,String nom_formation)
    {
       
        this.formation_id=formation_id;
        this.nom_ins=nom_ins;
        this.date_formation=date_formation;
        this.nom_formation=nom_formation;
        
    }
public Inscription(int formation_id,String nom_ins)
    {
       
        this.formation_id=formation_id;
        this.nom_ins=nom_ins;
        
        
    }

 
    public Inscription(int formation_id,String nom_ins,String date)
    {
       
        this.formation_id=formation_id;
        this.nom_ins=nom_ins;
        this.date_formation=date;
      
 
    }
    
    public int getId_inscription() {
        return id_inscription;
    }

   
    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

   
    public int getFormation_id() {
        return formation_id;
    }

  
    public void setFormation_id(int formation_id) {
        this.formation_id = formation_id;
    }

  
    public String getNom_ins() {
        return nom_ins;
    }

   
    public void setNom_ins(String nom_ins) {
        this.nom_ins = nom_ins;
    }

   
    public String getDate_formation() {
        return date_formation;
    }

  
    public void setDate_formation(String date_formation) {
        this.date_formation = date_formation;
    }


    public String getNom_formation() {
        return nom_formation;
    }

  
    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }
    
}
