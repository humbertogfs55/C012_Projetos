import java.util.Random;

public class Car extends Thread{
    public String name;
    private int speed;
    public int position = 0;
    public int raceLength;
    Random random = new Random();

    public Car() {}
    public Car(String name, int speed, int raceLength) {
        this.name = name;
        this.speed = speed;
        this.raceLength = raceLength;
    }

    public void Race() throws InterruptedException{
        
        position = speed;

        for(position=0; position <= raceLength; position += random.nextInt(100)){
            Thread.sleep(50);
        }
        System.out.print("\033[H");
        System.out.flush();
        System.out.println("! " + name + " Passou da linha de chegada!");
    }

    public String progressString(Car car) {
        int progress = position * 30 / raceLength;
        StringBuilder progressBar = new StringBuilder(30);
        progressBar.append("[");
        for (int i = 0; i < 30; i++) {
            if (i < progress) {
                progressBar.append("=");
            } else {
                progressBar.append(" ");
            }
        }
        progressBar.append("]");
        return progressBar.toString();
    }

    @Override
    public void run() {
        try {
            Race();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
