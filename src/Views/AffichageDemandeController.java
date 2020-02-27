/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
import Services.service_appeldon;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author OusSama
 */
public class AffichageDemandeController implements Initializable {

    @FXML
    private ListView<Appel_don> affichage;
    @FXML
    private JFXTextField recherche;
    ObservableList<Appel_don> lista2;
    List<Appel_don> lst;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       service_appeldon pr=new service_appeldon();
//        lista2 = FXCollections.observableArrayList(pr.ListAppel_dons());
//        
        affichage.setCellFactory(new Callback<ListView<Appel_don>, ListCell<Appel_don>>() {
            @Override
            public ListCell<Appel_don> call(ListView<Appel_don> param) { 
                return new AssociationListCell();
            }
        });
        affichage.setItems(lista2);
        
        affichage.setOnMouseClicked((event) -> {
            
            Appel_don p = (Appel_don)affichage.getSelectionModel().getSelectedItem();
            
//            try{
//            Username.setText(p.getUsername());
//            FirstName.setText(p.getPrenom());
//            LastName.setText(p.getNom());
//            email.setText(p.getEmail());
//            address.setText(p.getAdress());
//            phone.setText(p.getNumtel());
//            Sexe.setText(p.getRole());
//            
//            }catch(Exception ex){
//                System.out.println("erreur");
//            }
        });
        
        
    }  

    @FXML
    private void recherche(KeyEvent event) {
        
        service_appeldon ps=new service_appeldon();
        String msg = recherche.getText().concat("%");
        ArrayList<Appel_don> pers = (ArrayList<Appel_don>) ps.recherche(msg);
        ObservableList<Appel_don> obs1 = FXCollections.observableArrayList(pers);
        affichage.setItems(obs1);
    }

   
    
    
       private static class AssociationListCell extends ListCell<Appel_don> {
        private HBox content;
        private Text description;
        private Text nom;
        private Label label1;
        private Label label2; 
        private Label label3;
        Button btnrem;
        
        private ImageView imge;
        javafx.scene.image.Image im;
        ObservableList<Appel_don> lista2;
         @FXML
    private JFXListView<Appel_don> listView;
        public AssociationListCell() {
                    super();
            description = new Text();
            nom = new Text();
            
            
            imge = new ImageView();
            imge.setFitHeight(50);
            imge.setFitWidth(75);
            label1=new Label("Username : ");
            
            label3=new Label("Email : ");
             btnrem = new Button("Supprimer");
            
           VBox vBox = new VBox(new HBox(label1,description),new HBox(label3,nom));
          
         
            vBox.setPrefWidth(250);
            content = new HBox(imge, vBox,btnrem);
            
            content.setSpacing(20);
        }
        service_appeldon sa = new service_appeldon();
        protected  void updateItem(Appel_don item, boolean empty) {
//            super.updateItem(item, empty);
            if (item != null && !empty) {  
                description.setText(item.getDescription());
                nom.setText(item.getNom()+"");
              
                
               
                btnrem.setOnAction((event) -> {
                    sa.supprimerappeldon(0);
                    Alert dialogC = new Alert(Alert.AlertType.CONFIRMATION);
             dialogC.setTitle(" Confirmation ");
             dialogC.setHeaderText(null);
             dialogC.setContentText("Etes-vous sûr de vouloir supprimer "+item.getNom());
                          Optional<ButtonType> answer = dialogC.showAndWait();
             if (answer.get() == ButtonType.OK) {
                        try {
                            //  int x = table.getSelectionModel().getSelectedItem().getId();
                            sa.supprimerappeldon(item.getId());
                            
                            
                            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                            
                            Parent root = FXMLLoader.load(getClass().getResource("./MainUI.fxml"));
                            
                            Scene scene = new Scene(root);
                            
                            stage.setScene(scene);
                            stage.show();   } catch (IOException ex) {
//                            Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
                        }

     

      
                }});
                
                
               
                setGraphic(content);
            } else {
                setGraphic(null);
            }
        }
    }

    
}