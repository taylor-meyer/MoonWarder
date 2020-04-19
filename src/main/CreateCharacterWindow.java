package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateCharacterWindow extends Stage {

    private Character C;

    public CreateCharacterWindow() {

        // GUI things
        Text text_name = new Text("Name: ");
        TextField textfield_name = new TextField();
        Text text_job = new Text("Job: ");
        TextField textfield_job = new TextField();
        Button btn_create = new Button("Create");
        // Fills later
        Text text_enteredName = new Text();

        // Character factory
        CharacterFactory cf = new CharacterFactory();

        btn_create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                C = cf.getNewCharacter(textfield_name.getText(), textfield_job.getText());
                //text_enteredName.setText(C.getName());
                close();
                new StatisticsWindow(C);
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_name, textfield_name,
                text_job, textfield_job, btn_create, text_enteredName);

        this.setScene(new Scene(vbox, 300, 400));
        this.show();
    }
}
