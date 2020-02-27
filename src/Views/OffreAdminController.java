/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
import Entities.Offre;
import Services.ServiceOffre;
//import Entities.Cause;
import Services.service_appeldon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class OffreAdminController implements Initializable {
    private TableColumn<Offre,String> type2;
   

    private TableColumn<Offre,String> contact2;

    private TableColumn<Offre,String> state2;

//    @FXML
//    private TableColumn<Offre,String> categorie;
//    private int id;
//       @FXML
    //private TableView<Offre> listeoffre;
private ObservableList<Offre> list2;
ServiceOffre s2=new ServiceOffre();
    @FXML
    private TableView<Offre> listeoffre;
    @FXML
    private TableColumn<Offre, String> categorie;
    @FXML
    private TableColumn<?, ?> nom;
    @FXML
    private TableColumn<?, ?> image;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    void modifieroffre(ActionEvent event) {
             try {
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/makeOffre.fxml"));
         
       
             Parent root1= loader.load();
//                  ModifieDonController modif=loader.getController();
              
          Offre c=listeoffre.getSelectionModel().getSelectedItem();
       
      
          
//         modif.settitre(c.getNom());
//       modif.setcateg(c.getCategory());
//      
//       modif.setdes(c.getDescription());
//    
         
//         id=s.getid(c.getNom());
//         modif.setid(s.getid(c.getNom()));
//         modif.setIdimage(new Image("http://localhost/pi/"+s.getImage(id)));
//        
//            
             Stage stage = new Stage();
            
             stage.setScene(new Scene(root1));  
             stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    @FXML
//    void supprimeroffre(ActionEvent event) {
//        Offre a=listeoffre.getSelectionModel().getSelectedItem();
//  ObservableList<Offre> o;
//  
//           o=listeoffre.getSelectionModel().getSelectedItems();
//           o.forEach(list::remove);
//         s.supprimerapperoffre(s.getid(a.getNom()));
//             Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Alert");
//        alert.setHeaderText("Resultat:");
//        alert.setContentText("don est supprimé avec succés");
// 
//        alert.showAndWait();
//
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ServiceOffre e = new ServiceOffre() ;
//        e.afficheroffre(3);
//        list=s.afficheparid(3);
        list2=s2.afficheparid(LoginController.iduser);

        type2.setCellValueFactory(new PropertyValueFactory<>("type"));

        contact2.setCellValueFactory(new PropertyValueFactory<>("contact"));

         state2.setCellValueFactory(new PropertyValueFactory<>("state"));
          //categorie.setCellValueFactory(new PropertyValueFactory<>("category"));
      listeoffre.setItems(list2); 
       
    }    
    
 
      
  
    
}
