package Models;

import java.util.Random;

public class PokemonIncubator {
    // #region collors
    // ANSI color codes
    private static final Random rand = new Random();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // #endregion
    // This method is a critical section and will be synchronized
    public synchronized void incubate() {
        Pokemon pokemon = Pokemon.randomPokemon();
        int stepsRequired = pokemon.getStepsRequired();
        int stepsTaken = 0;
        String color = getColor();

        System.out.println(color + "An egg is being incubated. Steps required: " + stepsRequired);

        // Simulate incubation process
        while (stepsTaken < stepsRequired) {
            try {
                Thread.sleep(300); // each step takes .3 seconds
            } catch (InterruptedException e) {
                System.err.println("Incubation interrupted for " + pokemon.getName());
            }
            stepsTaken++;
            System.out.println("Total steps: " + stepsTaken);
        }
        System.out.println(color + pokemon.getName() + " has hatched!");
    }

    private String getColor() {
        String[] colors = { ANSI_RED, ANSI_GREEN, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE };
        return colors[rand.nextInt(colors.length)];
    }
}