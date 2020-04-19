package main;

import java.util.Random;

public class CharacterFactory {

    private Random random = new Random();

    /**
     * Generates starting gold and random stats.
     * @param name The character's name.
     * @return The Character object.
     */
    public Character getNewCharacter(String name, String job) {
        int level = 1;
        int experience = 0;

        int strength = random.nextInt(9) + 1;
        int dexterity = random.nextInt(9) + 1;
        int constitution = random.nextInt(9) + 1;
        int intelligence = random.nextInt(9) + 1;
        int wisdom = random.nextInt(9) + 1;
        int charisma = random.nextInt(9) + 1;

        int gold = random.nextInt(150) + 50;

        Character C = new Character(name, job, level, experience, strength, dexterity, constitution, intelligence,
                wisdom, charisma, gold);
        return C;
    }
}
