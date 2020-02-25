package donation;

import Entities.Event;
import Services.ServiceEvent;
import Interfaces.StorageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;

public class EventsUserEventCard {
    public ImageView poster;
    public Label name;
    public Button joinLeave;
    public Button details;
    private Event event;
   

    public void init(Event event) throws IOException {
        this.event = event;
        this.name.setText(event.getName_ev());
        this.poster.setImage(new Image(StorageService.getInstance().download(event.getPoster())));
    }

    @FXML
    public void onClickJoinLeave(ActionEvent actionEvent) {
        //to be con
        ServiceEvent.getInstance().update(event);
    }

    @FXML
    public void onClickDetails(ActionEvent actionEvent) throws IOException {
        FXMLLoader eventsUserPageLoader = new FXMLLoader(getClass().getResource("EventsUserEventPage.fxml"));
        Parent eventsUserPageView = eventsUserPageLoader.load();
        EventsUserEventPage eventsUserEventPageController = eventsUserPageLoader.getController();
        eventsUserEventPageController.init(event);
        Stage eventsUserPageStage = new Stage();
        eventsUserPageStage.setScene(new Scene(eventsUserPageView));
        eventsUserPageStage.initModality(Modality.APPLICATION_MODAL);
        eventsUserPageStage.showAndWait();
    }
}
