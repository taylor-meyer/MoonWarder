package main;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatisticsWindow extends Stage {

    private Text text_name = new Text("Name: ");
    private Text text_job = new Text("Job: ");
    private Text text_level = new Text("Level: ");
    private Text text_experience = new Text("Experience: ");
    private Text text_strength = new Text("Strength: ");
    private Text text_dexterity = new Text("Dexterity: ");
    private Text text_constitution = new Text("Constitution: ");
    private Text text_intelligence = new Text("Intelligence: ");
    private Text text_wisdom = new Text("Wisdom: ");
    private Text text_charisma = new Text("Charisma: ");
    private Text text_gold = new Text("Gold: ");

    public StatisticsWindow(Character C) {
        VBox vbox = new VBox();

        this.text_name.setText(this.text_name.getText() + C.getName());
        this.text_job.setText(this.text_job.getText() + C.getJob());
        this.text_level.setText(this.text_level.getText() + C.getLevel());
        this.text_experience.setText(this.text_experience.getText() + C.getExperience());
        this.text_gold.setText(this.text_gold.getText() + C.getGold());
        this.text_strength.setText(this.text_strength.getText() + C.getStrength());
        this.text_dexterity.setText(this.text_dexterity.getText() + C.getDexterity());
        this.text_constitution.setText(this.text_constitution.getText() + C.getConstitution());
        this.text_intelligence.setText(this.text_intelligence.getText() + C.getIntelligence());
        this.text_wisdom.setText(this.text_wisdom.getText() + C.getWisdom());
        this.text_charisma.setText(this.text_charisma.getText() + C.getCharisma());

        vbox.getChildren().addAll(this.text_name, this.text_job, this.text_level, this.text_experience,
            this.text_gold, this.text_strength, this.text_dexterity, this.text_constitution, this.text_intelligence,
            this.text_wisdom, this.text_charisma);

        this.setScene(new Scene(vbox, 300, 400));
        this.show();
    }
}
