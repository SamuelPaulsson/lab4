import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.text.View;

public class CarObject implements Drawable {
    private final Car car;
    private BufferedImage image;

    public CarObject(Car car) {
        this.car = car;
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("pics/" + car.getModell() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };



    public void setX(double newX){
        car.setX(newX);
    }

    public void setY(double newY){
        car.setY(newY);
    }

    public double getX() {
        return car.getX();
    }

    public double getY() {
        return car.getY();
    }

    public BufferedImage getImage() {
        return image;
    }

    void gas(double amount) {
        car.gas(amount);
    }

    void brake(double amount) {
        car.brake(amount);
    }

    void startEngine() {
        car.startEngine();
    }

    void stopEngine() {
        car.stopEngine();
    }

    void invertDirection() {
        car.turnLeft();
        car.turnLeft();
    }

    void move() {
        car.move();
    }

    Car getCar() {
        return car;
    }

    void setTurboOn() {
        if (car instanceof Turbo turbo) {
            turbo.setTurboOn();
        }
    }
    void setTurboOff() {
        if (car instanceof Turbo turbo) {
            turbo.setTurboOff();
        }
    }
    void raisePlatform() {
        if (car instanceof HasPlatform platform) {
            platform.raisePlatform();
        }
    }
    void lowerPlatform() {
        if (car instanceof HasPlatform platform) {
            platform.lowerPlatform();
        }
    }
}
