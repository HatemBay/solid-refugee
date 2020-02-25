package donation;

import Entities.Event;
import Entities.User;
import Services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EventsAdminEventMemberCard {

    public Button kick;
    public Label name;
    Event event;
    User user;

    public void init(Event event, User user) {
        this.event = event;
        this.user = user;
        name.setText(this.user.getName());
    }
    @FXML
    public void onClickKick(ActionEvent actionEvent) {
        
        // Refresh List
    }
}
