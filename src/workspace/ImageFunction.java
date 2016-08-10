/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspace;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author pleksusmini6
 */
public class ImageFunction {

    public static void capture(String imagePath) {
        try {
            Toolkit tool = Toolkit.getDefaultToolkit();
            Dimension d = tool.getScreenSize();
            Rectangle rect = new Rectangle(d);
            Robot robot = new Robot();
            Thread.sleep(4000);
            
            BufferedImage image;
            image = ImageIO.read(new File("images/"+imagePath));
            //System.out.println(image.getHeight());
            int imageData[][] = new int[image.getWidth()][image.getHeight()];
            
            BufferedImage img = robot.createScreenCapture(rect);
            
            int xFinish = 0;
            int yFinish = 0;
            
            int[] pixel;
            
            for (int x = 0; x < image.getWidth(); x++) {
                xFinish++;
                yFinish = 0;
                for (int y = 0; y < image.getHeight(); y++) {
                    
                    
                    yFinish++;
                    
                    pixel = image.getRaster().getPixel(x, y, new int[3]);
                    
                    imageData[x][y] = 765 - (pixel[0]+pixel[1]+pixel[2]);
                    
                }
            }
            
            int tx = 0;
            int ty = 0;
            
            //System.out.println(" Başladı ");
            
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    
                    pixel = img.getRaster().getPixel(x, y, new int[3]);
                    
                    //System.out.println("t:"+pixel[1]);
                    if(imageData[0][0] == (765-(pixel[0]+pixel[1]+pixel[2]))){
                        
                        int statu = 1;
                        System.out.println("t:"+yFinish);
                        for(int ex = 0; ex < xFinish; ex++){
                            
                            for(int ey = 0; ey < yFinish; ey++){
                                
                                pixel = img.getRaster().getPixel((x+ex), (y+ey), new int[3]);
                                
                                if(!(imageData[ex][ey] == (765-(pixel[0]+pixel[1]+pixel[2])))){
                                    
                                    statu = 0;
                                
                                }
                                
                            }
                        
                        }
                        
                        if(statu == 1){
                        
                            System.out.println("Buldu");
                            System.exit(0);
                        }
                        
                    }
                    
                    
                }
            }
            
            System.out.println(" Bitti ");

            //ImageIO.write(img, "jpeg", f);
            //tool.beep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
