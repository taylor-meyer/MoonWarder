package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayWindow extends Stage {

    public PlayWindow() {

        /* REMOVE LATER */
        CharacterFactory cf = new CharacterFactory();
        //////////////////

        Text title = new Text("MoonWarder");
        title.setStyle("-fx-font-size: 32px; -fx-font-family: Monospace");
        HBox hbox = new HBox();
        hbox.getChildren().add(title);
        hbox.setPadding(new Insets(5, 0, 10, 5));

        BorderPane bp = new BorderPane();
        bp.setTop(hbox);
        StatisticsWindow sf = new StatisticsWindow(cf.getNewCharacter("Lyp", "Fighter"));
        sf.setPadding(new Insets(5, 0, 0, 5));
        bp.setLeft(sf);
        bp.setCenter(new Map());
        bp.setStyle("-fx-background-color: grey");
        this.setScene(new Scene(bp, 700, 400));
    }
}
