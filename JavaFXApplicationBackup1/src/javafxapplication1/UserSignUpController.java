/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Entite.Users;
import com.donation.Service.ServiceUsers;
import com.donation.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hatem
 */
public class UserSignUpController implements Initializable {

    ServiceUsers serUsers = new ServiceUsers();
    private final Connection con;
    private Statement ste;

    @FXML
    private TextField USUFirstName;
    @FXML
    private TextField USULastName;
    @FXML
    private TextField USUEmail;
    @FXML
    private TextField USUPassword;
    @FXML
    private TextField USUPasswordC;
    @FXML
    private TextField USUTel;
    @FXML
    private TextField USUAddress;
    @FXML
    private ComboBox USUBlood;
    @FXML
    private Button USUSubmit;
    @FXML
    private Button USUSubmit1;

    
    public UserSignUpController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        USUBlood.getItems().addAll("AB+", "AB-", "A+", "A-", "O+", "O-", "Not assigned");
        USUBlood.getSelectionModel().select("Not assigned");
        USUTel.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                USUTel.setText(newValue.replaceAll("[^\\d]", ""));
            }
            
        });
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
    private void userSignIn(ActionEvent event) throws IOException, SQLException {
        String fn = USUFirstName.getText();
        String ln = USULastName.getText();
        String email = USUEmail.getText();
        String pass = USUPassword.getText();
        String passc = USUPasswordC.getText();
        String tel = USUTel.getText();
        String address = USUAddress.getText();
        String blood = (String) USUBlood.getValue();

        //ste = con.createStatement();
        if ((!"".equals(fn)) && (!"".equals(ln)) && (!"".equals(email)) && (!"".equals(pass)) && (!"".equals(tel)) && (!"".equals(address))) {
            Integer telint = Integer.parseInt(tel);

            /*
        *
        *this is a test on email existance which is the first unique key
        *
             */
            /*serUsers.readAllLogins().contains(email);
            ResultSet rs = con.createStatement().executeQuery("SELECT `Login_user` FROM `users` WHERE `Login_user` = '" + email + "';");
            String login = "" + rs.getString("Login_user");*/
            if (serUsers.readAllLogins().contains(email) == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Email already exists");
                alert.showAndWait();
                USUEmail.clear();
                USUPassword.clear();
                USUPasswordC.clear();
                return;
            }
            /*
        *
        *this is a test on phone number existance which is the second unique key
        *
             */
            if (serUsers.readAllTels().contains(tel) == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Telephone number already exists");
                alert.showAndWait();
                USUTel.clear();
                return;
            }

            /*
            *
            *test on the email textfield with regex
             */
            if (!validateEmail(USUEmail.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email pattern");
                alert.showAndWait();
                USUEmail.clear();
                USUPassword.clear();
                USUPasswordC.clear();
                return;
            }
            
            /*
            *
            *test on password length
            *
             */
            if (USUPassword.getText().length() < 5) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Password too short, minimum length 5 characters");
                alert.showAndWait();
                USUPassword.clear();
                USUPasswordC.clear();
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
                USUPassword.clear();
                USUPasswordC.clear();
                return;
            }
            /*
            *
            *test on tel number length
             */
            /*if (USUTel.getText().length() < 8) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number");
                alert.showAndWait();
                USUTel.clear();
                return;
            }*/


            /* ------> all conditions are set: adding user to database*/
            Users user = new Users(email, pass, fn, ln, telint, address, blood);
            serUsers.add(user);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been created");
            alert.showAndWait();
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserSignIn.fxml"));
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

            USUFirstName.clear();
            USULastName.clear();
            USUEmail.clear();
            USUPassword.clear();
            USUPasswordC.clear();
            USUTel.clear();
            USUAddress.clear();

        }

    }

    @FXML
    private void assocSU(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AssociationSignIn.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void userSignInBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserSignIn.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }


}
