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

    public void gas(double amount) {
        car.gas(amount);
    }

    public void brake(double amount) {
        car.brake(amount);
    }

    public void startEngine() {
        car.startEngine();
    }

    public void stopEngine() {
        car.stopEngine();
    }

    public void invertDirection() {
        car.turnLeft();
        car.turnLeft();
    }

    public void move() {
        car.move();
    }

    public Car getCar() {
        return car;
    }

    public void setTurboOn() {
        if (car instanceof Turbo turbo) {
            turbo.setTurboOn();
        }
    }
    public void setTurboOff() {
        if (car instanceof Turbo turbo) {
            turbo.setTurboOff();
        }
    }
    public void raisePlatform() {
        if (car instanceof HasPlatform platform) {
            platform.raisePlatform();
        }
    }
    public void lowerPlatform() {
        if (car instanceof HasPlatform platform) {
            platform.lowerPlatform();
        }
    }
}
