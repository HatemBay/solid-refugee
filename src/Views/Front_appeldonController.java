/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.Appel_don;
import Services.service_appeldon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class Front_appeldonController implements Initializable {
    @FXML
    private VBox vbox;
     private ObservableList<Appel_don> list=FXCollections.observableArrayList();
     service_appeldon s=new service_appeldon();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
       
       list=s.afficherappeldon(LoginController.iduser);
         Node[] n=new Node[list.size()];
                
        for(int i=0;i<n.length;i++)
        {
              try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/List_appeldon.fxml"));
           n[i]=loader.load();
           
           //List_appeldonController l=loader.getController();
           vbox.getChildren().add(n[i]);
      //l.setcat(list.get(i).getCategory());
      //l.setdes(list.get(i).getDescription());
      //l.setnom(list.get(i).getNom()); 
      //l.setId(list.get(i).getId());
      //l.setIdOwner(list.get(i).getUser_id());
       //l.setIdimage(new Image("http://localhost/pi/"+s.getImage(s.getid(list.get(i).getNom()))));
     
             
                  
                  
            
          
       } catch (IOException ex) {
           //Logger.getLogger(FrontcauseController.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        } 
               
    }    
    
}
