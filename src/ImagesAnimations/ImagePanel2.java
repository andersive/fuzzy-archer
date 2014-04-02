package ImagesAnimations;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel2 extends JPanel {

    private BufferedImage image;

    public ImagePanel2() {
        try {
            image = ImageIO.read(new File("/Users/lahmia/Documents/Programmering/LordOfTheRingdLCG/out/production/LordOfTheRingdLCG/images/mong.jpg"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }

}