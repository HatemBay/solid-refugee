/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donationfx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.MaConnection;

/**
 * FXML Controller class
 *
 * @author Tarek
 */
public class StatController implements Initializable {
    private Connection cnx;
    private Statement stm;
    private PreparedStatement pst;
    private PreparedStatement pst1;
    private ResultSet rs;

    @FXML
    private Button btnload;
    @FXML
    private BarChart<String, Integer> BarChart;
    @FXML
    private ImageView background;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image back = new Image("file:/C:/Users/Tarek/Desktop/ESPRIT/3A/Semestre2/MOBILE/Séance2/donationfx/src/uploads/admin.jpg");
        background.setImage(back);
           String req="select Id_Association,COUNT(Id_Action) from action GROUP by Id_Association";
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        try{
            rs=cnx.createStatement().executeQuery(req);
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
            }
            BarChart.getData().add(series);
            
            
            
        }catch(Exception e){
           System.out.println("erreur stat");
            
        }
    }    
     
    public StatController() {
        cnx = MaConnection.getInstance().getConnection();
        

    }

}
