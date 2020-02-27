/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.CurrentUser;
import Entities.User;

import Services.Cruduser;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 *
 * @author Oussama
 */
public class LoginController implements Initializable{
 @FXML
    public TextField txtusername;

    @FXML
    public PasswordField txtpassword;

    @FXML
    private Button idmotdepasseoublier;

    @FXML
    private Button idfermer;

    @FXML
    private Button idconnexion;

    @FXML
    private Button inscription;
Cruduser c=new Cruduser();

public static int iduser=0;
    @FXML
    void Connexion(ActionEvent event) {
       
   
        if(txtusername.getText().equals("") )
        {
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer votre username  ");
 
              alert.showAndWait();
        }
        if( txtpassword.getText().equals(""))
        {
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("Entrer votre password ");
 
              alert.showAndWait();
            
        }
         String pass=GFG.encryptThisString(txtpassword.getText());
        if(c.Authentifier(txtusername.getText(),pass)==true)
        {
           if(c.getrole(txtusername.getText(), pass).equals("a:1:{i:0;s:10:\"ROLE_AGENT\";}"))
            {
                iduser=c.getid200(txtusername.getText(),pass);
                   CurrentUser cr =new CurrentUser();  
                cr.setId_user(iduser);
              try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Backendcollect.fxml"));
            
            Parent root1 = loader.load();
             
            
              
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }    
            }
        else
            if(c.getrole(txtusername.getText(),pass).equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
            {
                iduser=c.getid200(txtusername.getText(),pass);
                   CurrentUser cr =new CurrentUser();  
                cr.setId_user(iduser);
              try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Admin.fxml"));
            
            Parent root1 = loader.load();
               Cruduser cr11 =new Cruduser(); 
             pidev3.PIDEV3.user_front = cr11.getUser(iduser);  
            
              
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }    
            }
           
        else
                  if(c.getrole(txtusername.getText(), pass).equals("a:0:{}"))
            {
                iduser=c.getid200(txtusername.getText(),pass);
                   CurrentUser cr =new CurrentUser();  
                cr.setId_user(iduser);
              try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Front.fxml"));
            
            Parent root1 = loader.load();
               Cruduser cr11 =new Cruduser(); 
             pidev3.PIDEV3.user_front = cr11.getUser(iduser);  
            
              
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }    
            }
        else
        {
                  Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Alert");
              alert.setHeaderText("Resultat:");
              alert.setContentText("username ou passord incorrect");
 
              alert.showAndWait();
            System.out.println("erreur");
        }
        
      
        
      
        

    }
    }
    @FXML
    void Fermer(ActionEvent event) {
           Window window = idfermer.getScene().getWindow(); 

     if (window instanceof Stage){ 
      ((Stage) window).close(); 
     } 

    }

    @FXML
    void Motdepasseoublier(ActionEvent event) {

    }

    @FXML
    void inscription(ActionEvent event) {
 try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Inscription.fxml"));
           Parent root1 = loader.load();
              ((Node)(event.getSource())).getScene().getWindow().hide();
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           
    }
    
   
    
}
