public class Controller implements ButtonObserver {
    private final Modell modell;


    public Controller(Modell modell){
        this.modell = modell;

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
        modell.brake(amount);
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
        modell.turboOn();
    }

    public void raisePlatform() {
        modell.raisePlatform();
    }

    public void lowerPlatform() {
        modell.lowerPlatform();
    }

}
