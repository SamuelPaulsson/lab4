import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Type;

import javax.imageio.ImageIO;
import javax.swing.text.View;
public class AutoObject<T extends Vehicle> implements Drawable{

    private final AutoRepairShop<T> auto;
    private BufferedImage image;

    public AutoObject(AutoRepairShop<T> auto) {
        this.auto = auto;
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResource("pics/"+getType().getSimpleName()+"Brand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setX(double newX){
        auto.setX(newX);
    }

    public void setY(double newY){
        auto.setY(newY);
    }

    public double getX() {
        return (int) auto.getX();
    }

    public double getY() {
        return (int) auto.getY();
    }

    public BufferedImage getImage() {
        return image;
    }
    public Class<T> getType(){
        return auto.getType();
    }

    public void load(T car) {
        auto.load(car);
    }




}
