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

    public CreateCharacterWindow() {

        Text text_name = new Text("Name: ");

        TextField textfield_name = new TextField();

        Button btn_create = new Button("Create");

        Text text_enteredName = new Text();

        Character C = new Character();

        btn_create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                C.setName(textfield_name.getText());
                text_enteredName.setText(C.getName());
            }
        });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(text_name, textfield_name, btn_create, text_enteredName);

        this.setScene(new Scene(vbox, 300, 400));
        this.show();
    }
}
