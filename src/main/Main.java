package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Map m = new Map();
        BorderPane bp = new BorderPane();
        bp.setCenter(m);
        Stage stage = new Stage();
        stage.setScene(new Scene(bp, 300, 300));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
