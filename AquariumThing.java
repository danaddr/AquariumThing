import java.awt.Color;

import javax.swing.Painter;

import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.PainterAPI;
import edu.cymbal.graphics.impl.SwingCanvasImpl;

public class AquariumThing {
    private static CanvasAPI canvas;
    private static PainterAPI painter;

    public static void main(String[] args) {
        canvas = new SwingCanvasImpl(800, 600, "Aquarium Thing");
        drawAlgae(12, Color.DARK_GRAY, 25);
    }

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

    public static void drawFish(int eyes, Color color, int size) {
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
    }

    public static void drawKelp(int thickness, int height) {
        painter = canvas.getPainter();
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
