package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.JFileChooser;
import java.io.*;

public class Character {

    /* THE BASICS */
    private String name;
    private String job; // i.e. class
    private int healthpoints;
    private int level;
    private int experience;

    /*
        From DnD5e: https://roll20.net/compendium/dnd5e/Ability%20Scores#content
            Might not use them all exactly as they are used in DnD
        Strength, measuring physical power
        Dexterity, measuring agility
        Constitution, measuring endurance
        Intelligence, measuring reasoning and memory
        Wisdom, measuring Perception and Insight
        Charisma, measuring force of personality
     */

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private Inventory inventory;

    /* Not displayed to player */
    private int max_healthpoints;

    public Character() {

    }

    public Character(String name, String job, int level, int experience, int strength, int dexterity,
                     int constitution,int intelligence, int wisdom, int charisma, int gold) {
        this.name = name;
        this.job = job;

        this.max_healthpoints = 9 * constitution;
        this.healthpoints = this.max_healthpoints;

        this.level = level;
        this.experience = experience;

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;

        inventory = new Inventory(gold);

        // Test adding items
        inventory.addItem(new Item("Test Item 2"));
        inventory.addItem(new Item("Test Item 1"));
        inventory.addItem(new Item("Test Item 3"));
    }

    public Character(int level, int experience, int strength, int dexterity,
                     int constitution,int intelligence, int wisdom, int charisma, int gold) {
        this.name = "";
        this.job = "";
        this.level = level;
        this.experience = experience;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.max_healthpoints = 9 * this.constitution;
        this.healthpoints = this.max_healthpoints;
        inventory = new Inventory(gold);
        // Test adding items
        inventory.addItem(new Item("Test Item 2"));
        inventory.addItem(new Item("Test Item 1"));
        inventory.addItem(new Item("Test Item 3"));
    }

    public void heal(int n) {
        if(this.healthpoints + n > this.max_healthpoints)
            this.healthpoints = this.max_healthpoints;
        else
            this.healthpoints += n;
    }

    public void takeDamage(int n) {
        this.healthpoints -= n;
    }

    public void saveToJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(this);
        String filePath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "\\"
                + "moonwarder_character.json";

        try {
            System.out.println("Saving to: \"" + filePath + "\"");
            FileWriter fw = new FileWriter(filePath);
            fw.write(jsonString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* GETTERS AND SETTERS */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getGold() {
        return inventory.getGold();
    }

    public void setGold(int gold) {
        inventory.setGold(gold);
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMax_healthpoints() {
        return max_healthpoints;
    }

    public void setMax_healthpoints(int max_healthpoints) {
        this.max_healthpoints = max_healthpoints;
    }
}