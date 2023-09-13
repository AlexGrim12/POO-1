import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    private static final int Y = 330;
    
    public Racquet(MiniTennis game) {
        this.game = game;
    }   

    public void move() {
        if (x + xa > 0 && x + xspd < game.getWidth() - WIDTH)
            x = x + xspd;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    // Listeners
    public void keyReleased(KeyEvent e) {
        xspd = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xspd = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xspd = game.speed;
    }

    // Getters
    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getY() {
        return Y;
    }

    // Attributes
    
}