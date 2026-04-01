import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/* this class creates the mouse character that moves on the screen when the w or top arrow key
 * is pressed. it draws the mouse as well as sets when the mouse touches the cheese, it makes the character win.
 */
public class Character extends JPanel implements MouseMotionListener, KeyListener{
    private int x,y;
    private double angle;
    private int speed = 5;
    private boolean moving;
    private Timer moveTim;
    private int headX, headY;
    private MazeLevels mazeLevel;
    private JFrame levelFrame;
    private boolean hasWon = false;


    public Character(MazeLevels mazeLevel, JFrame levelFrame){
        this.x = 450;
        this.y = 785;
        this.mazeLevel = mazeLevel;
        this.levelFrame = levelFrame;
        setFocusable(true);
        setOpaque(false);
        requestFocusInWindow();
        addMouseMotionListener(this);
        addKeyListener(this);

        moveTim = new Timer(20, e -> {
            if (moving) {
                moveForward();
            }
        });
        moveTim.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    // draws the mouse character
    public void draw(Graphics g){

        g.setColor(new Color(179, 179, 179));

        g.fillOval(x - 8, y + 20, 15, 15);
        g.fillOval(x + 8, y + 20, 15, 15);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x, y, 15, 30);

        g.setColor(Color.GRAY);

        g.setColor(new Color(240, 182, 199));
        g.fillOval(x + 5, y, 5, 5);

        g.setColor(Color.BLACK);
        g.fillOval(x + 1, y + 10, 5, 5);
        g.fillOval(x + 10, y + 10, 5, 5);

        g.drawLine(x, y + 15, x - 10, y + 10);
        g.drawLine(x, y + 18, x - 10, y + 18);
        g.drawLine(x, y + 21, x - 10, y + 25);

        g.drawLine(x + 15, y + 15, x + 25, y + 10);
        g.drawLine(x + 15, y + 18, x + 25, y + 18);
        g.drawLine(x + 15, y + 21, x + 25, y + 25);

    }

    // this method listens to the mouse event and determines where the mouse is
    @Override
    public void mouseMoved(MouseEvent e){
        double dx = e.getX() - x;
        double dy = e.getY() - y;
        angle = Math.atan2(dy, dx);
        repaint();
    }

    // when the w key or top arrow key is pressed, the mouse moves
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            moving = true;
            moveForward();
        }
    }
    // when its not pressed, it doesnt move
    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            moving = false;
        }
    }

    // the moveforward function where it determines the x and y value and repaints it
    // (or moves it) while making sure it doesnt move through the walls
    private void moveForward() {
        int xVal = x + (int) (speed * Math.cos(angle));
        int yVal = y + (int) (speed * Math.sin(angle));
        if (!hitbox(xVal, yVal)) {
            x = xVal;
            y = yVal;
            cheeseTouch();
            repaint();
        }
    }

    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    // when the character touches the cheese, that means the user wins and a message pops up
    private void cheeseTouch(){
        if (hasWon) return;
        Rectangle playerBounds = new Rectangle(x, y, 20, 30);
        Rectangle cheeseBounds = mazeLevel.getCheese();

        if(playerBounds.intersects(mazeLevel.getCheese())){
            hasWon = true;
            chezMessage();
        }

    }

    // message box that shows either "next level" or "exit game" and if all 3 levels are finished, it tells the user "congratulations"
    private void chezMessage(){
                
        int choice = JOptionPane.showOptionDialog(this, "You touched the cheese!", "You Win", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"Next Level", "Exit"}, "Next Level");

        if(choice == 0){
            int currentLevel = mazeLevel.getLevel();
            int nextLevel = currentLevel + 1;

            levelFrame.dispose();
            JOptionPane.getRootFrame().dispose();

            for (Window window : Window.getWindows()) {
                if (window instanceof JDialog && window.isVisible()) {
                    window.dispose();
                }
            }

            // if the level after the current one is more than 3, that means all levels are done so it only continues if less than or equal to 3
            if(nextLevel <= 3){
                hasWon = false;
                this.x = 450; // resets mouse position so the "next level" dialogue doesnt keep showing
                this.y = 785;
                JOptionPane.getRootFrame().dispose();
                Home.openLevelWindow(nextLevel);
            } else {
                JOptionPane.showMessageDialog(this, "Congrats! You've finished all levels.");
            }
        }
        else if(choice == 1){
            System.exit(0);
        }
        
    }

    // character hitbox so that it doesnt go through the walls
    private boolean hitbox(int xVal, int yVal){
        Rectangle playerBounds = new Rectangle(xVal, yVal, 20, 30);

        for(Rectangle wall : mazeLevel.getWalls()){
            if(playerBounds.intersects(wall)){
                return true;
            }
        }
        if(xVal < 0 || yVal < 0 || xVal + 20 > getWidth() || yVal + 30 > getHeight()){
            return true;
        }
        return false;
    }

}
