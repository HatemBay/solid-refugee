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
public class User {
    private int id;
    private String username;
    private String mail;
    private String password;
    private String role;
    private String nom;
    private String email; 
    private int jeton; 

       public User(int id ,  String username,String mail,String password,String role)
    {
       
        this.id=id;
        this.username=username;
        this.mail=mail;
        this.password=password;
        this.role=role;
    }
    public String getEmail() {
        return email;
    }

    public int getJeton() {
        return jeton;
    }

    public User(int id, String username, String mail, String password, String role, int jeton) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.role = role;
        this.jeton = jeton;
    }

    public void setJeton(int jeton) {
        this.jeton = jeton;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   public User(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    private String prenom;

    public User(int id, String nom, String email, String prenom) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.prenom = prenom;
    }
    
    public User(String username,String mail,String password,String role)
    {
       
        this.username=username;
        this.mail=mail;
        this.password=password;
        this.role=role;
    }
    public User()
    {
        
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

   
    
    public void setId(int id) {
        this.id = id;
    }

  
    
    public String getUsername() {
        return username;
    }

   
    
    public void setUsername(String username) {
        this.username = username;
    }

  
    
    public String getMail() {
        return mail;
    }

  
    
    public void setMail(String mail) {
        this.mail = mail;
    }

   
    
    public String getPassword() {
        return password;
    }

  
    
    public void setPassword(String password) {
        this.password = password;
    }

   
    
    public String getRole() {
        return role;
    }

   
    
    public void setRole(String role) {
        this.role = role;
    }
    
    
   
}
