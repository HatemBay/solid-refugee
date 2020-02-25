/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Timestamp;



/*
 *
 * @author Siss_Ima
 */
public class Event {
    private int Id_ev;
   
    private String Name_ev;
    private GeoCoordinates Location_ev;   
    private Timestamp Date_ev;
    private String Description_ev;
    private String Equipement_ev;
    private String Poster;
    private String Type_ev;

    public Event(int Id_ev, String Name_ev, GeoCoordinates Location_ev, Timestamp Date_ev, String Description_ev, String Equipement_ev, String Poster, String Type_ev) {
        this.Id_ev = Id_ev;
        this.Name_ev = Name_ev;
        this.Location_ev = Location_ev;
        this.Date_ev = Date_ev;
        this.Description_ev = Description_ev;
        this.Equipement_ev = Equipement_ev;
        this.Poster = Poster;
        this.Type_ev = Type_ev;
    }
    
    public Event() {
    }

    public Event(int Id_ev, String Name_ev, Timestamp Date_ev, String Description_ev, String Equipement_ev, String Poster, String Type_ev) {
        this.Id_ev = Id_ev;
        this.Name_ev = Name_ev;
        this.Date_ev = Date_ev;
        this.Description_ev = Description_ev;
        this.Equipement_ev = Equipement_ev;
        this.Poster = Poster;
        this.Type_ev = Type_ev;
    }

   

    public Event(String Name_ev, GeoCoordinates Location_ev, Timestamp Date_ev, String Description_ev, String Equipement_ev, String Poster, String Type_ev) {
        this.Name_ev = Name_ev;
        this.Location_ev = Location_ev;
        this.Date_ev = Date_ev;
        this.Description_ev = Description_ev;
        this.Equipement_ev = Equipement_ev;
        this.Poster = Poster;
        this.Type_ev = Type_ev;
    }

    public int getId_ev() {
        return Id_ev;
    }

   

    public String getName_ev() {
        return Name_ev;
    }

    public GeoCoordinates getLocation_ev() {
        return Location_ev;
    }

    public Timestamp getDate_ev() {
        return Date_ev;
    }

    public String getDescription_ev() {
        return Description_ev;
    }

    public String getEquipement_ev() {
        return Equipement_ev;
    }

    public String getPoster() {
        return Poster;
    }

    public String getType_ev() {
        return Type_ev;
    }

    public void setId_ev(int Id_ev) {
        this.Id_ev = Id_ev;
    }

  

    public void setName_ev(String Name_ev) {
        this.Name_ev = Name_ev;
    }

    

    public void setLocation_ev(GeoCoordinates Location_ev) {
        this.Location_ev = Location_ev;
    }

    public void setDate_ev(Timestamp Date_ev) {
        this.Date_ev = Date_ev;
    }

    public void setDescription_ev(String Description_ev) {
        this.Description_ev = Description_ev;
    }

    public void setEquipement_ev(String Equipement_ev) {
        this.Equipement_ev = Equipement_ev;
    }

    public void setPoster(String Poster) {
        this.Poster = Poster;
    }

    public void setType_ev(String Type_ev) {
        this.Type_ev = Type_ev;
    }
    
@Override
    public String toString() {
        return "Event{" + "Id_ev=" + Id_ev + ", Name_ev=" + Name_ev + ", Location_ev=" + Location_ev + ", Date_ev=" + Date_ev + ", Description_ev=" + Description_ev + ", Equipement_ev=" + Equipement_ev + ", Poster=" + Poster + ", Type_ev=" + Type_ev + '}';
    }
}