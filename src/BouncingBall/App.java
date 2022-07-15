package BouncingBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;

    // variáveis para a bola
    int x = 0, y = 0, angleX = 1, angleY = 1;

    // método para mover a bola
    private void move() {
        if (x + angleX < 0)
            angleX = 1;
        else if (x + angleX > getWidth() - 50)
            angleX = -1; // a bola é de tamanho 50x50
        else if (y + angleY < 0)
            angleY = 1;
        else if (y + angleY > getHeight() - 50)
            angleY = -1;

        x += angleX;
        y += angleY;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 50, 50); // a bola 50x50
    }

    public static void main (String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Movendo a bola");
        App app = new App();
        Thread thread = new Thread(app);

        frame.add(app);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thread.start();
            }
        });
    }

    @Override
    public void run() {
        while(true) {
            move();
            repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
