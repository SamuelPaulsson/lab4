public class Main {
    public static void main(String[] args) {
        // Instance of this class
        Modell modell = new Modell();
        View frame = new View("Carsim2.0");
        modell.addObserver(frame);
        Controller controller = new Controller(modell, frame);
        modell.startTimer();
    }

}
