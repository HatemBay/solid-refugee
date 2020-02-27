/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import Entity.Action;
import Services.ServiceAction;
import Services.ServiceAssociation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class ModifyActionController implements Initializable {

    @FXML
    private AnchorPane main;
    @FXML
    private ImageView background;
    @FXML
    private TextField location;
    @FXML
    private TextField date;
    @FXML
    private TextField name;
    @FXML
    private TextArea type;
    @FXML
    private TextField tools;
    @FXML
    private PasswordField vol;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button Select_AS;
    @FXML
    private TextField search;
    @FXML
    private ComboBox<String> comboresult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image back = new Image("file:/C:/Users/Tarek/Desktop/ESPRIT/3A/Semestre2/MOBILE/Séance2/donationfx/src/uploads/background.jpg");
        background.setImage(back);
    }    

    @FXML
    private void updateAction(ActionEvent event) throws SQLException, IOException {
       Services.ServiceAction SA = new ServiceAction();
       int id = SA.getByName(comboresult.getValue()).getId_Action();
       Action a = new Action();
       a.setId_Action(id);
       a.setName_Action(name.getText());
       a.setDate_Action(date.getText());
       a.setLocation_Action(location.getText());
       a.setNbV_Action(Integer.parseInt(vol.getText()));

       SA.updateAction(a);
       AnchorPane redirect;
       redirect = FXMLLoader.load(getClass().getResource("action.fxml"));
       main.getChildren().setAll(redirect);         
               
    }

    @FXML
    private void deleteAction(ActionEvent event) throws SQLException, IOException {
       Services.ServiceAction SA = new ServiceAction();
       int id = SA.getByName(name.getText()).getId_Action();
       SA.deleteAction(id);
       AnchorPane redirect;
       redirect = FXMLLoader.load(getClass().getResource("action.fxml"));
       main.getChildren().setAll(redirect);        
    }

    @FXML
    private void fillinput(ActionEvent event) throws SQLException {
     Services.ServiceAction SA = new ServiceAction();
     name.setText(SA.getByName(comboresult.getValue()).getName_Action());  
     date.setText(SA.getByName(comboresult.getValue()).getDate_Action());
     location.setText(SA.getByName(comboresult.getValue()).getLocation_Action());
     vol.setText(""+SA.getByName(comboresult.getValue()).getNbV_Action());       
    }

    @FXML
    private void search(KeyEvent event) throws SQLException {
        Services.ServiceAction SA = new ServiceAction();
        String chara = search.getText();
        
        ArrayList<String> a = (ArrayList<String>) SA.SearchActionsNames(chara);
        ObservableList<String> obs = FXCollections.observableArrayList(a);
        comboresult.setItems(obs);          
    }
    
}
