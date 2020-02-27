/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Oussama
 */
public class CurrentUser {
   private  static int id_user; 
   private static int AnchorPaneCondition=0; 
private static AnchorPane anchor;  
private static int id_produit_postulation; 
private static int choiceMarche=0; 

    public static int getChoiceMarche() {
        return choiceMarche;
    }

    public static void setChoiceMarche(int choiceMarche) {
        CurrentUser.choiceMarche = choiceMarche;
    }
    public static int getId_produit_postulation() {
        return id_produit_postulation;
    }

    public static void setId_produit_postulation(int id_produit_postulation) {
        CurrentUser.id_produit_postulation = id_produit_postulation;
    }
private static int PropositionsController=0;  
    public static AnchorPane getAnchor() {
        return anchor;
    }

    public static int getPropositionsController() {
        return PropositionsController;
    }

    public static void setPropositionsController(int PropositionsController) {
        CurrentUser.PropositionsController = PropositionsController;
    }

    public static void setAnchor(AnchorPane anchor) {
        CurrentUser.anchor = anchor;
    } 
    
    public static int getAnchorPaneCondition() {
        return AnchorPaneCondition;
    }

    public static void setAnchorPaneCondition(int AnchorPaneCondition) {
        CurrentUser.AnchorPaneCondition = AnchorPaneCondition;
    }

    public static int getId_user() {
        return id_user;
    }

    public static void setId_user(int id_user) {
        CurrentUser.id_user = id_user;
    }

    public CurrentUser() {
    }
   
}
