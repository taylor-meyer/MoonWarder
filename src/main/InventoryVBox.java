package main;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class InventoryVBox extends VBox {

    public InventoryVBox(Character C) {

        String str;

        str = String.format("%3s %s\n", "Gold:", C.getGold());

        for (Item item : C.getInventory().getItems()) {
            str += String.format(
                    "%3s\n", item.getName()
            );
        }

        Text text = new Text(str);
        text.setStyle("-fx-font-family: monospace; -fx-font-size: 16px");

        this.getChildren().add(text);
    }
}
