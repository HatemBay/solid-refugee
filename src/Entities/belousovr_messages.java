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
public class belousovr_messages {
    private int id;  
    private int idDon;  
    private int author_id; 
    private int addressee_id; 
    private String messageText ;  
    private int reading;  

    public belousovr_messages() {
  
    }

    public int getIdDon() {
        return idDon;
    }

    public belousovr_messages(int id, int idDon, int author_id, int addressee_id, String messageText, int reading) {
        this.id = id;
        this.idDon = idDon;
        this.author_id = author_id;
        this.addressee_id = addressee_id;
        this.messageText = messageText;
        this.reading = reading;
    }

    public void setIdDon(int idDon) {
        this.idDon = idDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public belousovr_messages(int id, int author_id, int addressee_id, String messageText, int reading) {
        this.id = id;
        this.author_id = author_id;
        this.addressee_id = addressee_id;
        this.messageText = messageText;
        this.reading = reading;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getAddressee_id() {
        return addressee_id;
    }

    public void setAddressee_id(int addressee_id) {
        this.addressee_id = addressee_id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }
    
}
