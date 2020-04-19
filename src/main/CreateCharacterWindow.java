package main;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateCharacterWindow extends Stage {

    private Character C;

    public CreateCharacterWindow() {
        this.setTitle("MoonWarder");

        // GUI
        Text text_title = new Text("Character Creation");
        text_title.setStyle("-fx-font-size: 16px");

        Text text_name = new Text("Name: ");
        TextField textfield_name = new TextField();

        // ComboBox
        Text text_job = new Text("Job: ");
        String[] jobs = {"Fighter", "Wizard", "Thief"};
        ComboBox combobox_jobs = new ComboBox(FXCollections.observableArrayList(jobs));
        Button btn_create = new Button("Create");

        // Character factory
        CharacterFactory cf = new CharacterFactory();
        btn_create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                C = cf.getNewCharacter(textfield_name.getText(), combobox_jobs.getValue().toString());
                close();
                new StatisticsWindow(C);
            }
        });

        HBox[] rows = {new HBox(), new HBox()};
        rows[0].getChildren().addAll(text_name, textfield_name);
        rows[0].setAlignment(Pos.CENTER);
        rows[1].getChildren().addAll(text_job, combobox_jobs);
        rows[1].setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_title, rows[0], rows[1], btn_create);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        this.setScene(new Scene(vbox, 300, 300));
        this.show();
    }
}
