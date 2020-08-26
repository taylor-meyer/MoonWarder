package main;

import Entities.Character;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainMenuWindow extends Stage {

    public MainMenuWindow() {
        this.setTitle("MoonWarder");

        // New Game button
        Button btn_newGame = new Button("New Game");
        btn_newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                close();
                //new CreateCharacterWindow();
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
                String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\"
                        + "moonwarder_character.json";

                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new FileReader(filePath));
                } catch (FileNotFoundException e) {
                    System.out.println("Character file was not found!");
                    //e.printStackTrace();
                }

                if (bufferedReader != null) {
                    Gson gson = new Gson();
                    Character C = gson.fromJson(bufferedReader, Character.class);
                    PlayWindow pw = new PlayWindow(C);
                    pw.show();
                    close();
                }
            }
        });

        Text text_title = new Text("MoonWarder");
        text_title.setStyle("-fx-font-size: 20");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_title, btn_newGame, btn_load, btn_exit);
        vbox.setAlignment(Pos.CENTER);

        this.setScene(new Scene(vbox, 300,300));
        this.show();
    }
}
