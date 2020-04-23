package main;

import javafx.scene.layout.StackPane;

public class MapCell extends StackPane {

    enum Type {
        DESERT,
        GRASSLAND,
        FORREST,
        WATER,
        TOWN
    }

    private final int XPOS;
    private final int YPOS;
    private final Type type;

    public MapCell(int XPOS, int YPOS, Type type ){
        this.XPOS = XPOS;
        this.YPOS = YPOS;
        this.type = type;

        if (this.type == Type.TOWN)
            this.setStyle("-fx-background-color: grey");
        else if (this.type == Type.DESERT)
            this.setStyle("-fx-background-color: #EDC9AF");
        else if (this.type == Type.WATER)
            this.setStyle("-fx-background-color: blue");
        else if (this.type == Type.FORREST)
            this.setStyle("-fx-background-color: #228B22");
        else if (this.type == Type.GRASSLAND)
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

    public Type getType() {
        return type;
    }
}
