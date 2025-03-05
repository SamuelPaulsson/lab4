import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Modell {
    private ArrayList<AutoRepairShop<? extends Vehicle>> autos;
    private ArrayList<CarObject> carObjects;
    public Modell(){
        this.autos = new ArrayList<>();
        this.carObjects = new ArrayList<>();
        initObjects();
        AutoRepairShop<Volvo> volvoshop = new AutoRepairShop<>(Volvo.class,400,30,10,"Helmia");
        autos.add(volvoshop);
    }
    private void initObjects(){
        addCar(Factory.createSaab95());
        addCar(Factory.createVolvo240());
        addCar(Factory.createScania());

    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*int wy = (int) Math.round(volvoshop.getY());
            int wx = (int) Math.round(volvoshop.getX());
            frame.drawPanel.volvoWorkshopPoint.x = wx;
            frame.drawPanel.volvoWorkshopPoint.y = wy;*/
            for (Car car : cars) {
                car.move();
                /*int x = (int) Math.round(car.getXCoordinate());
                int y = (int) Math.round(car.getYCoordinate());*/
                inframe(car);
                for (AutoRepairShop<? extends Vehicle> auto : autos){
                   nearAuto(car,auto);
                }

                frame.drawPanel.moveit(car.getModell(), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    public void addCar(CarObject car){
        if(carObjects.size()<10){
        carObjects.add(car);
        }
    };


    public void inframe(Car car) {
        if (car.getX() < 0) {
            leftCorrect(car);
        }
        if (car.getX() > 690) {
            rightCorrect(car);
        } ;
    };

    public void rightCorrect(Car car){
        car.setX(690);
        car.stopEngine();
        car.turnRight();
        car.turnRight();
        car.startEngine();
        };

    public void leftCorrect(Car car){
        car.setX(690);
        car.stopEngine();
        car.turnRight();
        car.turnRight();
        car.startEngine();
    };
    public <V extends Vehicle> void nearAuto(Car car, AutoRepairShop<V> auto) {
        if (auto.getType().isInstance(car)) {
            V specificCar = (V) car;
            double wx = auto.getX();
            double wy = auto.getY();
            if ((specificCar.getX() - wx > -100) &&
                    (specificCar.getX() - wx < 100) &&
                    (specificCar.getY() - wy > -60) &&
                    (specificCar.getY() - wy < 60)) {
                auto.load(specificCar);
                specificCar.setX(wx);
                specificCar.setY(wy);


            }
        }
    }





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
