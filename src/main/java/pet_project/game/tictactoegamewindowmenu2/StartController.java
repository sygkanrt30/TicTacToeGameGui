package pet_project.game.tictactoegamewindowmenu2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private AnchorPane start;

    @FXML
    private Button startBtn;

    @FXML
    void btnStart(ActionEvent event) throws IOException {
        System.out.println("Игра началась!!!");
        createWindow();

    }

    void createWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tic_tac_toe.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 528, 528);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}







