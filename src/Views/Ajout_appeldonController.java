/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
import Services.service_appeldon;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class Ajout_appeldonController implements Initializable {
   @FXML
    private TextField nom;

    @FXML
    private TextArea description;

    @FXML
    private ComboBox<String> categorie;

    @FXML
    private ImageView image;
      private ObservableList<String> list=FXCollections.observableArrayList();;
    File file;
    String path;
    service_appeldon sa=new service_appeldon();
    @FXML
    void creerappeldon(ActionEvent event) {
        Appel_don a=new Appel_don();
        a.setCategory(categorie.getValue());
        a.setDescription(description.getText());
        a.setImage(path);
        a.setNom(nom.getText());
        a.setUser_id(LoginController.iduser);
        sa.ajoutappeldon(a);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("appelDon est ajouté avec succés");
 
        alert.showAndWait();
         
        

    }

    @FXML
    void importerimage(ActionEvent event) {
    FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null)
        {
              
              try {
                  String imageFile= selectedFile.toURI().toURL().toString();
                  this.file= selectedFile;
                  System.out.println(imageFile);
                  System.out.println(selectedFile.getAbsoluteFile());
      
                  Image i = new Image(imageFile) {} ;
    
                  try {
//                      path=PostFile.upload(selectedFile.getAbsolutePath());
                      image.setImage(i);
                      
                  } catch (Exception ex) {
                      //Logger.getLogger(AjoutcauseController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.out.println(path);
          
              } catch (MalformedURLException ex) {
                  //Logger.getLogger(AjoutcauseController.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            
        }     
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        list.add(" Livres / Magazines'");
        list.add("Vêtements");
        list.add("Matériel spécialisé");
        categorie.setItems(list);
    }    
    
}
