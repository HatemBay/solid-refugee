/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import Entity.Association;
import Services.ServiceAssociation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class ModifyAssociationController implements Initializable {

    @FXML
    private AnchorPane main;
    @FXML
    private ImageView background;
    @FXML
    private TextField email;
    @FXML
    private TextField objectif;
    @FXML
    private TextField name;
    @FXML
    private TextArea address;
    @FXML
    private TextField type;
    @FXML
    private TextArea about;
    @FXML
    private TextField logo;
    @FXML
    private Button browse;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm;
    @FXML
    private TextField search;
    @FXML
    private ComboBox<String> comboresult;
    @FXML
    private Button Select_AS;
    @FXML
    private Button update;
    @FXML
    private Button delete;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image back = new Image("file:/C:/Users/Tarek/Desktop/ESPRIT/3A/Semestre2/MOBILE/Séance2/donationfx/src/uploads/background.jpg");
        background.setImage(back);
        browse.setOnMouseClicked((MouseEvent e)->{
            
        final FileChooser fileChooser = new FileChooser();
        final Stage stage = null;

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            logo.setText(file.toURI().toString());
        }
        
        });        
    }    

    @FXML
    private void search(KeyEvent event) throws SQLException {
        Services.ServiceAssociation SA = new ServiceAssociation();
        String chara = search.getText();
        
        ArrayList<String> a = (ArrayList<String>) SA.SearchAssociationsNames(chara);
        ObservableList<String> obs = FXCollections.observableArrayList(a);
        comboresult.setItems(obs);        
    }

    @FXML
    private void fillinput(ActionEvent event) throws SQLException {

     Services.ServiceAssociation SA = new ServiceAssociation();
     name.setText(SA.getByName(comboresult.getValue()).getNom_Association());   
     objectif.setText(SA.getByName(comboresult.getValue()).getObjectif_Association());   
     email.setText(SA.getByName(comboresult.getValue()).getEmail_Association());   
     password.setText(SA.getByName(comboresult.getValue()).getPassword_Association());   
     address.setText(SA.getByName(comboresult.getValue()).getAddress_Association());   
     type.setText(SA.getByName(comboresult.getValue()).getType_Association());   
     about.setText(SA.getByName(comboresult.getValue()).getDescription_Association());   
     logo.setText(SA.getByName(comboresult.getValue()).getLogo_Association());   
    }

    @FXML
    private void updateAction(ActionEvent event) throws SQLException, IOException {
       Services.ServiceAssociation SA = new ServiceAssociation();
       int id = SA.getByName(comboresult.getValue()).getId_Association();
       Association a = new Association();
       a.setId_Association(id);
       a.setNom_Association(name.getText());
       a.setObjectif_Association(objectif.getText());
       a.setEmail_Association(email.getText());
        if (password.getText().equals(confirm.getText())) {
            a.setPassword_Association(password.getText());
        }else
            System.out.println("verifiez les parametres");
       a.setAddress_Association(address.getText());
       a.setType_Association(type.getText());
       a.setDescription_Association(about.getText());
       a.setLogo_Association(logo.getText());

       SA.updateAssociation(a);
       AnchorPane redirect;
       redirect = FXMLLoader.load(getClass().getResource("association.fxml"));
       main.getChildren().setAll(redirect);         
       
    }

    @FXML
    private void deleteAction(ActionEvent event) throws SQLException, IOException {
       Services.ServiceAssociation SA = new ServiceAssociation();
       int id = SA.getByName(name.getText()).getId_Association();
       SA.deleteAssociation(id);
       AnchorPane redirect;
       redirect = FXMLLoader.load(getClass().getResource("association.fxml"));
       main.getChildren().setAll(redirect); 
    }

    
}


