package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayWindow extends Stage {

    public PlayWindow(Character C) {

        Text title = new Text("MoonWarder");
        title.setStyle("-fx-font-size: 32px; -fx-font-family: Monospace");
        HBox hbox = new HBox();
        hbox.getChildren().add(title);
        hbox.setPadding(new Insets(5, 0, 10, 5));

        BorderPane bp = new BorderPane();
        bp.setTop(hbox);

        StatisticsWindow sf = new StatisticsWindow(C);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                C.saveToJSON();
            }
        });

        sf.getChildren().add(saveButton);

        sf.setPadding(new Insets(5, 5, 5, 5));
        bp.setLeft(sf);

        InventoryVBox inventoryVBox = new InventoryVBox(C);
        inventoryVBox.setPadding(new Insets(5, 5, 5, 5));
        inventoryVBox.setAlignment(Pos.TOP_LEFT);
        bp.setRight(inventoryVBox);

        Map m = new Map();
        m.setAlignment(Pos.CENTER);
        bp.setCenter(m);
        bp.setStyle("-fx-background-color: grey");
        this.setScene(new Scene(bp, 700, 400));
    }
}
