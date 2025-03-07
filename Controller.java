public class Controller implements ButtonObserver {
    private final Modell modell;
    private final View frame;

    public Controller(Modell modell, View frame){
        this.modell = modell;
        this.frame = frame;
        frame.addObserver(this);
    }

    public void addCar() {
        modell.createRandCar();
    }

    public void removeCar() {
        modell.removeCar();
    }

    public void gas(int amount) {
        modell.gas(amount);
    }

    public void brake(int amount) {
        modell.gas(amount);
    }

    public void startEngine() {
        modell.startEngine();
    }

    public void stopEngine() {
        modell.stopEngine();
    }

    public void turboOff() {
        modell.turboOff();
    }

    public void turboOn() {
        modell.turboOff();
    }

    public void raisePlatform() {
        modell.raisePlatform();
    }

    public void lowerPlatform() {
        modell.lowerPlatform();
    }

}
