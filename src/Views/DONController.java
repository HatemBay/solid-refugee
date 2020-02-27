/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
//import Entities.Cause;
import Services.service_appeldon;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class DONController implements Initializable {
   @FXML
    private TableColumn<Appel_don,String> nom;
   

    @FXML
    private TableColumn<Appel_don,String> image;

    @FXML
    private TableColumn<Appel_don,String> description;

    @FXML
    private TableColumn<Appel_don,String> categorie;
    private int id;
       @FXML
    private TableView<Appel_don> listedon;
private ObservableList<Appel_don> list;
service_appeldon s=new service_appeldon();
   
    @FXML
    void modifierdon(ActionEvent event) {
             try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/ModifieDon.fxml"));
         
       
             Parent root1= loader.load();
                  ModifieDonController modif=loader.getController();
              
          Appel_don c=listedon.getSelectionModel().getSelectedItem();
       
      
          
         modif.settitre(c.getNom());
       modif.setcateg(c.getCategory());
      
       modif.setdes(c.getDescription());
    
         
         id=s.getid(c.getNom());
         modif.setid(s.getid(c.getNom()));
         modif.setIdimage(new Image("http://localhost/pi/"+s.getImage(id)));
        
            
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void supprimerdon(ActionEvent event) {
        Appel_don a=listedon.getSelectionModel().getSelectedItem();
  ObservableList<Appel_don> don;
  
           don=listedon.getSelectionModel().getSelectedItems();
           don.forEach(list::remove);
         s.supprimerappeldon(s.getid(a.getNom()));
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Resultat:");
        alert.setContentText("don est supprimé avec succés");
 
        alert.showAndWait();

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        list=s.afficheparid(LoginController.iduser);
         nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
         description.setCellValueFactory(new PropertyValueFactory<>("description"));
          categorie.setCellValueFactory(new PropertyValueFactory<>("category"));
      listedon.setItems(list); 
       
    }    

      
  
    
}
