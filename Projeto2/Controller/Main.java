package Controller;

import Models.PokemonIncubator;
import Models.Egg;

public class Main {
    public static void main(String[] args) {
        PokemonIncubator incubator = new PokemonIncubator();
        long totalWaitingTime = 0;

        // vetor de ovos (Threads)
        Egg[] eggs = new Egg[6];

        // instancia o vetor
        for (int i = 1; i <= 6; i++) {
            eggs[i - 1] = new Egg(incubator);
        }

        // inicia as threads na ordem em que foram criadas
        for (int i = 1; i <= 6; i++) {
            try {
                eggs[i - 1].start();
                // Aguarda a conclusão da thread atual antes de iniciar a próxima
                eggs[i - 1].join();

                if(i == 1){
                    System.out.println("Thread 1 waiting time: 0 ms");
                }

                if(i != 1){
                    long waitingTime = eggs[i - 2].getWaitingTime();
                    totalWaitingTime += waitingTime;
                    System.out.println("Thread " + i + " waiting time: " + totalWaitingTime + " ms");
                }

                long spentTime = eggs[i - 1].getWaitingTime();
                System.out.println("Thread " + i + " spent time: " + spentTime + " ms");
            } catch (InterruptedException e) {
                System.err.println("Thread " + i + " was interrupted.");
            }
        }

        double averageWaitingTime = totalWaitingTime / (double) eggs.length;
        System.out.println("Average waiting time: " + Math.round(averageWaitingTime) + " ms");
    }
}
