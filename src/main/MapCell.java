package main;

import javafx.scene.layout.StackPane;

public class MapCell extends StackPane {

    private final int XPOS;
    private final int YPOS;
    private final LocationType type;

    public MapCell(int XPOS, int YPOS, LocationType type ){
        this.setMinHeight(50);
        this.setMinWidth(50);

        this.XPOS = XPOS;
        this.YPOS = YPOS;
        this.type = type;

        if (this.type == LocationType.TOWN)
            this.setStyle("-fx-background-color: grey");
        else if (this.type == LocationType.DESERT)
            this.setStyle("-fx-background-color: #EDC9AF");
        else if (this.type == LocationType.WATER)
            this.setStyle("-fx-background-color: blue");
        else if (this.type == LocationType.FORREST)
            this.setStyle("-fx-background-color: #228B22");
        else if (this.type == LocationType.GRASSLAND)
            this.setStyle("-fx-background-color: #00ff00");
        else
            this.setStyle("-fx-background-color: black");

    }

    public int getXPOS() {
        return XPOS;
    }

    public int getYPOS() {
        return YPOS;
    }

    public LocationType getType() {
        return type;
    }
}
