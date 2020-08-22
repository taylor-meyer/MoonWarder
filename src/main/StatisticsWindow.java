package main;

import Entities.Character;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StatisticsWindow extends VBox {

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
        text.setStyle("-fx-font-family: monospace; -fx-font-size: 16px");

        this.getChildren().add(text);
    }
}
