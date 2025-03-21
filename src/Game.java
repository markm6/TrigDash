import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Point;

public class Game extends JPanel implements KeyListener, MouseListener, ActionListener {
    private int rectX;
    private int rectY;
    private Rectangle rect1;
    private int rect2X;
    private int rect2Y;
    private Rectangle rect2;
    private double velocity;
    private String message;
    private Color rectColor;
    private Player player;
    public Game() {
        rectX = 50;
        rectY = 30;
        velocity = -10;
        rect1 = new Rectangle(70, 30);
        rect2X = 230;
        rect2Y = 5;
        rect2 = new Rectangle(20, 20);
        message = "mouse click: ";
        rectColor = Color.RED;
        player = new Player(true);
        // UPDATE timer to be 10ms, which will now trigger 100 times per second
        Timer timer = new Timer(10, this);
        timer.start();

        addMouseListener(this);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        rect1.setLocation(rectX, rectY);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(rectColor);
        g2d.draw(rect1);

        rect2.setLocation(rect2X, rect2Y);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLUE);
        g2d.draw(rect2);

        // can use the intersects method on a Rectangle object
        // to determine if one Rectangle object touches another Rectangle object
        // (could alternatively use contains if you want to check if
        // one Rectangle entirely contains another within its boundaries)
        if (rect1.intersects(rect2)) {
            rectColor = Color.MAGENTA;
        }

        g.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.setColor(Color.BLACK);
        g2d.drawString(message, 120, 150);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int currentX = (int) rect1.getX();
        int currentY = (int) rect1.getY();

        int key = e.getKeyCode();
        if (key == 38) {  // up key
            rectY = currentY - 5;
        } else if (key == 40) { // down key
            rectY = currentY + 5;
        } else if (key == 37) { // left key
            rectX = currentX - 5;
        } else if (key == 39) {  // right key
            rectX = currentX + 5;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point mouseClickLocation = e.getPoint();
            message = "mouse click: (" + mouseClickLocation.getX() + ", " + mouseClickLocation.getY() + ")";
            if (rect1.contains(mouseClickLocation)) {
                rectColor = Color.GREEN;
            } else {
                rectColor = Color.RED;
            }

            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof Timer) {
            // Jumping logic. Gravity is positive & Jump is negative.
            rect2Y += (int) (1 * velocity);

            velocity += 1;
            if (rect2Y > 720) {
                velocity = -20;
                // Set to 0 if the cube hits a surface
            }

            repaint();
        }
    }
}