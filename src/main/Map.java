package main;

import javafx.scene.layout.GridPane;

public class Map extends GridPane {

    private final int width = 5;
    private final int height = 5;

    public Map() {
        this.setHgap(5);
        this.setVgap(5);
        build();
    }

    private void build() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.add(new MapCell(i, j, LocationType.GRASSLAND), i, j);
            }
        }
    }
}
