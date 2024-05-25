package Models;

import java.util.Random;

public class Pokemon {
    private String name;
    private int stepsRequired;
    private static final Random rand = new Random();

    public Pokemon(String name, int stepsRequired) {
        this.name = name;
        this.stepsRequired = stepsRequired;
    }

    public String getName() {
        return name;
    }
    public int getStepsRequired(){
        return stepsRequired;
    }

    public static Pokemon randomPokemon() {
        String[] pokemonNames = {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff"
        };
        String randomName = pokemonNames[rand.nextInt(pokemonNames.length)];
        int stepsRequired = rand.nextInt(20) + 10;
        return new Pokemon(randomName, stepsRequired);
    }
}
