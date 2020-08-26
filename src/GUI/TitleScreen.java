package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TitleScreen extends Stage {

    public TitleScreen () {
        this.setTitle("MoonWarder");

        Text title = new Text("Moonwarder");
        title.setStyle("-fx-font-size: 20");

        HBox hbox = new HBox();
        hbox.getChildren().add(title);
        hbox.setAlignment(Pos.CENTER);

        this.setScene(new Scene(hbox, 300,300));
        this.show();
    }
}
