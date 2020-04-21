package main;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Map extends Stage {

    private GridPane gp;

    public Map() {
        this.setTitle("Map");

        gp = new GridPane();

        gp.setHgap(5);
        gp.setVgap(5);

        gp.setAlignment(Pos.CENTER);

        gp.setStyle("-fx-background-color: #000000");


        this.setColors();


        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        this.setScene(new Scene(bp, 500, 500));
        this.show();
    }

    private void setColors() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StackPane sp = new StackPane();
                sp.setMinHeight(50);
                sp.setMinWidth(50);

                /*
                green -> grassland
                grey -> town
                blue -> water
                tan -> desert
                 */

                if (i == 1 && j == 1)
                    sp.setStyle("-fx-background-color: grey");
                else if (i >= 3 && j >= 3)
                    sp.setStyle("-fx-background-color: #EDC9AF");
                else if ((i == 0 && j >= 1) ||
                         (i == 1 && j >= 2))
                    sp.setStyle("-fx-background-color: blue");
                else
                    sp.setStyle("-fx-background-color: green");

                gp.add(sp, i, j);
            }
        }
    }
}
