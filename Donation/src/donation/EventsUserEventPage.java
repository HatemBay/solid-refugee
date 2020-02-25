package donation;

import Entities.Event;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class EventsUserEventPage implements Initializable {
    public ImageView poster;
    public Label name;
    public Label equipement;
    public Label description;
    public Label category;
    public Label dateTime;
    public Button close;
    public BorderPane locationPane;
    private Engine engine;
    private Browser browser;
    private BrowserView view;
    private Navigation navigation;
    private Frame frame;
    private Event event;
    

    public void init(Event event) throws IOException {
        this.event = event;
        this.name.setText(this.event.getName_ev());
        this.dateTime.setText(this.event.getDate_ev().toLocalDateTime().toLocalDate().toString());
        this.equipement.setText(this.event.getEquipement_ev());
        this.category.setText(this.event.getType_ev());
        this.description.setText(this.event.getDescription_ev());
        this.poster.setImage(new Image(StorageService.getInstance().download(this.event.getPoster())));
        frame.executeJavaScript("initDisplay(" + this.event.getLocation_ev().getLatitude() + "," + this.event.getLocation_ev().getLongitude() + ")");
    }

    @FXML
    public void onClose(ActionEvent actionEvent) {
        browser.close();
        // engine.close();
        close.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = Engine.newInstance(EngineOptions.newBuilder(RenderingMode.HARDWARE_ACCELERATED).licenseKey("6P830J66YAHR0SZU0NCR697SI131EC20F6ZG5KJ02OTYTXMYOZTKSBIZ7R7EY3WPWIPD").build());
        browser = engine.newBrowser();
        view = BrowserView.newInstance(browser);
        locationPane.setCenter(view);
        navigation = browser.navigation();
        navigation.loadUrlAndWait("http://localhost/l/", com.teamdev.jxbrowser.time.Timestamp.fromSeconds(45)); // Insert Maps URL
        frame = browser.mainFrame().get();
    }
}
