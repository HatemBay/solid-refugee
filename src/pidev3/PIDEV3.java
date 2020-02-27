/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev3;

import Entities.User;
//import Views.BackendController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author Oussama
 */
public class PIDEV3 extends Application{
    
  public static Stage stage;
    public static User user_front;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
               user_front= new User();
       user_front.setId(5); 
       user_front.setNom("Laajili");
       user_front.setPrenom("Ousssama");
       user_front.setEmail("oussama.laajili08@gmail.com");
      /*  user_front.setId(3);
       user_front.setNom("agant");
       user_front.setPrenom("agant");
       user_front.setEmail("agant");*/
        launch(args);
     
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
   Parent root = FXMLLoader.load(getClass().getResource("/Views/Front.fxml"));
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
              stage =primaryStage; 
        System.out.println(primaryStage.toString()); 
        primaryStage.show();
    
}
    
        public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		PIDEV3.stage = stage;
	}
}