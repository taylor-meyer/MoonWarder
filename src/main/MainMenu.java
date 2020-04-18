package main;

import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Stage {

    private Button btn_newGame;
    private Button btn_exit;

    public MainMenu() throws Exception {

        this.btn_newGame = new Button("New Game");
        this.btn_exit = new Button("Exit");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(this.btn_newGame, this.btn_exit);

        this.setTitle("MoonWarder");
        this.setScene(new Scene(vbox, 300,400));
        this.show();
    }
}
