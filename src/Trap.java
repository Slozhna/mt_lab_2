import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Trap {
    private int XSIZE;
    private int YSIZE;
    private int x;
    private int y;

    Trap(int x, int y, int XSIZE, int YSIZE) {
        this.x = x;
        this.y = y;
        this.XSIZE = XSIZE;
        this.YSIZE = YSIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXSIZE() {
        return XSIZE;
    }

    public int getYSIZE() {
        return YSIZE;
    }

    boolean checkCollision(Ball b) {
        return (Math.abs(this.x - b.getX()) < 3 && Math.abs(this.y - b.getY()) < 3);
    }

    void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
        g2.setColor(Color.WHITE);
        g2.fill(new Ellipse2D.Double(x + 1, y + 1, XSIZE - 2, YSIZE - 2));
    }
}
