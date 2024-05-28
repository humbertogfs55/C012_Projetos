package Models;

public class Egg extends Thread {
    private PokemonIncubator incubator;
    private long startTime;
    private long endTime;
    private long waitingTime;

    public Egg(PokemonIncubator incubator) {
        this.incubator = incubator;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        this.incubator.incubate();
        endTime = System.currentTimeMillis();
        waitingTime = endTime - startTime;
    }

    public long getWaitingTime() {
        return waitingTime;
    }
}
