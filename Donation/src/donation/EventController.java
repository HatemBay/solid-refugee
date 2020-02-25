/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donation;


import Entities.Event;
import Entities.GeoCoordinates;
import Services.ServiceEvent;
import Interfaces.StorageService;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.frame.Frame;
import com.teamdev.jxbrowser.navigation.Navigation;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Siss_Ima
 */
public class EventController implements Initializable {

    public TextField t1;
    public TextArea t4;
    public ComboBox <String>category;
    public DatePicker dateTime;
    public TextField t3;
    public Button submit;
    public TextField poster;
    public Button posterPicker;
    public Button close;
    public BorderPane locationPane;
    private FileChooser fileChooser;
    private File posterFileInput;
    private Engine engine;
    private Browser browser;
    private BrowserView view;
    private Navigation navigation;
    private Frame frame;

    @FXML
    public void onClickPosterPicker(ActionEvent actionEvent) {
        posterFileInput = fileChooser.showOpenDialog(t1.getScene().getWindow());
        poster.setText(posterFileInput.getName());
    }

    @FXML
    public void onSubmit(ActionEvent actionEvent) throws IOException{
        Event event = new Event();
        event.setName_ev(t1.getText());
        event.setLocation_ev(new GeoCoordinates((Double) frame.executeJavaScript("getMarkerPosLat()"), (Double) frame.executeJavaScript("getMarkerPosLon()")));
        event.setDate_ev(Timestamp.valueOf(dateTime.getValue().atStartOfDay()));
        event.setDescription_ev(t4.getText());
        event.setEquipement_ev(t3.getText());
        event.setPoster(StorageService.getInstance().upload(posterFileInput)); 
        String catVal = (String) category.getValue();
        event.setType_ev(catVal);
        ServiceEvent.getInstance().insert(event);
        browser.close();
        // engine.close();
        close.getScene().getWindow().hide();
        FXMLLoader AddActivityLoader = new FXMLLoader(getClass().getResource("AddActivity.fxml"));
        Parent AddActivityView = AddActivityLoader.load();
        Stage AddActivityStage = new Stage();
        AddActivityStage.setScene(new Scene(AddActivityView));
        AddActivityStage.initModality(Modality.APPLICATION_MODAL);
        AddActivityStage.showAndWait();
    }

    @FXML
    public void onClose(ActionEvent actionEvent) {
        browser.close();
        // engine.close();
        close.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        category.getItems().addAll("MUSIC","PAINT","POETRY","THEATER","DANCE");
        fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png"));
        engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED).licenseKey("6P830J66YAHR0SZU0NCR697SI131EC20F6ZG5KJ02OTYTXMYOZTKSBIZ7R7EY3WPWIPD").build());
        browser = engine.newBrowser();
        view = BrowserView.newInstance(browser);
        locationPane.setCenter(view);
        navigation = browser.navigation();
        navigation.loadUrlAndWait("http://localhost/l/", com.teamdev.jxbrowser.time.Timestamp.fromSeconds(45));
        frame = browser.mainFrame().get();
        frame.executeJavaScript("initAdd()");
       
    }
}

     

    
    //private void AddEvent(ActionEvent event) {
    //}

    /*private void moov(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AddActivity.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
*/

    
    