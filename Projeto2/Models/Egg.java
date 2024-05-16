package Models;

public class Egg extends Thread {
    private PokemonIncubator incubator;

    public Egg(PokemonIncubator incubator) {
        this.incubator = incubator;
    }

    @Override
    public void run() {
        this.incubator.incubate();
    }
}
