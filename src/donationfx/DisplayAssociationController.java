/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import Entity.Association;
import Services.ServiceAssociation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class DisplayAssociationController implements Initializable {

    @FXML
    private AnchorPane main;
    @FXML
    private VBox associationcontainer;
    @FXML
    private ImageView menu;

    Services.ServiceAssociation SA = new ServiceAssociation();
    @FXML
    private TextField name;
    @FXML
    private TextField objectif;
    @FXML
    private PasswordField password;
    @FXML
    private Button browse;
    @FXML
    private TextArea about;
    @FXML
    private TextField type;
    @FXML
    private TextArea address;
    @FXML
    private TextField email;
    @FXML
    private Button update;
    @FXML
    private Pane modifform;
    @FXML
    private Button fermeture;
    @FXML
    private TextField image;
    @FXML
    private TextField search;
    @FXML
    private RadioButton sortdate;
    @FXML
    private RadioButton sortname;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fermeture.setBackground(Background.EMPTY);
        try {
            
            
            modifform.setVisible(false);
            List<Association> associations = SA.getAssociations();
            Association connected = SA.getById(5);
            
            afficher(associations);
            Image men = new Image("uploads/afficher_1.jpg");
            menu.setPreserveRatio(false);
            menu.setImage(men);
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DisplayAssociationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


    private void afficher(List<Association> associations) throws SQLException{
        Association connected = SA.getById(5);
        associationcontainer.getChildren().clear();
        
        for (int i = 0; i < associations.size(); i++) {
            Association actuel = associations.get(i);
            Pane single = new Pane();
            single.setPrefHeight(150);
            single.setPrefWidth(547);
            single.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
            
            ImageView logo = new ImageView();
            logo.setLayoutX(3);
            logo.setLayoutY(3);
            logo.setFitWidth(136);
            logo.setFitHeight(147);
            logo.setPreserveRatio(false);
            Image log = new Image(actuel.getLogo_Association());
            logo.setImage(log);
            
            Label name = new Label();
            name.setPrefHeight(27);
            name.setPrefWidth(USE_COMPUTED_SIZE);
            name.setLayoutX(166);
            name.setLayoutY(20);
            name.setStyle("-fx-font-size :18");
            name.setText(actuel.getNom_Association());
            
            Label type = new Label();
            type.setPrefHeight(27);
            type.setPrefWidth(USE_COMPUTED_SIZE);
            type.setLayoutX(166);
            type.setLayoutY(47);
            type.setStyle("-fx-font-size :15");
            type.setText(actuel.getType_Association());
                        
            Label location = new Label();
            location.setPrefHeight(27);
            location.setPrefWidth(USE_COMPUTED_SIZE);
            location.setLayoutX(180);
            location.setLayoutY(72);
            location.setStyle("-fx-font-size :12");
            location.setText(actuel.getAddress_Association());
            
            ImageView marker = new ImageView();
            marker.setLayoutX(163);
            marker.setLayoutY(78);
            marker.setFitWidth(15);
            marker.setFitHeight(15);
            marker.setPreserveRatio(false);
            Image mark = new Image("uploads/pin.png");
            marker.setImage(mark);            
            
            Label description = new Label();
            description.setPrefHeight(27);
            description.setPrefWidth(USE_COMPUTED_SIZE);
            description.setLayoutX(164);
            description.setLayoutY(100);
            description.setStyle("-fx-font-size :12");
            description.setText(actuel.getDescription_Association());

            Button supprimer = new Button("X");
            supprimer.setPrefHeight(15);
            supprimer.setPrefWidth(15);
            supprimer.setLayoutX(519);
            supprimer.setLayoutY(3);
            supprimer.setVisible(false);
            
            Button modifier = new Button("Y");
            modifier.setPrefHeight(15);
            modifier.setPrefWidth(15);
            modifier.setLayoutX(490);
            modifier.setLayoutY(3);
            modifier.setVisible(false);            
            if (actuel.getId_Association()==connected.getId_Association()) {
               supprimer.setVisible(true); 
               modifier.setVisible(true); 
            supprimer.setOnMouseClicked((MouseEvent e) ->{
                   try {              
                       SA.deleteAssociation(actuel);
                       AnchorPane redirect;
                       redirect = FXMLLoader.load(getClass().getResource("DisplayAssociation.fxml"));
                       main.getChildren().setAll(redirect);                       
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(DisplayAssociationController.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IOException ex) {
                       Logger.getLogger(DisplayAssociationController.class.getName()).log(Level.SEVERE, null, ex);
                   }
            });  
            
            modifier.setOnMouseClicked((MouseEvent e) ->{
               
                modifform.setVisible(true);
                this.name.setText(actuel.getNom_Association());
                objectif.setText(actuel.getObjectif_Association());
                email.setText(actuel.getEmail_Association());
                address.setText(actuel.getAddress_Association());
                this.type.setText(actuel.getType_Association());
                about.setText(actuel.getDescription_Association());
                image.setText(actuel.getLogo_Association());  
                
                System.out.println(actuel.getPassword_Association());
                update.setOnMouseClicked((MouseEvent er) ->{
                    
                    if (password.getText().equals(actuel.getPassword_Association())) {                            
                            Association nouveau;
                            nouveau = new Association(actuel.getId_Association(), this.name.getText(), objectif.getText(), email.getText(), actuel.getPassword_Association(),  address.getText(),  this.type.getText(), about.getText(), image.getText());
                               try {
                                   SA.updateAssociation(nouveau);
                                   AnchorPane redirected;
                                   redirected = FXMLLoader.load(getClass().getResource("DisplayAssociation.fxml"));
                                   main.getChildren().setAll(redirected);                       


                               } catch (SQLException ex) {
                                   Logger.getLogger(DisplayAssociationController.class.getName()).log(Level.SEVERE, null, ex);
                               } catch (IOException ex) {
                                   Logger.getLogger(DisplayAssociationController.class.getName()).log(Level.SEVERE, null, ex);
                               }                             
                    }else{
                        System.out.println("mot de passe incorrect");
                    }
                });
          
            
            });    
            fermeture.setOnMouseClicked((MouseEvent eo)->{
                modifform.setVisible(false);
            });
            }

            
            

            single.getChildren().add(logo);
            single.getChildren().add(name);
            single.getChildren().add(type);
            single.getChildren().add(location);
            single.getChildren().add(marker);
            single.getChildren().add(description);
            single.getChildren().add(supprimer);
            single.getChildren().add(modifier);
            
            associationcontainer.getChildren().add(single);
        }
    
    
    }

    @FXML
    private void searchAction(KeyEvent event) throws SQLException {
        String m = search.getText();
        ArrayList<Association> a = (ArrayList<Association>) SA.SearchAssociations(m);
        ObservableList<Association> obs = FXCollections.observableArrayList(a);
        afficher(obs);
    }

    @FXML
    private void sortdate(ActionEvent event) throws SQLException {
        associationcontainer.getChildren().clear();
        sortname.setSelected(false);
        afficher(SA.TrierAssociations(1));
    }

    @FXML
    private void sortname(ActionEvent event) throws SQLException {
        sortdate.setSelected(false);
        associationcontainer.getChildren().clear();
        afficher(SA.TrierAssociations(2));
    }


    
}
