public class Main {
    public static void main(String[] args) {
        // Instance of this class
        DrawPanel draw = new DrawPanel(800,540);
        Modell modell = new Modell();
        View frame = new View("Carsim2.0",draw);
        modell.addObserver(draw);
        Controller controller = new Controller(modell, frame);
        modell.startTimer();
    }

}
