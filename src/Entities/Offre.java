/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author OusSama
 */
public class Offre {
    private int id;
    private String type;
    private String contact;
    private String state;
        private int id_user;

    public Offre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Offre(String type, String contact, String state, int id_user) {
        this.type = type;
        this.contact = contact;
        this.state = state;
        this.id_user = id_user;
    }

    public Offre(int id, String type, String contact, String state, int id_user) {
        this.id = id;
        this.type = type;
        this.contact = contact;
        this.state = state;
        this.id_user = id_user;
    }


    public Offre(int id, String type, String contact, String state) {
        this.id = id;
        this.type = type;
        this.contact = contact;
        this.state = state;
    }

    public Offre(String type, String contact, String state) {
        this.type = type;
        this.contact = contact;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", type=" + type + ", contact=" + contact + ", state=" + state + '}';
    }
    
}
