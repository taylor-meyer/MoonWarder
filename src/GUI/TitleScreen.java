package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TitleScreen extends Stage {

    public TitleScreen () {
        this.setTitle("Moonwarder");

        Text title = new Text("Moonwarder");
        title.setStyle("-fx-font-size: 20");

        // New Game button
        Button btn_newGame = new Button("New Game");
        btn_newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setScene(new Scene(new CharacterCreationScreen(), 300, 300));
            }
        });

        // Exit button
        Button btn_exit = new Button("Exit");
        btn_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        // Load Button
        Button btn_load = new Button("Load");
        btn_load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /* TODO */
                // Load character
            }
        });


        HBox buttonHBox = new HBox(btn_newGame, btn_exit, btn_load);
        buttonHBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(title, buttonHBox);
        vbox.setAlignment(Pos.CENTER);

        this.setScene(new Scene(vbox, 300,300));
        this.show();
    }
}
