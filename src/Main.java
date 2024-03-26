
public class Main {
    public void main(String[] args) {
        int raceLenght = 5000;

        Car c1 = new Car("Camaro", 10, raceLenght);
        Car c2 = new Car("Ferrari", 20, raceLenght);
        Car c3 = new Car("Lambo", 30, raceLenght);

        c1.start();
        c2.start();
        c3.start();

        while (c1.isAlive() || c2.isAlive() || c3.isAlive()) {

            displayRaceProgress(c1, c2, c3);
        }
    }

    private void displayRaceProgress(Car c1, Car c2, Car c3) {
    System.out.print("\033[H");
    System.out.flush();

    // Print the progress of each car on the same line
    System.out.println(c1.name + ": " + c1.progressString(c1) + "   "
                     + c2.name + ": " + c2.progressString(c2) + "   "
                     + c3.name + ": " + c3.progressString(c3));
    }
}