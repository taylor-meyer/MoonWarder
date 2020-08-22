package Inventory;

import Entities.Item;

public class Equipment {

    /* TODO */
    // Items that are currentl equipped and are affecting the player statistically

    private Item head;
    private Item body;
    private Item trinket;
    private Item mainHand;
    private Item offHand;

    public Equipment(Item head, Item body, Item trinket, Item mainHand, Item offHand) {
        this.head = head;
        this.body = body;
        this.trinket = trinket;
        this.mainHand = mainHand;
        this.offHand = offHand;
    }

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getBody() {
        return body;
    }

    public void setBody(Item body) {
        this.body = body;
    }

    public Item getTrinket() {
        return trinket;
    }

    public void setTrinket(Item trinket) {
        this.trinket = trinket;
    }

    public Item getMainHand() {
        return mainHand;
    }

    public void setMainHand(Item mainHand) {
        this.mainHand = mainHand;
    }

    public Item getOffHand() {
        return offHand;
    }

    public void setOffHand(Item offHand) {
        this.offHand = offHand;
    }
}
