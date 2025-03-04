import java.awt.*;

public class Saab95 extends Car implements Saab,Turbo{

    private boolean turboOn;

    public Saab95() {
        super(0,100,2, 125, Color.red, "Saab95");
        turboOn = false;
    }
    @Override
    public void setTurboOn() {
        turboOn = true;
    }
    @Override
    public void setTurboOff() {
        turboOn = false;
    }

    public boolean getTurbo(){return turboOn;}
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (getTurbo()) turbo = 3;
        return getEnginePower() * 0.01 * turbo;
    }

}
