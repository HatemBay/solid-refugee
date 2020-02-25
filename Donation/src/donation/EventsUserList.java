package donation;

import Entities.Event;
import Services.ServiceEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class EventsUserList implements Initializable {
    public Button search;
    public TextField query;
    public GridPane grid;
    private int lastColumnIndex = -1;
    private int lastRowIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceEvent.getInstance().displayAll().forEach(event -> {
            try {
                int[] nextIndex = generateNextCardIndex();
                grid.add(generateUserEventCard(event), nextIndex[0], nextIndex[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    public void onClickSearch(ActionEvent actionEvent) throws SQLException {
        grid.getChildren().clear();
        lastColumnIndex = -1;
        lastRowIndex = 0;
        if (query.getText().isEmpty()) {initialize(null, null);}
        ServiceEvent.getInstance().displayAll().stream().filter(event -> event.getName_ev().equals(query.getText())).forEach((event -> {
            try {
                int[] nextIndex = generateNextCardIndex();
                grid.add(generateUserEventCard(event), nextIndex[0], nextIndex[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    private Parent generateUserEventCard(Event event) throws IOException {
            FXMLLoader eventCardLoader = new FXMLLoader(getClass().getResource("EventsUserEventCard.fxml"));
            Parent eventCardView = eventCardLoader.load();
            EventsUserEventCard eventCardController = eventCardLoader.getController();
            eventCardController.init(event);
        return eventCardView;
    }
    private int[] generateNextCardIndex() {
        if (lastColumnIndex == 2) {
            lastColumnIndex = 0;
            lastRowIndex++;
        } else {
            lastColumnIndex++;
        }
        return new int[] {lastColumnIndex, lastRowIndex};
    }
}