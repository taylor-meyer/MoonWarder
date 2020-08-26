package main;

import GUI.TitleScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new TitleScreen();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
