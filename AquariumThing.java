import java.awt.Color;

import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.PainterAPI;
import edu.cymbal.graphics.impl.SwingCanvasImpl;

public class AquariumThing {
    private static CanvasAPI canvas;
    private static PainterAPI painter;

    public static void main(String[] args) {
        canvas = new SwingCanvasImpl(800, 600, "Aquarium Thing");
        painter = canvas.getPainter();
    }

    /*
     * Draws a spiral (meant to represent algae) given a color and a size.
     * @param spiral the number of times it should repeat.
     * @param color takes in a Color class, specific to what kind of color to the algae.
     * @param size how big should each circle be.
    */
    public static void drawAlgae(int spiral, Color color, int size) {
        painter = canvas.getPainter();
        painter.setPenColor(color);
        for (int i = 0; i < spiral; i++) {
            painter.circle(size);
            size -= 3;
            painter.turnLeft(30);
            size += 3;
        }
    }

    /*
     * Draws a fish given a color and size with a single black eye.
     * @param color takes in a Color class specification.
     * @param size the size of the fish
    */
    public static void drawFish(Color color, int size) {
        painter = canvas.getPainter();
        painter.setPenColor(color);
        painter.startFill(color);
        painter.circle(size);
        int x = (int) painter.getX();
        int y = (int) painter.getY();
        painter.finishFill();
        painter.liftPen();
        painter.moveTo(x, y + (size - (Math.PI * 2)));
        painter.lowerPen();
        painter.startFill(color);
        painter.turnLeft(25);
        painter.forward(size * 2);
        painter.turnLeft(-115);
        painter.forward(size * 1.5);
        painter.turnLeft(-110);
        painter.forward(size * 2);
        painter.finishFill();
        painter.liftPen();
        painter.moveTo(painter.getX() - (size / 4), painter.getY() + (size / 2));
        painter.startFill(Color.BLACK);
        painter.circle(size / 4);
        painter.finishFill();
    }

    /* 
     * Draws kelp given a thickness, height, and a color.
     * @param thickness sets the pen width of the kelp.
     * @param height increases or decreases the height of the kelp
     * @param color sets the color of the kelp.
     */
    public static void drawKelp(int thickness, int height, Color color) {
        painter.setPenColor(color);
        painter.setPenWidth(thickness);
        int x = (int) painter.getX();
        // int y = (int) painter.getY();
        painter.moveTo(x, height);
        painter.turnLeft(120);
        painter.forward(height);
        painter.liftPen();
        painter.turnLeft(0);
        painter.moveTo(x, height);
        painter.lowerPen();
        painter.turnRight(60);
        painter.forward(height);
    }

}
