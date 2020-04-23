package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MapCell mc = new MapCell(1, 1, MapCell.Type.GRASSLAND);
        Stage stage = new Stage();
        stage.setScene(new Scene(mc, 100, 100));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
