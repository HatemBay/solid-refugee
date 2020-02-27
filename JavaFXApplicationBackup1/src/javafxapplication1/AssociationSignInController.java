/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Service.ServiceAssociation2;
import com.donation.Service.ServiceUsers;
import com.donation.Utils.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hatem
 */
public class AssociationSignInController implements Initializable {
    ServiceAssociation2 serAssociation = new ServiceAssociation2();
    private final Connection con;
    private Statement ste;

    @FXML
    private TextField assocLogin;
    @FXML
    private PasswordField assocPass;
    @FXML
    private Label emailSent;
    
    public String generate(int id) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = id;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        return generatedString;
    }

    public AssociationSignInController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        //pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void associationSignUp(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AssociationSignUp.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    private void associationLogin(ActionEvent event) throws IOException, SQLException{
        String login = assocLogin.getText();
        String pass = assocPass.getText();
        String strpass = "";

        ResultSet rs = con.createStatement().executeQuery("select * from `association` where `Email_Association` = '" + login + "';");
        while (rs.next()) {
            strpass = (String) rs.getString("Password_Association");
            System.out.println(strpass);
        }

        /*
        *
        *test on email and pass existence
        *
         */
        if (!strpass.equals(pass) || !serAssociation.readAllEmails().contains(login)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("Wrong email or password!");
            alert.showAndWait();
            assocLogin.clear();
            assocPass.clear();
            return;
        }

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    private void backRoot(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("RootPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void passForgotten(ActionEvent event) throws SQLException {
        String login = assocLogin.getText();
        String res = "";
        TextInputDialog dialog = new TextInputDialog(login);
        dialog.setTitle("Changing password");
        dialog.setHeaderText("Your password will be reset, confirm");
        dialog.setContentText("Please enter your email");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            res = result.get();
            if (serAssociation.readAllEmails().contains(res)) {
                String rand = generate(7);
                SendingMail sm = new SendingMail("your password has been reset  , you can now login  with :" + rand, res, "Password reset");
                SendingMail.sendMail();
                con.createStatement().execute("update `association` set `Password_Association` = '" + rand + "' where `Email_Association` = '" + login + "';");
                emailSent.setText("Check your email.");
            } else {
                emailSent.setText("Entered email does not exist.");
            }
        }

        assocLogin.clear();
        assocPass.clear();
    }
    
}
