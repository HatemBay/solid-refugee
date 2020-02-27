/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import Entity.Action;
import Services.ServiceAction;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class ActionController implements Initializable {

    @FXML
    private AnchorPane affiche;
    @FXML
    private TableView<Action> table;

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
    @FXML
    private TableColumn<Action, String> name;
    @FXML
    private TableColumn<Action, String> date;
    @FXML
    private TableColumn<Action, String> location;
    @FXML
    private TableColumn<Action, Integer> vol;
    @FXML
    private TableColumn<Action, Enum> type;    
    @FXML
    private TableColumn<Action, Enum> tools;
    @FXML
    private Button open_association;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.ServiceAction SL = new ServiceAction();
        ObservableList<String> options = FXCollections.observableArrayList(
                "Date",
                "Name"
        );
        sortcombo.getItems().addAll(options);        
        
        name.setCellValueFactory(new PropertyValueFactory<Action, String>("Name_Action"));
        date.setCellValueFactory(new PropertyValueFactory<Action, String>("Date_Action"));
        location.setCellValueFactory(new PropertyValueFactory<Action, String>("Location_Action"));
        vol.setCellValueFactory(new PropertyValueFactory<Action, Integer>("NbV_Action"));
        type.setCellValueFactory(new PropertyValueFactory<Action, Enum>("TypeV_Action"));
        tools.setCellValueFactory(new PropertyValueFactory<Action,Enum>("Material_Action"));
        
        ObservableList<Action> res;
        try {
            res = FXCollections.observableArrayList(SL.getActions());
            table.setItems(res);
        } catch (SQLException ex) {
            Logger.getLogger(AssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }    

    @FXML
    private void search(KeyEvent event) throws SQLException {
        Services.ServiceAction SL = new ServiceAction();
        String chara = search.getText();
        
        ArrayList<Action> a = (ArrayList<Action>) SL.SearchActions(chara);
        ObservableList<Action> obs = FXCollections.observableArrayList(a);
        table.setItems(obs);        
    }

    @FXML
    private void sort(MouseEvent event) throws SQLException {
        if (sortcombo.getValue().equals("Date")) {
            
            Services.ServiceAction SA = new ServiceAction();
            ArrayList<Action> a = (ArrayList<Action>) SA.TrierActions(2); 
            ObservableList<Action> obs = FXCollections.observableArrayList(a);   
            table.setItems(obs);

        }else if (sortcombo.getValue().equals("Name")) {
            
            Services.ServiceAction SA = new ServiceAction();
            ArrayList<Action> a = (ArrayList<Action>) SA.TrierActions(1); 
            ObservableList<Action> obs = FXCollections.observableArrayList(a);
            table.setItems(obs);        
    }
}
    @FXML
    private void openmodifier(ActionEvent event) throws IOException {
                AnchorPane redirect;
                redirect = FXMLLoader.load(getClass().getResource("ModifyAction.fxml"));
                affiche.getChildren().setAll(redirect);        
    }
    

    @FXML
    private void opencreate(ActionEvent event) throws IOException {
                AnchorPane redirect;
                redirect = FXMLLoader.load(getClass().getResource("AjoutAction.fxml"));
                affiche.getChildren().setAll(redirect);        
    }

    @FXML
    private void open_association(ActionEvent event) throws IOException {
                AnchorPane asso;
                asso = FXMLLoader.load(getClass().getResource("association.fxml"));
                affiche.getChildren().setAll(asso);           
    }
    
}
