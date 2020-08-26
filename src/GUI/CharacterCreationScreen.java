package GUI;

import Entities.Character;
import Entities.Stats;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.CharacterFactory;
import main.PlayWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CharacterCreationScreen extends HBox {

    private Stats stats;
    private Text statsText;

    public CharacterCreationScreen() {

        this.statsText = new Text();
        this.statsText.setStyle("-fx-font: 14 monospace");
        rerollStats();

        Text namePrompt = new Text("Name: ");
        TextField nameTextField = new TextField();

        HBox nameHBox = new HBox(namePrompt, nameTextField);


        Button rerollButton = new Button("Reroll");
        rerollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rerollStats();
            }
        });

        Button createButton = new Button("Create");
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /* TODO */
                // Start game
            }
        });

        HBox buttonHBox = new HBox(rerollButton, createButton);

        VBox left = new VBox();
        left.getChildren().addAll(nameHBox, this.statsText, buttonHBox);
        left.setAlignment(Pos.CENTER);
        left.setSpacing(10);

        /* TODO */
        // VBox right would show a character sprite and ability to cycle to different ones
        Image playerImage ;
        ImageView v = null;
        try {
            FileInputStream inputstream = new FileInputStream("player.png");
            playerImage = new Image(inputstream);
            v = new ImageView(playerImage);
            v.setFitHeight(100);
            v.setFitWidth(100);
            v.setPreserveRatio(true);

        } catch (FileNotFoundException e) {
            System.out.println("player Image not found");
        }

        VBox right = new VBox(v);
        right.setAlignment(Pos.CENTER);

        this.getChildren().addAll(left, right);
    }

    private void rerollStats() {
        this.stats = new Stats();
        int hp = this.stats.getConstitution() * 9;
        String stats = String.format(
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s\n" +
                "%13s %-3s",
                "Level:", "1",
                "Health:", hp,
                "Strength:", this.stats.getStrength(),
                "Dexterity:", this.stats.getDexterity(),
                "Constitution:", this.stats.getConstitution(),
                "Intelligence:", this.stats.getIntelligence(),
                "Charisma:", this.stats.getCharisma(),
                "Wisdom:", this.stats.getWisdom()
        );
        this.statsText.setText(stats);

    }
}
