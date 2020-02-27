/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entities.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Oussama
 */
public class FrontController implements Initializable {
  @FXML
    private Button idlogout;
    @FXML
    private Pane pane;

 Node[] n=new Node[20];
    @FXML
    private ImageView background;
   
 
   
    @FXML
    void logout(ActionEvent event) {
                  Window window = idlogout.getScene().getWindow(); 

     if (window instanceof Stage){ 
      ((Stage) window).close(); 
     } 


    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image back =new Image("file:/C:/Users/OusSama/Desktop/Study/3A4/PI/RequestOffer/JavaFXApplication3/src/uploads/admin_Plan de travail 1.jpg");
        background.setImage(back);
    }   
      void AcceuilAdmin(ActionEvent event) {
           pane.getChildren().clear();
        
                            try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/AcceuilAdmin.fxml"));
           n[11]=loader.load();
        
           pane.getChildren().add(n[11]);
       } catch (IOException ex) {
           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       } 
                            
                            
        
        
        System.out.println("Views.BackendController.AjouterPoint()");

    } 
    
      @FXML
   public  void Mail(ActionEvent event) {
           pane.getChildren().clear();
        
                            try {
          
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/makeOffre.fxml"));
           n[19]=loader.load();
        
           pane.getChildren().add(n[19]);
       } catch (IOException ex) {
           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
       } 
                            
                            
        
        
        System.out.println("Views.BackendController.AjouterPoint()");

    }

 

//    void AjouterPointCollect(ActionEvent event) {
//         pane.getChildren().clear();
//        
//                            try {
//          
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/AjouterPointCollect.fxml"));
//           n[10]=loader.load();
//     
//
//           pane.getChildren().add(n[10]);
//       } catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//        
//        
//        System.out.println("Views.BackendController.AjouterPoint()");
//
//    }

//    void AjouterProduit_1(ActionEvent event) {
//     pane.getChildren().clear();
//        
//      try  
//      {  
// CurrentUser in  =new CurrentUser();  
// int num=in.getAnchorPaneCondition();  
//        if (num==1) 
//        {   
//            
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/AjouterProduit_1.fxml")); 
//           n[3]=loader.load();
//           
//           pane.getChildren().add(n[3]);
//            System.out.println("baaa");
//        } 
//        else  
//        {
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/AjouterProduit.fxml"));
// 
//              n[4]=loader.load();
//    
//
//            pane.getChildren().add(n[4]);
//        }
//   
//       }  
//     catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }

   

//    void Marche(ActionEvent event) {
//         pane.getChildren().clear();
//        
//               try {
//              CurrentUser cr =new CurrentUser();
//           cr.setChoiceMarche(0);
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Marche.fxml"));
//           n[7]=loader.load();
//
//
//           pane.getChildren().add(n[7]);
//           
//       } catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//
//    }

//    void MyProducts(ActionEvent event) {
//         pane.getChildren().clear();
//        
//               try {
//          
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/MyProducts.fxml"));
//           n[6]=loader.load();
//     
//
//           pane.getChildren().add(n[6]);
//       } catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//
//    }

//    void MyProps(ActionEvent event) {
//                pane.getChildren().clear();
//        
//            try {
//          
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/MyProps.fxml"));
//           n[9]=loader.load();
//  
//
//           pane.getChildren().add(n[9]);
//       } catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//
//    }

//    void RechercherProduit(ActionEvent event) {
//          pane.getChildren().clear();
//        
//         CurrentUser cr =new CurrentUser();
//           cr.setChoiceMarche(1);
//                            try {
//                             
//
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/RechercherProduit.fxml"));
//           n[12]=loader.load();
//       
//           pane.getChildren().add(n[12]);
//       } catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//        
//        
//        System.out.println("Views.BackendController.AjouterPoint()");
//
//    }

//    void RendezVList(ActionEvent event) {
//           pane.getChildren().clear();
//        
//      
//       try  
//       {
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/RendezVList.fxml"));
//           n[2]=loader.load();
//       
//
//              pane.getChildren().add(n[2]);
//       }
//       catch (IOException ex) {
//           //Logger.getLogger(BackendController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//
//    }

//    private void actualite(ActionEvent event) {
//          pane.getChildren().clear();
//          try {
//         
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Actualites.fxml"));
//           n[0]=loader.load();
//         
//           
//           pane.getChildren().add(n[0]);
//       } catch (IOException ex) {
//           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }

//    private void formation(ActionEvent event) {
//          pane.getChildren().clear();
//               try {
//         
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Frontformation.fxml"));
//           n[1]=loader.load();
//          
//           
//           pane.getChildren().add(n[1]);
//       } catch (IOException ex) {
//           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    } 
    
//    private void evenement (ActionEvent event)  
//    {
//          pane.getChildren().clear();
//               try {
//         
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/ListeEvenement.fxml"));
//           n[1]=loader.load();
//          
//           
//           pane.getChildren().add(n[1]);
//       } catch (IOException ex) {
//           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }
//    
//    
//    
    
    
     void appeldon(ActionEvent event) {
          pane.getChildren().clear();
     try {
         
           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Front_Appeldon.fxml"));
           n[14]=loader.load();
          
           
           pane.getChildren().add(n[14]);
       } catch (IOException ex) {
           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
//
//    void cause(ActionEvent event) {
//pane.getChildren().clear();
//               try {
//         
//           FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Frontcause.fxml"));
//           n[13]=loader.load();
//          
//           
//           pane.getChildren().add(n[13]);
//       } catch (IOException ex) {
//           Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }

//    void creercause(ActionEvent event) {
//             try {
//             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Ajoutcause.fxml"));
//            
//            Parent root1 = loader.load();
//             
//            
//              
//            
//             Stage stage = new Stage();
//           
//             stage.setScene(new Scene(root1));  
//             stage.show();
//             
//               } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//
//    }

    @FXML
    void creerdon(ActionEvent event) throws IOException {
          try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Ajout_appeldon.fxml"));
            
            Parent root1 = loader.load();
             
            
              
            
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             //pane.getChildren().setAll(root1);
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }  
          /* Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Ajout_appeldon.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();  */

    }

 

    @FXML
    void listdon(ActionEvent event) {
          try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/DON.fxml"));
            
            Parent root1 = loader.load();
             
            
              
            
             Stage stage = new Stage();
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }  

    }
    
    
//    void listeoffre(ActionEvent event) {
//          try {
//             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/offre.fxml"));
//            
//            Parent root1 = loader.load();
//             
//            
//              
//            
//             Stage stage = new Stage();
//           
//             stage.setScene(new Scene(root1));  
//             stage.show();
//             
//               } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//
//    }
    

//    void listecause(ActionEvent event) {
//         try {
//             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/Cause.fxml"));
//            
//            Parent root1 = loader.load();
//             
//            
//              
//            
//             Stage stage = new Stage();
//           
//             stage.setScene(new Scene(root1));  
//             stage.show();
//             
//               } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//
//    }
//
//  

//    void voiravis(ActionEvent event) {
//        try {
//             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/AfficheMessages.fxml"));
//            
//            Parent root1 = loader.load();
//             
//            
//              
//            
//             Stage stage = new Stage();
//           
//             stage.setScene(new Scene(root1));  
//             stage.show();
//             
//               } catch (IOException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//
//    }

    @FXML
    public void listeoffre(ActionEvent event) {
        
         try {
             FXMLLoader loader =new FXMLLoader(getClass().getResource("/Views/offre.fxml"));
            
            Parent root1 = loader.load();
             
            
              
            
             Stage stage = new Stage();
             stage.setTitle("slmo3alaykom");
           
             stage.setScene(new Scene(root1));  
             stage.show();
             
               } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
}
