package donation;

import Entities.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class EventsAdminUpdateMembers {
    public Button close;
    public VBox list;
    private Event event;

    public void init(Event event) {
        //to do
    }
    public void onClose(ActionEvent actionEvent) {
        close.getScene().getWindow().hide();
    }
    
}
