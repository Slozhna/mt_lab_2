import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Ball {
    private BallCanvas canvas;
    private int XSIZE = 20;
    private int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private Color color;
    private boolean caught;

    Ball(BallCanvas c){
        this.canvas = c;
        Random random = new Random();
        this.color = new Color(random.nextInt() * 0x1000000);

        if (Math.random() < 0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    Ball(BallCanvas c, Color color){
        this.canvas = c;
        this.color = color;
        this.caught = false;

        if (Math.random() < 0.5){
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        }else{
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));
    }

    void sizeUp() {
        if (XSIZE <= 50 && YSIZE <=50 && !wasCaught()) {
            XSIZE += 10;
            YSIZE += 10;
        }
    }

    void sizeDown() {
        if (XSIZE > 20 && YSIZE  > 20 && !wasCaught()) {
            XSIZE -= 10;
            YSIZE -= 10;
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    boolean wasCaught() {
        return caught;
    }

    boolean move(){
        x += dx;
        y += dy;

        if (canvas.isCaught(this)) {
            System.out.println("CAUGHT");
            caught = true;
            return false;
        }

        if (x < 0){
            x = 0;
            dx = -dx;
        }
        if(x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth()-XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight()-YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();

        return true;
    }
}