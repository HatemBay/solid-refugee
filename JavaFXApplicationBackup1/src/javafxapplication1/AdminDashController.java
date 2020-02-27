///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafxapplication1;
//
//import com.donation.Entite.Users;
//import com.donation.Service.ServiceUsers;
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.Collection;
//import java.util.List;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//
///**
// * FXML Controller class
// *
// * @author Hatem
// */
//public class AdminDashController implements Initializable {
//
//    @FXML
//    private VBox listUsers;
//    @FXML
//    private VBox listAssoc;
//    @FXML
//    private TextField searchAssoc;
//    @FXML
//    private TextField searchUsers;
//    @FXML
//    private VBox listAssoc1;
//    @FXML
//    private Button back;
//    
//    ServiceUsers serUsers = new ServiceUsers();
//
//    /**
//     * Initializes the controller class.
//     */
//    
//         @FXML
//    private AnchorPane main;
//    @FXML
//    private VBox associationcontainer;
//    @FXML
//    private ImageView menu;
//
//    ServiceUsers SU = new ServiceUsers();
//    @FXML
//    private TextField name;
//    @FXML
//    private TextField objectif;
//    @FXML
//    private PasswordField password;
//    @FXML
//    private Button browse;
//    @FXML
//    private TextArea about;
//    @FXML
//    private TextField type;
//    @FXML
//    private TextArea address;
//    @FXML
//    private TextField email;
//    @FXML
//    private Button update;
//    @FXML
//    private Pane modifform;
//    @FXML
//    private Button fermeture;
//    @FXML
//    private TextField image;
//    @FXML
//    private TextField search;
//    @FXML
//    private RadioButton sortdate;
//    @FXML
//    private RadioButton sortname;
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        fermeture.setBackground(Background.EMPTY);
//        try {
//            
//            
//            modifform.setVisible(false);
//            List<Users> associations = SU.readAll();
//            Users connected = SU.searchById(5);
//            
//            afficher(associations);
//            Image men = new Image("uploads/afficher_1.jpg");
//            menu.setPreserveRatio(false);
//            menu.setImage(men);
//            
//            
//            
//            
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }    
//
//
//    private void afficher(List<Users> associations) throws SQLException{
//        Users connected = SU.searchById(5);
//        associationcontainer.getChildren().clear();
//        
//        for (int i = 0; i < associations.size(); i++) {
//            Users actuel = associations.get(i);
//            Pane single = new Pane();
//            single.setPrefHeight(150);
//            single.setPrefWidth(547);
//            single.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
//            
//            ImageView logo = new ImageView();
//            logo.setLayoutX(3);
//            logo.setLayoutY(3);
//            logo.setFitWidth(136);
//            logo.setFitHeight(147);
//            logo.setPreserveRatio(false);
//            Image log = new Image(actuel.getLogo_Users());
//            logo.setImage(log);
//            
//            Label name = new Label();
//            name.setPrefHeight(27);
//            name.setPrefWidth(USE_COMPUTED_SIZE);
//            name.setLayoutX(166);
//            name.setLayoutY(20);
//            name.setStyle("-fx-font-size :18");
//            name.setText(actuel.getNom_Users());
//            
//            Label type = new Label();
//            type.setPrefHeight(27);
//            type.setPrefWidth(USE_COMPUTED_SIZE);
//            type.setLayoutX(166);
//            type.setLayoutY(47);
//            type.setStyle("-fx-font-size :15");
//            type.setText(actuel.getType_Users());
//                        
//            Label location = new Label();
//            location.setPrefHeight(27);
//            location.setPrefWidth(USE_COMPUTED_SIZE);
//            location.setLayoutX(180);
//            location.setLayoutY(72);
//            location.setStyle("-fx-font-size :12");
//            location.setText(actuel.getAddress_Users());
//            
//            ImageView marker = new ImageView();
//            marker.setLayoutX(163);
//            marker.setLayoutY(78);
//            marker.setFitWidth(15);
//            marker.setFitHeight(15);
//            marker.setPreserveRatio(false);
//            Image mark = new Image("uploads/pin.png");
//            marker.setImage(mark);            
//            
//            Label description = new Label();
//            description.setPrefHeight(27);
//            description.setPrefWidth(USE_COMPUTED_SIZE);
//            description.setLayoutX(164);
//            description.setLayoutY(100);
//            description.setStyle("-fx-font-size :12");
//            description.setText(actuel.getDescription_Users());
//
//            Button supprimer = new Button("X");
//            supprimer.setPrefHeight(15);
//            supprimer.setPrefWidth(15);
//            supprimer.setLayoutX(519);
//            supprimer.setLayoutY(3);
//            supprimer.setVisible(false);
//            
//            Button modifier = new Button("Y");
//            modifier.setPrefHeight(15);
//            modifier.setPrefWidth(15);
//            modifier.setLayoutX(490);
//            modifier.setLayoutY(3);
//            modifier.setVisible(false);            
//            if (actuel.getId_Users()==connected.getId_Users()) {
//               supprimer.setVisible(true); 
//               modifier.setVisible(true); 
//            supprimer.setOnMouseClicked((MouseEvent e) ->{
//                   try {              
//                       SU.deleteUsers(actuel);
//                       AnchorPane redirect;
//                       redirect = FXMLLoader.load(getClass().getResource("DisplayUsers.fxml"));
//                       main.getChildren().setAll(redirect);                       
//                       
//                   } catch (SQLException ex) {
//                       Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
//                   } catch (IOException ex) {
//                       Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
//                   }
//            });  
//            
//            modifier.setOnMouseClicked((MouseEvent e) ->{
//               
//                modifform.setVisible(true);
//                this.name.setText(actuel.getNom_Users());
//                objectif.setText(actuel.getObjectif_Users());
//                email.setText(actuel.getEmail_Users());
//                address.setText(actuel.getAddress_Users());
//                this.type.setText(actuel.getType_Users());
//                about.setText(actuel.getDescription_Users());
//                image.setText(actuel.getLogo_Users());  
//                
//                System.out.println(actuel.getPassword_Users());
//                update.setOnMouseClicked((MouseEvent er) ->{
//                    
//                    if (password.getText().equals(actuel.getPassword_Users())) {                            
//                            Users nouveau;
//                            nouveau = new Users(actuel.getId_Users(), this.name.getText(), objectif.getText(), email.getText(), actuel.getPassword_Users(),  address.getText(),  this.type.getText(), about.getText(), image.getText());
//                               try {
//                                   SU.updateUsers(nouveau);
//                                   AnchorPane redirected;
//                                   redirected = FXMLLoader.load(getClass().getResource("DisplayUsers.fxml"));
//                                   main.getChildren().setAll(redirected);                       
//
//
//                               } catch (SQLException ex) {
//                                   Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
//                               } catch (IOException ex) {
//                                   Logger.getLogger(DisplayUsersController.class.getName()).log(Level.SEVERE, null, ex);
//                               }                             
//                    }else{
//                        System.out.println("mot de passe incorrect");
//                    }
//                });
//          
//            
//            });    
//            fermeture.setOnMouseClicked((MouseEvent eo)->{
//                modifform.setVisible(false);
//            });
//            }
//
//            
//            
//
//            single.getChildren().add(logo);
//            single.getChildren().add(name);
//            single.getChildren().add(type);
//            single.getChildren().add(location);
//            single.getChildren().add(marker);
//            single.getChildren().add(description);
//            single.getChildren().add(supprimer);
//            single.getChildren().add(modifier);
//            
//            associationcontainer.getChildren().add(single);
//        }
//    
//    
//    }
//
//    @FXML
//    private void searchAction(KeyEvent event) throws SQLException {
//        String m = search.getText();
//        ArrayList<Users> a = (ArrayList<Users>) SU.SearchUserss(m);
//        ObservableList<Users> obs = FXCollections.observableArrayList(a);
//        afficher(obs);
//    }
//
//    @FXML
//    private void sortdate(ActionEvent event) throws SQLException {
//        associationcontainer.getChildren().clear();
//        sortname.setSelected(false);
//        afficher(SU.TrierUserss(1));
//    }
//
//    @FXML
//    private void sortname(ActionEvent event) throws SQLException {
//        sortdate.setSelected(false);
//        associationcontainer.getChildren().clear();
//        afficher(SU.TrierUserss(2));
//    }
//        
//    
//}
