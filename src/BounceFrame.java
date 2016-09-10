import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class BounceFrame extends JFrame {

    private BallCanvas canvas;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 350;

    private ArrayList <BallThread> Threads;

    BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");

        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = "
                + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart     = new JButton("►");
        JButton buttonStartBlue = new JButton("►");
        JButton buttonStartRed  = new JButton("►");
        JButton buttonStop      = new JButton("■");
        JButton buttonLoss      = new JButton("⏮");
        JButton buttonBoost     = new JButton("⏭");
        JButton buttonDecrease  = new JButton("⚫");
        JButton buttonGrow      = new JButton("⬤");

        Threads = new ArrayList<>();

        buttonStart.addActionListener(e -> {
            add_colored_ball(new Color((int)(Math.random() * 0x1000000)));
        });

        buttonStartRed.addActionListener(e -> {
            add_colored_ball(Color.red);
        });

        buttonStartBlue.addActionListener(e -> {
            add_colored_ball(Color.blue);
        });

        buttonStop.addActionListener(e -> System.exit(0));

        buttonBoost.addActionListener(e -> {
            Threads.forEach(BallThread::boost);
        });

        buttonLoss.addActionListener(e -> {
            Threads.forEach(BallThread::loss);
        });

        buttonGrow.addActionListener(e -> {
            Threads.forEach(BallThread::grow);
        });

        buttonDecrease.addActionListener(e -> {
            Threads.forEach(BallThread::decrease);
        });

        buttonStartBlue.setForeground(Color.blue);
        buttonStartRed.setForeground(Color.red);

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStartRed);
        buttonPanel.add(buttonStartBlue);
        buttonPanel.add(buttonStop);
        buttonPanel.add(buttonLoss);
        buttonPanel.add(buttonBoost);

        buttonPanel.add(buttonDecrease);
        buttonPanel.add(buttonGrow);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void add_colored_ball(Color color) {
        Ball b = new Ball(canvas, color);
        canvas.add(b);
        Threads.add(new BallThread(b));
        Threads.get(Threads.size() - 1).start();
        System.out.println("Thread name = " + Threads.get(Threads.size() - 1).getName());
    }
}