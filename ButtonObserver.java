public interface ButtonObserver {
    void addCar();
    void removeCar();
    void gas(int amount);
    void brake(int amount);
    void startEngine();
    void stopEngine();
    void turboOff();
    void turboOn();
    void raisePlatform();
    void lowerPlatform();
}
