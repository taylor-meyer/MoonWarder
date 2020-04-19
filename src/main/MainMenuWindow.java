package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuWindow extends Stage {

    private Button btn_newGame;
    private Button btn_exit;

    public MainMenuWindow() throws Exception {

        // New Game button
        this.btn_newGame = new Button("New Game");
        this.btn_newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new CreateCharacterWindow();
                close();
            }
        });

        // Exit button
        this.btn_exit = new Button("Exit");
        this.btn_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(this.btn_newGame, this.btn_exit);

        this.setTitle("MoonWarder");
        this.setScene(new Scene(vbox, 300,400));
        this.show();
    }
}
