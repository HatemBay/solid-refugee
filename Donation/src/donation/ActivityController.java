/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donation;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Siss_Ima
 */
public class ActivityController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField t1;
    @FXML
    private TextField t;
    @FXML
    private Button b;
    @FXML
    private ComboBox<?> category;
    @FXML
    private TextArea yo;
    @FXML
    private Button b3;
    @FXML
    private Button bb;

  
  
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void OnSubmit(ActionEvent event) {
    }

    @FXML
    private void Onreturn(ActionEvent event) throws IOException {
     
    }

    @FXML
    private void OnClose(ActionEvent event) {

    }
    
}
