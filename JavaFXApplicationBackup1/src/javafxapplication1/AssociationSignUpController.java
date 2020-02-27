/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Entite.Association2;
import com.donation.Service.ServiceAssociation2;
import com.donation.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hatem
 */
public class AssociationSignUpController implements Initializable {
    ServiceAssociation2 serAssociation = new ServiceAssociation2();
    private final Connection con;
    private Statement ste;
    
    
    @FXML
    private TextField ASSUName;
    @FXML
    private TextField ASSUEmail;
    @FXML
    private PasswordField ASSUPassword;
    @FXML
    private PasswordField ASSUPasswordC;
    @FXML
    private TextField ASSUAddress;
    @FXML
    private TextField ASSUType;
    @FXML
    private TextArea ASSUObjectif;
    @FXML
    private TextArea ASSUDesc;

    public AssociationSignUpController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // static Pattern object, since pattern is fixed
    private static Pattern pattern;

    // non-static Matcher object because it's created from the input String
    private Matcher matcher;

    /**
     * This method validates the input email address with EMAIL_REGEX pattern
     *
     * @param email
     * @return boolean
     */
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    @FXML
    private void assocSignIn(ActionEvent event) throws IOException, SQLException{
        
        String name = ASSUName.getText();
        String email = ASSUEmail.getText();
        String pass = ASSUPassword.getText();
        String passc = ASSUPasswordC.getText();
        String address = ASSUAddress.getText();
        String type = ASSUType.getText();
        String objectif = ASSUObjectif.getText();
        String desc = ASSUDesc.getText();

        //ste = con.createStatement();
        if ((!"".equals(name)) && (!"".equals(email)) && (!"".equals(pass)) && (!"".equals(address)) && (!"".equals(type)) && (!"".equals(objectif))) {

            /*
        *
        *this is a test on email existance which is the unique key
        *
             */
            
            if (serAssociation.readAllEmails().contains(email) == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Email already exists");
                alert.showAndWait();
                ASSUEmail.clear();
                ASSUPassword.clear();
                ASSUPasswordC.clear();
                return;
            }
            

            /*
            *
            *test on the email textfield with regex
             */
            if (!validateEmail(ASSUEmail.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email pattern");
                alert.showAndWait();
                ASSUEmail.clear();
                ASSUPassword.clear();
                ASSUPasswordC.clear();
                return;
            }
            
            /*
            *
            *test on password length
            *
             */
            if (ASSUPassword.getText().length() < 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Password too short, minimum length 5 characters");
                alert.showAndWait();
                ASSUPassword.clear();
                ASSUPasswordC.clear();
                return;
            }
            /*
        *
        *testing the match between the two passwords
        *
             */
            if (!passc.equals(pass)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Passwords don't match");
                alert.showAndWait();
                ASSUPassword.clear();
                ASSUPasswordC.clear();
                return;
            }
            


            /* ------> all conditions are set: adding association to database*/
            Association2 association = new Association2(name, email, pass, address, type, objectif, desc);
            serAssociation.add(association);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been created");
            alert.showAndWait();
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AssociationSignIn.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } else {
            /*
            *
            *if one of the fields is empty
            *
             */
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the required fields");
            alert.showAndWait();

            ASSUName.clear();
            ASSUEmail.clear();
            ASSUPassword.clear();
            ASSUPasswordC.clear();
            ASSUAddress.clear();
            ASSUObjectif.clear();
            ASSUDesc.clear();
            //ASSUType.set(0);

        }

    }
    
}
