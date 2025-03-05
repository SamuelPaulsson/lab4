public class Main {
    public static void main(String[] args) {
        // Instance of this class
        Modell modell = new Modell();
        CarView frame = new CarView("Carsim2.0");
        Controller controller = new Controller(modell, frame);
        modell.startTimer();
    }

}
