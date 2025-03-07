import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private HashMap<BufferedImage, Point> imagePointHashMap = new HashMap<>();
    void moveit(BufferedImage image, int x, int y) {
        if (imagePointHashMap.containsKey(image)) {
            imagePointHashMap.get(image).x = x;
            imagePointHashMap.get(image).y = y;
            repaint();
        }
    }

    public void addImage(BufferedImage image, int x, int y) {
        imagePointHashMap.put(image, new Point(x, y));
    }

    public void removeImage(BufferedImage image) {
        imagePointHashMap.remove(image);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        //try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

           // volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
           // volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
           // saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
           // scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
       // } catch (IOException ex)
       // {
        //    ex.printStackTrace();
       // }

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         // see javadoc for more info on the parameters
        for (BufferedImage image : imagePointHashMap.keySet()) {
            g.drawImage(image, imagePointHashMap.get(image).x, imagePointHashMap.get(image).y, null);
        }
    }
}
