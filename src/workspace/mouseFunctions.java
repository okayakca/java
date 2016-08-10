/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspace;

import java.awt.AWTException;
import java.awt.Robot;
import static java.lang.StrictMath.ceil;

/**
 *
 * @author pleksusmini6
 */
public class mouseFunctions {

    public static void mouse_whell(Integer x1, Integer y1, Integer x2, Integer y2) throws AWTException, InterruptedException {

        Integer x;
        Integer y;

        x = x1 - x2;

        y = y1 - y2;

        double xStep = ceil(x / 100);
        double yStep = ceil(y / 100);
        /*----------*/
        Robot robot = new Robot();

        Integer i = 1;
        while (i < 100) {

            System.out.println("x: " + ((xStep * i) + x1) + ", y: " + ((yStep * i) + y1));

            robot.mouseMove((int) ((xStep * i) + x1), (int) ((yStep * i) + y1));
            i++;

            try {
                Thread.sleep(10);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }

        robot.mouseMove((int) x2, (int) y2);

    }
}
