package main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MovementExample extends Stage {

    int XPos = 0;
    int YPos = 9;

    Image playerImage;
    Image town;
    ImageView v = null;

    ImageView vTown = null;

    //StackPane playerLoc;

    public MovementExample() {

        try {
            FileInputStream inputstream = new FileInputStream("player.png");
            playerImage = new Image(inputstream);
            v = new ImageView(playerImage);

        } catch (FileNotFoundException e) {
            System.out.println("player Image not found");
        }

        try {
            FileInputStream inputstream = new FileInputStream("town.png");
            town = new Image(inputstream);
            vTown = new ImageView(town);

        } catch (FileNotFoundException e) {
            System.out.println("town Image not found");
        }

        GridPane ground = new GridPane();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                StackPane sp = new StackPane();
                sp.setMinHeight(50);
                sp.setMinWidth(50);
                sp.setStyle("-fx-background-color: green");

                if (i == 1 && j == 1) {
                    sp.getChildren().add(vTown);
                }

                if (i == 0 && j == 9 && v != null) {
                    sp.getChildren().add(v);
                }

                ground.add(sp, i, j);
            }
        }

        ground.setHgap(1);
        ground.setVgap(1);
        ground.setStyle("-fx-background-color: #000000");

        Scene scene = new Scene(ground);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT) {

                    if (XPos != 9) {
                        StackPane sp = (StackPane) (ground.getChildren().get(XPos * 10 + YPos));
                        sp.getChildren().remove(v);

                        StackPane new_sp = (StackPane) (ground.getChildren().get((XPos + 1) * 10 + YPos));
                        new_sp.getChildren().add(v);

                        XPos += 1;
                    }

                } else if (event.getCode() == KeyCode.LEFT) {

                    if (XPos != 0) {
                        StackPane sp = (StackPane) (ground.getChildren().get(XPos * 10 + YPos));
                        sp.getChildren().remove(v);

                        StackPane new_sp = (StackPane) (ground.getChildren().get((XPos - 1) * 10 + YPos));
                        new_sp.getChildren().add(v);

                        XPos -= 1;
                    }

                } else if (event.getCode() == KeyCode.UP) {

                    if (YPos != 0) {
                        StackPane sp = (StackPane) (ground.getChildren().get(XPos * 10 + YPos));
                        sp.getChildren().remove(v);

                        StackPane new_sp = (StackPane) (ground.getChildren().get(XPos * 10 + (YPos - 1)));
                        new_sp.getChildren().add(v);

                        YPos -= 1;
                    }

                } else if (event.getCode() == KeyCode.DOWN) {

                    if (YPos != 9) {
                        StackPane sp = (StackPane) (ground.getChildren().get(XPos * 10 + YPos));
                        sp.getChildren().remove(v);

                        StackPane new_sp = (StackPane) (ground.getChildren().get(XPos * 10 + (YPos + 1)));
                        new_sp.getChildren().add(v);

                        YPos += 1;
                    }

                }
            }
        });

        this.setScene(scene);
        this.show();

    }
}
