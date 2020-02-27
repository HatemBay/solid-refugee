/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import com.donation.Service.ServiceUsers;
import com.donation.Utils.DataBase;
import com.donation.Utils.Ticker;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafxapplication1.UserSignInController.Ticker.RemindTask;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Hatem
 */
public class UserSignInController implements Initializable {

    ServiceUsers serUsers = new ServiceUsers();
    private final Connection con;
    private Statement ste;
    Timer timer = new Timer();


    @FXML
    private TextField userLogin;
    @FXML
    private TextField userPass;
    @FXML
    private Label emailSent;
    @FXML
    private Button button;
    @FXML
    private Button button1;

    /*// Email Regex java
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
 /*public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

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

    public UserSignInController() {
        con = DataBase.getInstance().getConnection();

        // initialize the Pattern object
        //pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    @FXML
    private void userSignUp(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserSignUp.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void userLogin(ActionEvent event) throws IOException, SQLException {
        String login = userLogin.getText();
        String pass = userPass.getText();
        String strpass = "";
        String strcode = "";
        int role = 0;

        ResultSet rs = con.createStatement().executeQuery("select * from `users` where `Login_user` = '" + login + "';");
        while (rs.next()) {
            strpass = rs.getString("Password_user");
            strcode = rs.getString("redeem");
            role = rs.getInt("role");
        }
        System.out.println("strcode: "+ strcode);
        System.out.println("pass : "+ pass);

        /*
        *
        *test on email and pass existence
        *
         */
        //test on pass, login and generated code
        if ((!strpass.equals(pass) && !strcode.equals(pass))|| (!serUsers.readAllLogins().contains(login))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failure");
            alert.setHeaderText(null);
            alert.setContentText("Wrong email or password!");
            alert.showAndWait();
            userLogin.clear();
            userPass.clear();
            return;
        }else if( strpass.equals(pass) && role == 0){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("RSE.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            serUsers.SignIn(login, pass);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }else if(strpass.equals(pass) && role == 1){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("AdminDash.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            serUsers.SignIn(login, pass);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }
        else if(strcode.equals(pass)){//case where user entered the generated code
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("NewPass.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            serUsers.SignInWithCode(login, pass);
            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        }
    }

    @FXML
    private void backRoot(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("RootPage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private void passForgotten(ActionEvent event) throws IOException, SQLException, InterruptedException {
        String login = userLogin.getText();
        String res = "";
        TextInputDialog dialog = new TextInputDialog(login);
        dialog.setTitle("Changing password");
        dialog.setHeaderText("Your password will be reset, confirm");
        dialog.setContentText("Please enter your email");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            res = result.get();
            
            if (serUsers.readAllLogins().contains(res)) {
                String rand = generate(7);
                SendingMail sm = new SendingMail("This is your account redemption code : (Note: the code will expire in 2 hours)" + rand, res, "Redeem your account");
                SendingMail.sendMail();
                con.createStatement().execute("update `users` set `redeem` = '" + rand + "' where `Login_user` = '" + res + "';");
                Ticker t = new Ticker(7200, res);
                //Ticker t = new Ticker(15);
                //con.createStatement().execute("update `users` set `redeem` = NULL where `Login_user` = '" + login + "';");
                emailSent.setTextFill(Color.web("#34ff2d"));
                emailSent.setText("Check your email.");
            } else {
                emailSent.setTextFill(Color.web("#ed0e0e"));
                emailSent.setText("Entered email does not exist.");
            }
                
        }

        userLogin.clear();
        userPass.clear();

    }
    

    
    public class Ticker {

    Timer timer;
    String login = userLogin.getText();


    public Ticker(int seconds, String s) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
        login = s;
	}

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            try {
                timer.cancel(); //Terminate the timer thread
                con.createStatement().execute("update `users` set `redeem` = NULL where `Login_user` = '" + login + "';");
                System.out.println("operation succeeded");
            } catch (SQLException ex) {
                Logger.getLogger(UserSignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

}
