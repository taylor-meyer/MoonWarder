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
    private Text text_stats;

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
                C.setName(textfield_name.getText());
                if (combobox_jobs.getValue() == null)
                    C.setJob("Bard");
                else
                    C.setJob(combobox_jobs.getValue().toString());
                PlayWindow pw = new PlayWindow(C);
                close();
                pw.show();
            }
        });

        HBox[] rows = {new HBox(), new HBox()};
        rows[0].getChildren().addAll(text_name, textfield_name);
        rows[0].setAlignment(Pos.CENTER);
        rows[1].getChildren().addAll(text_job, combobox_jobs);
        rows[1].setAlignment(Pos.CENTER);



        // Statistics
        this.text_stats = new Text();
        C = cf.getNewCharacter();
        this.refreshCharacter(C);

        Button btn_reroll = new Button("Reroll");
        btn_reroll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                C = cf.getNewCharacter();
                refreshCharacter(C);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_title, rows[0], rows[1], this.text_stats, btn_reroll, btn_create);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        this.setScene(new Scene(vbox, 500, 500));
        this.show();
    }

    private void refreshCharacter(Character C) {
        String stats = String.format(
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s",
                "Level:", C.getLevel(),
                "Experience:", C.getExperience(),
                "Health:", C.getHealthpoints(),
                "Strength:", C.getStrength(),
                "Dexterity:", C.getDexterity(),
                "Constitution:", C.getConstitution(),
                "Intelligence:", C.getIntelligence(),
                "Charisma:", C.getCharisma(),
                "Wisdom:", C.getWisdom(),
                "Gold:", C.getGold()
        );
        this.text_stats.setText(stats);
        this.text_stats.setStyle("-fx-font: 14 monospace");
    }
}
