package donation;

import Entities.Event;
import Services.ServiceEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class EventsAdminEventCard {
    public Label name;
    public Button update;
    public Button remove;
    public Button updateMembers;
    private Event event;

    public void init(Event event) {
        this.event = event;
        this.name.setText(this.event.getName_ev());
    }
    public void onClickUpdateMembers(ActionEvent actionEvent) throws IOException {
        FXMLLoader eventsAdminUpdateMembersLoader = new FXMLLoader(getClass().getResource("EventsAdminUpdateMembers.fxml"));
        Parent eventsAdminUpdateMembersView = eventsAdminUpdateMembersLoader.load();
        EventsAdminUpdateMembers eventsAdminUpdateMembersController = eventsAdminUpdateMembersLoader.getController();
        eventsAdminUpdateMembersController.init(event);
        Stage eventsAdminUpdateMembersStage = new Stage();
        eventsAdminUpdateMembersStage.setScene(new Scene(eventsAdminUpdateMembersView));
        eventsAdminUpdateMembersStage.initModality(Modality.APPLICATION_MODAL);
        eventsAdminUpdateMembersStage.showAndWait();
    }
    public void onClickUpdate(ActionEvent actionEvent) throws IOException {
        FXMLLoader eventsAdminUpdateLoader = new FXMLLoader(getClass().getResource("EventsAdminUpdate.fxml"));
        Parent eventsAdminUpdateView = eventsAdminUpdateLoader.load();
        EventsAdminUpdate eventsAdminUpdateController = eventsAdminUpdateLoader.getController();
        eventsAdminUpdateController.init(event);
        Stage eventsAdminUpdateStage = new Stage();
        eventsAdminUpdateStage.setScene(new Scene(eventsAdminUpdateView));
        eventsAdminUpdateStage.initModality(Modality.APPLICATION_MODAL);
        eventsAdminUpdateStage.showAndWait();
    }

    public void onClickRemove(ActionEvent actionEvent) throws SQLException, IOException {
        ServiceEvent.getInstance().delete(event.getId_ev());
        FXMLLoader EventsAdminListLoader = new FXMLLoader(getClass().getResource("EventsAdminList.fxml"));
        Parent EventsAdminListView = EventsAdminListLoader.load();
        Stage eventsAdminUpdateMembersStage = new Stage();
        eventsAdminUpdateMembersStage.setScene(new Scene(EventsAdminListView));
        eventsAdminUpdateMembersStage.initModality(Modality.APPLICATION_MODAL);
        eventsAdminUpdateMembersStage.showAndWait();

    }
}
