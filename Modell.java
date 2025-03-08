import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modell implements Observable {

    private ArrayList<AutoObject<? extends Vehicle>> autos;
    private ArrayList<CarObject> carObjects;
    private ArrayList<Observer> observers = new ArrayList<>();
    private final int delay = 50;
    private Timer timer;
    public Modell(){
        this.autos = new ArrayList<>();
        this.carObjects = new ArrayList<>();
        this.timer = new Timer(delay, new TimerListener());
        initObjects();


    }
    private void initObjects(){
        addCar(Factory.createSaab95());
        addCar(Factory.createVolvo240());
        addCar(Factory.createScania());
        addAuto(Factory.createAutoShop(Volvo.class,"Helmia"));

    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            updateModel();
            }
        }


    private void updateModel() {
        for (CarObject car : carObjects) {
            car.move();
            for (AutoObject<? extends Vehicle> auto : autos){
                nearAuto(car,auto);}
            inframe(car);
            notifyObservers();
        }
    }

    public void addCar(CarObject car){
        if(carObjects.size()<10){
        carObjects.add(car);
        notifyObservers();
        }
    }

    public void addAuto(AutoObject<? extends Vehicle> auto){
        if(autos.size()<10){
            autos.add(auto);
            notifyObservers();
        }
    }


    public void removeCar(){
        carObjects.removeLast();
        notifyObservers();

    }


    private void inframe(CarObject car) {
        if (car.getX() < 0) {
            leftCorrect(car);
        }
        if (car.getX() > 690) {
            rightCorrect(car);
        } ;
    };

    private void rightCorrect(CarObject car){
        car.setX(690);
        car.stopEngine();
        car.invertDirection();
        car.startEngine();
        };

    private void leftCorrect(CarObject car){
        car.setX(0);
        car.stopEngine();
        car.invertDirection();
        car.startEngine();
    };
    private  <V extends Vehicle> void nearAuto(CarObject car, AutoObject<V> auto) {
        if (auto.getType().isInstance(car.getCar())) {
            V specificCar = (V) car.getCar();
            int wx = (int) Math.round(auto.getX());
            int wy = (int) Math.round(auto.getY());
            int cx = (int) Math.round(car.getX());
            int cy = (int) Math.round(car.getY());
            if ((cx - wx > -100) &&
                    (cx - wx < 100) &&
                    (cy - wy > -60) &&
                    (cy - wy < 60)) {
                auto.load(specificCar);
                car.setX(wx);
                car.setY(wy);


            }
        }
    }
    public void startTimer(){
        timer.start();
    }

    public void stopTimer(){
        timer.stop();
    }


    void gas(int amount) {
        double fixed_amount = ((double) amount) / 100;
        for (CarObject car : carObjects
        ) {
            car.gas(fixed_amount);
        }
    }
    void brake(int amount) {
        double fixed_amount = ((double) amount) / 100;
        for (CarObject car : carObjects
        ) {
            car.brake(fixed_amount);
        }
    }
    void startEngine() {
        for (CarObject car : carObjects
        ) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (CarObject car : carObjects
        ) {
            car.stopEngine();
        }
    }
    void turboOff() {
        for (CarObject car : carObjects) {
            car.setTurboOff();
        }
    }
    void turboOn() {
        for (CarObject car : carObjects) {
            car.setTurboOn();
        }
    }
    void raisePlatform() {
        for (CarObject car : carObjects) {
            car.raisePlatform();
        }
    }
    void lowerPlatform() {
        for (CarObject car : carObjects) {
            car.lowerPlatform();
        }
    }
    void createRandCar(){
        addCar(Factory.addRandomCar());
    }

    ArrayList<Drawable> getDrawObjects(){
        ArrayList<Drawable> drawObjects = new ArrayList<>();
        drawObjects.addAll(carObjects);
        drawObjects.addAll(autos);
        return drawObjects;
    }

    ArrayList<AutoObject<? extends Vehicle>> getAutoObjects(){
        return autos;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.updateViewToModel(this);
        }
    }
}
