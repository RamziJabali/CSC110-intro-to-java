package com.company;

import java.util.*;

public class Die {
    private static final int DEFAULT_SIDE_COUNT_OF_DIE = 6;
    private static Random rand = new Random();

    private final int sideCountOfDie;
    private int rollOfTheDie;

    /**
     * Default constructor sets the default
     * amount of sides a sideCountOfDie has, and performs
     * an initial roll of the sideCountOfDie.
     */

    Die() {
        sideCountOfDie = DEFAULT_SIDE_COUNT_OF_DIE;
        rollDie();
    }

    /**
     * This constructors sets the amount of sides
     * to the liking of the user, and performs an
     * initial roll of the sideCountOfDie.
     *
     * @param numSides The number of sides for this sideCountOfDie.
     */

    Die(int numSides) {
        sideCountOfDie = numSides;
        rollDie();
    }

    /**
     * The rollOfDie method simulates the rolling
     * of the sideCountOfDie.
     */

    public void rollDie() {
        rollOfTheDie = rand.nextInt(sideCountOfDie) + 1;
    }

    public int getRollOfTheDie(){
        return rollOfTheDie;
    }

    /**
     * getSideCountOfDie method
     *
     * @return the value of the sideCountOfDie.
     */

    public int getSideCountOfDie() {
        return sideCountOfDie;
    }

    /**
     * getRollOfDie method
     *
     * @return The value of rolling the sideCountOfDie
     */

    public int getRollOfDie() {
        return rollOfTheDie;
    }
}
