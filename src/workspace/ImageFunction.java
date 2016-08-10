/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspace;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author pleksusmini6
 */
public class ImageFunction {

    public static void capture() {
        try {
            Toolkit tool = Toolkit.getDefaultToolkit();
            Dimension d = tool.getScreenSize();
            Rectangle rect = new Rectangle(d);
            Robot robot = new Robot();
            Thread.sleep(2000);
            File f = new File("screenshot.jpg");
            BufferedImage img = robot.createScreenCapture(rect);

            int[] pixel;

            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    pixel = img.getRaster().getPixel(x, y, new int[3]);
                    System.out.println(pixel[0] + " - " + pixel[1] + " - " + pixel[2] + " - " + (img.getWidth() * y + x));
                }
            }

            //ImageIO.write(img, "jpeg", f);
            //tool.beep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
