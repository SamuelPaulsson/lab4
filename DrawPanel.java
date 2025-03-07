import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel implements Observer{
    private ArrayList<Drawable> objects = new ArrayList<Drawable>();

    public void updateViewToModel(Modell modell) {
        objects = modell.getDrawObjects();
        this.repaint();
    }
    public DrawPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable item : objects) {
            int x = (int) Math.round(item.getX());
            int y = (int) Math.round(item.getY());
            g.drawImage(item.getImage(), x, y, null);
        }
    }
}
