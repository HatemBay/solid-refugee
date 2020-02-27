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
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class AjoutActionController implements Initializable {

    @FXML
    private AnchorPane main;
    @FXML
    private ImageView background;
    @FXML
    private TextField location;
    @FXML
    private DatePicker date;
    @FXML
    private TextField name;
    private TextArea type;
    private TextField tools;
    @FXML
    private Button add;
    @FXML
    private TextField volunteers;
    @FXML
    private TextField description;
    @FXML
    private CheckBox former;
    @FXML
    private CheckBox doctor;
    @FXML
    private CheckBox teacher;
    @FXML
    private CheckBox otherstype;
    @FXML
    private CheckBox log;
    @FXML
    private CheckBox hyg;
    @FXML
    private CheckBox shemters;
    @FXML
    private CheckBox othertools;
    @FXML
    private Label error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image back = new Image("file:/C:/Users/Tarek/Desktop/ESPRIT/3A/Semestre2/MOBILE/Séance2/donationfx/src/uploads/background.jpg");
        background.setImage(back);
        volunteers.setText("");
    }    

    @FXML
    private void addAction(ActionEvent event) throws IOException {
       Services.ServiceAction SA = new ServiceAction();


       
       
       
        
        try {
            
        if ((name.getText()!="") && (date.getValue()!=null) && (location.getText()!="") && (Integer.parseInt(volunteers.getText())!=0) && (description.getText()!=""))
        {
            if ( (former.isSelected()==true) || (doctor.isSelected()==true) || (teacher.isSelected()==true) || (otherstype.isSelected()==true)){
                if ( (log.isSelected()==true) || (hyg.isSelected()==true) || (shemters.isSelected()==true) || (othertools.isSelected()==true) ) {
                    Action a1 = new Action(1,8, name.getText(), date.getValue().toString(), location.getText(),Integer.parseInt(volunteers.getText()),description.getText());
                    SA.addAction(a1);
                    
                    if (log.isSelected()) {
                        int idl = SA.getTypematByName("Logistics");
                        SA.addtypemat(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (hyg.isSelected()) {
                        int idl = SA.getTypematByName("Hygiene");
                        SA.addtypemat(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (shemters.isSelected()) {
                        int idl = SA.getTypematByName("Shelters");
                        SA.addtypemat(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (othertools.isSelected()) {
                        int idl = SA.getTypematByName("Others");
                        SA.addtypemat(SA.getByName(name.getText()).getId_Action(), idl);
                    }

                    if (former.isSelected()) {
                        int idl = SA.getTypevolByName("Former");
                        SA.addtypevol(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (doctor.isSelected()) {
                        int idl = SA.getTypevolByName("Doctor");
                        SA.addtypevol(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (teacher.isSelected()) {
                        int idl = SA.getTypevolByName("Teacher");
                        SA.addtypevol(SA.getByName(name.getText()).getId_Action(), idl);
                    }
                    if (otherstype.isSelected()) {
                        int idl = SA.getTypevolByName("Others");
                        SA.addtypevol(SA.getByName(name.getText()).getId_Action(), idl);
                    }                      
                    AnchorPane redirect;
                    redirect = FXMLLoader.load(getClass().getResource("DisplayAction.fxml"));
                    main.getChildren().setAll(redirect);                    
                    
                }else{
               
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Fill in Tools");
                alert.showAndWait();
                
                }
            }else{
               
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Fill in Type");
                alert.showAndWait();
            }
        }else{
            
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Fill in Fields");
                alert.showAndWait();
        }            
                
              
                
                
                
                            
            
        } catch (SQLException ex) {
            Logger.getLogger(AjoutAssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
