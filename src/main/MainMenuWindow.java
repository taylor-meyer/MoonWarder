package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenuWindow extends Stage {

    public MainMenuWindow() {
        this.setTitle("MoonWarder");

        // New Game button
        Button btn_newGame = new Button("New Game");
        btn_newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                close();
                new CreateCharacterWindow();
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

        Text text_title = new Text("MoonWarder");
        text_title.setStyle("-fx-font-size: 20");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_title, btn_newGame, btn_exit);
        vbox.setAlignment(Pos.CENTER);

        this.setScene(new Scene(vbox, 300,300));
        this.show();
    }
}
