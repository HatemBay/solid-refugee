/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import Entity.Association;
import Services.ServiceAssociation;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AssociationController implements Initializable {
    @FXML
    private TableView<Association>table;
    private Button ajout;
    @FXML
    private AnchorPane affiche;
    @FXML
    private TableColumn<Association, String> logo;
    @FXML
    private TableColumn<Association, String> nom;
    @FXML
    private TableColumn<Association, String> goals;
    @FXML
    private TableColumn<Association, String> email;
    @FXML
    private TableColumn<Association, String> address;
    @FXML
    private TableColumn<Association,String> type;
    @FXML
    private TableColumn<Association, Timestamp> sub_date;
    @FXML
    private TableColumn<Association, String> description;
    
    public ObservableList<Association> data=FXCollections.observableArrayList();
    @FXML
    private TextField search;
    @FXML
    private ComboBox<String> sortcombo;
    @FXML
    private Button sort;
    @FXML
    private Button openupdate;
    @FXML
    private Button opencreate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.ServiceAssociation SA = new ServiceAssociation();
        ObservableList<String> options = FXCollections.observableArrayList(
                "Date",
                "Name"
        );
        sortcombo.getItems().addAll(options);

        
        nom.setCellValueFactory(new PropertyValueFactory<Association, String>("Nom_Association"));
        goals.setCellValueFactory(new PropertyValueFactory<Association, String>("Objectif_Association"));
        email.setCellValueFactory(new PropertyValueFactory<Association, String>("Email_Association"));
        address.setCellValueFactory(new PropertyValueFactory<Association, String>("Address_Association"));
        type.setCellValueFactory(new PropertyValueFactory<Association, String>("Type_Association"));
        description.setCellValueFactory(new PropertyValueFactory<Association,String>("Description_Association"));
        sub_date.setCellValueFactory(new PropertyValueFactory<Association,Timestamp>("Date_inscrit"));
        
        ObservableList<Association> res;
        try {
            res = FXCollections.observableArrayList(SA.getAssociations());
            table.setItems(res);
        } catch (SQLException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }    


    @FXML
    private void search(KeyEvent event) throws SQLException {
        Services.ServiceAssociation SA = new ServiceAssociation();
        String chara = search.getText();
        
        ArrayList<Association> a = (ArrayList<Association>) SA.SearchAssociations(chara);
        ObservableList<Association> obs = FXCollections.observableArrayList(a);
        table.setItems(obs);
    }

    @FXML
    private void sort(MouseEvent event) throws SQLException {

             
        if (sortcombo.getValue().equals("Date")) {
            
            Services.ServiceAssociation SA = new ServiceAssociation();
            ArrayList<Association> a = (ArrayList<Association>) SA.TrierAssociations(1); 
            ObservableList<Association> obs = FXCollections.observableArrayList(a);   
            table.setItems(obs);

        }else if (sortcombo.getValue().equals("Name")) {
            
            Services.ServiceAssociation SA = new ServiceAssociation();
            ArrayList<Association> a = (ArrayList<Association>) SA.TrierAssociations(2); 
            ObservableList<Association> obs = FXCollections.observableArrayList(a);
            table.setItems(obs);
}        
    }

    @FXML
    private void openmodifier(ActionEvent event) throws IOException {
                AnchorPane redirect;
                redirect = FXMLLoader.load(getClass().getResource("ModifyAssociation.fxml"));
                affiche.getChildren().setAll(redirect);           
    }

    @FXML
    private void opencreate(ActionEvent event) throws IOException {
                AnchorPane redirect;
                redirect = FXMLLoader.load(getClass().getResource("AjoutAssociation.fxml"));
                affiche.getChildren().setAll(redirect);        
    }

    

}



    
    

