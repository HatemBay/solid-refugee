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
public class Appel_don {
    private int id;
    private int user_id;
    private String image;
    private String description;
    private String nom;
    private String category;

     public Appel_don(int id, int user_id, String nom,String image, String category ,String description) {
          this.id = id;
        this.user_id = user_id;
        this.image = image;
        this.description = description;
        this.nom = nom;
        this.category = category;
    }

    public Appel_don() {
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Appel_don{" + "id=" + id + ", user_id=" + user_id + ", image=" + image + ", description=" + description + ", nom=" + nom + ", category=" + category + '}';
    }
    
    
}
