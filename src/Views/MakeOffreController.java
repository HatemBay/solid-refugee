/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Entities.Offre;
import Services.ServiceOffre;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static Utils.Whatsapp.ACCOUNT_SID;
import static Utils.Whatsapp.AUTH_TOKEN;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author OusSama
 */
public class MakeOffreController implements Initializable {

    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField contact;
    @FXML
    private JFXTextField state;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXButton submit;
    @FXML
    private JFXTextField msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submit(ActionEvent event) {
         ServiceOffre o = new ServiceOffre();
     if (type.getText().equals("")) {
            msg.setText("Type  invalid ");
            } else if (contact.getText().equals("")) {
            msg.setText("contact invalid   ");
             } else if (state.getText().equals("")) {
            msg.setText("state invalid   ");
            } 

//if (!isFormValid()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText(null);
//            alert.setContentText("Invalid Form Entries");
//            alert.initOwner(t3.getScene().getWindow());
//            alert.initModality(Modality.APPLICATION_MODAL);
//            alert.showAndWait();
//        }
            else 
            {
            Offre p = new Offre(type.getText(), contact.getText(),state.getText(),LoginController.iduser); 
           ServiceOffre of = new ServiceOffre();
            of.addoffre(p);} 
            msg.setText("   ");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("offer");
            alert.setHeaderText("Thank You ");
            alert.setContentText("Your offer has been added !");
            alert.showAndWait();
             Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+21692562931"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "5démmmm 💖!")
                .create();

        System.out.println(message.getSid());
    
 
   
    
    
    
    }

    private boolean isFormValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    }

