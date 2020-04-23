package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PlayWindow pw = new PlayWindow();
        pw.show();
        pw.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
