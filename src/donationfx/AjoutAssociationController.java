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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AjoutAssociationController implements Initializable {

    @FXML
    private TextField objectif;
    @FXML
    private TextField name;
    @FXML
    private Button add;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm;
    @FXML
    private TextField email;
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
    private ImageView background;
    @FXML
    private AnchorPane main;

    /**
     * Initializes the controller class.
     */
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
    private void addAction(ActionEvent event) throws IOException {
        Services.ServiceAssociation SA = new ServiceAssociation();
        
        Association a1 = new Association(1, name.getText(), objectif.getText(), email.getText(),password.getText(), address.getText(), type.getText(), about.getText(), logo.getText());
        try {
            if (password.getText().equals(confirm.getText())) {
                SA.addAssociation(a1);             
                AnchorPane redirect;
                redirect = FXMLLoader.load(getClass().getResource("association.fxml"));
                main.getChildren().setAll(redirect);                             
            }else{
                System.out.println("verifier vos parametres");//Alert
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AjoutAssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}


