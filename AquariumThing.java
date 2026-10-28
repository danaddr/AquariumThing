import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.PainterAPI;
import edu.cymbal.graphics.impl.SwingCanvasImpl;

public class AquariumThing {
    public static void main(String[] args) {
        CanvasAPI canvas = new SwingCanvasImpl(800, 600, "Three Circles");
        PainterAPI p = canvas.getPainter();

        p.forward(100);
        p.turnRight(90);
        p.circle(15);
    }
    
    public static void drawFish(int size, int eyes) {

    }

    public static void drawKelp(int size) {
        
    }

}
