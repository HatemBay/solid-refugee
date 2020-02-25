package donation;

import Entities.Event;
import Services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class EventsAdminList implements Initializable {

    public Button add;
    public VBox list;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Can Do It Functionally
        ServiceEvent.getInstance().displayAll().forEach(event -> {
            try {
                list.getChildren().add(generateAdminEventCard(event));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    public void onClickAdd(ActionEvent actionEvent) throws IOException {
        Parent EventsAdminAddView = FXMLLoader.load(getClass().getResource("AddEvent.fxml"));
        Stage EventsAdminAddStage = new Stage();
        EventsAdminAddStage.setScene(new Scene(EventsAdminAddView));
        EventsAdminAddStage.initModality(Modality.APPLICATION_MODAL);
        EventsAdminAddStage.showAndWait();
        list.getChildren().clear();
        initialize(null, null);
    }
    private Parent generateAdminEventCard(Event event) throws IOException {
        FXMLLoader eventCardLoader = new FXMLLoader(getClass().getResource("EventsAdminEventCard.fxml"));
        Parent eventCardView = eventCardLoader.load();
        EventsAdminEventCard eventCardController = eventCardLoader.getController();
        eventCardController.init(event);
        return eventCardView;
    }
}
