package com.company;

public class PairOfDice {

    private Die rollOfDie1;
    private Die rollOfDie2;

    /**
     * Default constructor that creates an instance
     * of the die class. Designed to  set the default
     * amount of sides a die has, and performs
     * an initial roll of the die.
     */

    public PairOfDice() {
        rollOfDie1 = new Die();
        rollOfDie2 = new Die();
    }

    /**
     * Overloaded constructor that creates an instance
     * of the die class. Designed to  set the
     * amount of sides a die has to that of the users choosing,
     * and performs an initial roll of the die.
     */

    public PairOfDice(final int sides) {
        rollOfDie1 = new Die(sides);
        rollOfDie2 = new Die(sides);
    }

    /**
     * Public method getSnakeEyes
     *
     * @return boolean class variable isSnakeEyes
     */

    public boolean isSnakeEyes() {
        return rollOfDie1.getRollOfDie() == 1 && rollOfDie2.getRollOfDie() == 1;
    }

    /**
     * Public method getBoxCars
     *
     * @return boolean class variable isBoxCars
     */

    public boolean isBoxCars() {
        return rollOfDie1.getRollOfDie() == 6 && rollOfDie2.getRollOfDie() == 6;
    }

    /**
     * Public method getIsDouble
     *
     * @return true or false depending on the circumstances.
     */

    public boolean isDoubles() {
        return !isSnakeEyes() && !isBoxCars() && rollOfDie1.getRollOfDie() == rollOfDie2.getRollOfDie();
    }

    public boolean isRegularPair() {
        return !isSnakeEyes() && !isBoxCars() && !isDoubles();
    }

    /**
     * Public method getRollOfDie1
     *
     * @return rollOfDie1
     */

    public Die getDie1() {
        return rollOfDie1;
    }

    public Die getDie2() {
        return rollOfDie2;
    }

    public void rollPairOfDice() {
        rollOfDie1.rollDie();
        System.out.print("\tRolled: " + rollOfDie1.getRollOfDie());
        rollOfDie2.rollDie();
        System.out.println(" and " + rollOfDie2.getRollOfDie());
    }

    /**
     * Public method getValuesOfRoll
     */

    public int getValuesOfRolls() {
        if (isSnakeEyes()) {
            return (rollOfDie1.getRollOfDie() + rollOfDie2.getRollOfDie());
        }
        if (isBoxCars()) {
            return 0;
        }
        if (isDoubles()) {
            return 0;
        }
        return rollOfDie1.getRollOfDie() + rollOfDie2.getRollOfDie();
    }
}
