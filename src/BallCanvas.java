import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class BallCanvas extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private ArrayList<Trap> traps = new ArrayList<>();
    private int caughtBallscounter;

    void addTrap(Trap t) {
        this.traps.add(t);
    }

    void add(Ball b) {
        this.balls.add(b);
    }

    boolean isCaught(Ball b) {
        for (Trap t : traps)
            if (t.checkCollision(b)) {
                caughtBallscounter += 1;
                this.repaint();
                return true;
            }
        return false;
    }

    BallCanvas() {
        caughtBallscounter = 0;
        int border = 25;
        this.addTrap(new Trap(border, border, border, border));
        this.addTrap(new Trap(400, border, border, border));
        this.addTrap(new Trap(border, 275, border, border));
        this.addTrap(new Trap(400, 275, border, border));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
            b.draw(g2);

        for (Trap t : traps)
            t.draw(g2);

        g2.setColor(Color.BLACK);
        g2.drawString("Caught: " + caughtBallscounter, 80, 300);
    }
}