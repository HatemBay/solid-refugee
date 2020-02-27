/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
import Services.service_appeldon;
//import Utils.PostFile;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ModifieDonController implements Initializable {
 @FXML
    private TextField nom;

    @FXML
    private TextArea description;

    @FXML
    private ComboBox<String> categorie;

    @FXML
    private ImageView image;
        private int id;
service_appeldon s=new service_appeldon();
        File file;
    String path;
    public void settitre(String n)
    {
        nom.setText(n);
        
    }
  
        public void setdes(String n)
    {
        description.setText(n);
        
    }
  public void setcateg(String n)
    {
        categorie.setValue(n);
        
    }
   public void setIdimage(Image image) {
        this.image.setImage(image); 
    }
    public void setid(int a)
    {
        id=a;
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
                      //Logger.getLogger(ModifiecauseController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.out.println(path);
          
              } catch (MalformedURLException ex) {
                  //Logger.getLogger(ModifiecauseController.class.getName()).log(Level.SEVERE, null, ex);
              }
              
            
        }     
    }

    @FXML
    void modifier(ActionEvent event) {
    Appel_don a=new Appel_don();
    a.setCategory(categorie.getValue());
    a.setDescription(description.getText());
    a.setImage(path);
    a.setNom(nom.getText());
    a.setId(id);
    s.modifieappeldon(a);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("Modification effectués avec succés");
          
         alert.showAndWait();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
