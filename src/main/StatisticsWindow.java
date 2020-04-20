package main;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatisticsWindow extends Stage {

    public StatisticsWindow(Character C) {


        String str = String.format(
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s\n" +
                "%13s %s",
                "Name:", C.getName(),
                "Job:", C.getJob(),
                "Level:", C.getLevel(),
                "Experience:", C.getExperience(),
                "Strength:", C.getStrength(),
                "Dexterity:", C.getDexterity(),
                "Constitution:", C.getConstitution(),
                "Intelligence:", C.getIntelligence(),
                "Charisma:", C.getCharisma(),
                "Wisdom:", C.getWisdom(),
                "Gold:", C.getGold()
        );
        Text text = new Text(str);
        text.setStyle("-fx-font-family: monospace");


        VBox vbox = new VBox();
        vbox.getChildren().add(text);

        this.setScene(new Scene(vbox, 300, 400));
        this.show();
    }
}
