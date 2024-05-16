package Controller;

import Models.PokemonIncubator;
import Models.Egg;

public class Main {
    public static void main(String[] args) {
        PokemonIncubator incubator = new PokemonIncubator();

        // vector of eggs(Threads)
        Egg[] eggs = new Egg[6];

        // instantiates the vector
        for (int i = 1; i <= 6; i++) {
            eggs[i - 1] = new Egg(incubator);
        }

        // inicia as threads
        for (int i = 1; i <= 6; i++) {
            eggs[i - 1].start();
        }
    }
}
