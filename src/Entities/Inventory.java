package Entities;



import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;
    private int gold;

    private int maxSize = 20;

    public Inventory(int gold) {
        this.items = new ArrayList();
        this.gold = gold;
    }

    public void addItem(Item item) {
        if(this.items.size() < maxSize)
            this.items.add(item);
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void subtractGold(int gold) {
        if (this.gold - gold < 0)
            this.gold = 0;
        else
            this.gold -= gold;
    }

    public boolean hasEnoughGold(int gold) {
        if (this.gold > gold)
            return true;
        else
            return false;
    }

    /* Getters & Setters */
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMax_size(int max_size) {
        this.maxSize = max_size;
    }
}
