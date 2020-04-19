package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainMenuWindow main = new MainMenuWindow();
        Character C = new Character();
        C.setName("Taylor");
        C.setExperience(2200);
        C.setGold(450);
        System.out.println(C.getName());
        System.out.println(C.getExperience());
        System.out.println(C.getGold());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
