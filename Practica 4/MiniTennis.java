import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awl.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MiniTennis extends JPanel {
    Racquet racquet = new Racquet(this);
    Ball ball = new Ball();
    int speed = 1;

    private int getScore() {
        return speed - 1;
    }

    public MiniTennis() {
        // Internos

        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException {
        MiniTennis game = new MiniTennis();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRendertHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }

    private void move() {
        ball.move();
        racquet.move();
    }


}