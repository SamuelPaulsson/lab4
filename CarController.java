import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;




/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    AutoRepairShop<Volvo> volvoshop = new AutoRepairShop<>(Volvo.class,400,30,10,"Helmia");

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int wy = (int) Math.round(volvoshop.getY());
            int wx = (int) Math.round(volvoshop.getX());
            frame.drawPanel.volvoWorkshopPoint.x = wx;
            frame.drawPanel.volvoWorkshopPoint.y = wy;
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                if (car instanceof Volvo volvo) {
                    if ((x - wx > -100) && (x - wx < 100) && (y - wy > -60) && (y - wy < 60)) {
                        volvoshop.load(volvo);
                        car.setX(wx);
                        car.setY(wy);

                    }
                }

                if(x > 690){
                    car.setX(690);
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                } else if (x < 0) {
                    car.setX(0);
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.startEngine();
                }

                frame.drawPanel.moveit(car.getModell(),x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double fixed_amount = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(fixed_amount);
        }
    }
    void brake(int amount) {
        double fixed_amount = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(fixed_amount);
        }
    }
    void startEngine() {
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }
    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Turbo saab) {
                saab.setTurboOff();
            }
        }
    }
    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Turbo saab) {
                (saab).setTurboOn();
            }
        }
    }
    void raisePlatform() {
        for (Car car : cars) {
            if (car instanceof HasPlatform scania) {
                scania.raisePlatform();
            }
        }
    }
    void lowerPlatform() {
        for (Car car : cars) {
            if (car instanceof HasPlatform scania) {
                scania.lowerPlatform();
            }
        }
    }


}
