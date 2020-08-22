package Entities;

public class Entity {

    /* TODO */
    // Rework structure such that character and future npcs/buildings etc. are
    // inheriting this class
    private String name;
    private int Xpos;
    private int Ypos;

    public Entity(String name, int xpos, int ypos) {
        this.name = name;
        Xpos = xpos;
        Ypos = ypos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXpos() {
        return Xpos;
    }

    public void setXpos(int xpos) {
        Xpos = xpos;
    }

    public int getYpos() {
        return Ypos;
    }

    public void setYpos(int ypos) {
        Ypos = ypos;
    }
}
