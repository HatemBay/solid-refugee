/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Entite.Admin;
import com.donation.Service.ServiceAdmin;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hatem
 */
public class AdminSignUpController implements Initializable {
    ServiceAdmin serAdmin = new ServiceAdmin();
    private final Connection con;
    private Statement ste;
    
    @FXML
    TextField ASUFirstName;
    @FXML
    TextField ASULastName;
    @FXML
    TextField ASUEmail;
    @FXML
    TextField ASUPassword;
    @FXML
    TextField ASUPasswordC;


    

    /**
     * Initializes the controller class.
     */
    public AdminSignUpController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

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
    private void adminSignIn(ActionEvent event) throws IOException, SQLException{
        String fn = ASUFirstName.getText();
        String ln = ASULastName.getText();
        String email = ASUEmail.getText();
        String pass = ASUPassword.getText();
        String passc = ASUPasswordC.getText();
        
        //ste = con.createStatement();
        if ((!"".equals(fn)) && (!"".equals(ln)) && (!"".equals(email)) && (!"".equals(pass))) {

            /*
        *
        *this is a test on email existance which is the unique key
        *
             */
            if (serAdmin.readAllLogins().contains(email) == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Email already exists");
                alert.showAndWait();
                ASUEmail.clear();
                ASUPassword.clear();
                ASUPasswordC.clear();
                return;
            }
            /*
            *
            *test on the email textfield
             */
            if (!validateEmail(ASUEmail.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email pattern");
                alert.showAndWait();
                ASUEmail.clear();
                ASUPassword.clear();
                ASUPasswordC.clear();
                return;
            }
            /*
            *
            *test on password length
            *
             */
            if (ASUPassword.getText().length() < 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Password too short, minimum length 5 characters");
                alert.showAndWait();
                ASUPassword.clear();
                ASUPasswordC.clear();
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
                ASUPassword.clear();
                ASUPasswordC.clear();
                return;
            }

            /* ------> all conditions are set: adding admin to database*/
            Admin admin = new Admin(email, pass, fn, ln);
            serAdmin.add(admin);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been created");
            alert.showAndWait();
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AdminSignIn.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

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

            ASUFirstName.clear();
            ASULastName.clear();
            ASUEmail.clear();
            ASUPassword.clear();
            ASUPasswordC.clear();

            return;
        }
    }
}
