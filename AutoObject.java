import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.View;
public class AutoObject implements Drawable{

    private final AutoRepairShop<? extends Vehicle> auto;
    private BufferedImage image;

    public AutoObject(AutoRepairShop<? extends Vehicle> auto) {
        this.auto = auto;
        try {
            this.image = ImageIO.read(View.class.getResourceAsStream("pics/"+ +".jpg"));
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

}
