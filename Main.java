public class Main {
    public static void main(String[] args) {
        // Instance of this class
        Modell modell = new Modell();
        CarView frame = new CarView("Carsim2.0");
        Controller controller = new Controller(modell, frame);

        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

}
