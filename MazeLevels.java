import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/* This class creates the maze for each level as well as the cheese at the end */
public class MazeLevels extends JPanel {
    private static ArrayList<Rectangle> walls = new ArrayList<>();
    private int level;
    private Image chez;
    private Rectangle cheese;

    // main mazelevels constructor that opens the levels and sets where the cheese will be
    public MazeLevels(int level){
        setFocusable(false);
        this.level = level;

        chez = new ImageIcon("chez.png").getImage();;

        if (level == 1) {
            cheese = new Rectangle(25, 25, 30, 30);
            level1();

        } else if (level == 2) {
            cheese = new Rectangle(25, 25, 30, 30);
            level2();
        } else if (level == 3) {
            cheese = new Rectangle(450, 25, 30, 30);
            level3();
        }
    }

    // the next few methods are the level mazes made of rectangles
    public void level1() {
        this.walls.clear();
        // borders
        this.walls.add(new Rectangle(0, 0, 20, 900));
        this.walls.add(new Rectangle(0, 0, 900, 20));
        this.walls.add(new Rectangle(0, 0, 900, 20));
        this.walls.add(new Rectangle(880, 0, 20, 900));
        this.walls.add(new Rectangle(0, 855, 900, 20));

        // maze
        this.walls.add(new Rectangle(0, 750, 400, 20));
        this.walls.add(new Rectangle(480, 750, 400, 20));
        this.walls.add(new Rectangle(480, 750, 400, 20));

        this.walls.add(new Rectangle(190, 590, 20, 180));
        this.walls.add(new Rectangle(480, 590, 20, 180));
        this.walls.add(new Rectangle(330, 590, 160, 20));
        this.walls.add(new Rectangle(190, 370, 160, 20));

        this.walls.add(new Rectangle(0, 230, 500, 20));
        this.walls.add(new Rectangle(500, 230, 20, 180));
        this.walls.add(new Rectangle(500, 410, 180, 20));
        this.walls.add(new Rectangle(680, 410, 20, 180));
        this.walls.add(new Rectangle(680, 100, 20, 180));

        this.walls.add(new Rectangle(330, 380, 20, 220));
        this.walls.add(new Rectangle(0, 480, 180, 20));
        this.walls.add(new Rectangle(330, 480, 100, 20));

        this.walls.add(new Rectangle(0, 100, 400, 20));
        this.walls.add(new Rectangle(480, 100, 400, 20));

    }
    public void level2() {
        this.walls.clear();


        // borders
        this.walls.add(new Rectangle(0, 0, 20, 900));
        this.walls.add(new Rectangle(0, 0, 900, 20));
        this.walls.add(new Rectangle(0, 0, 900, 20));
        this.walls.add(new Rectangle(880, 0, 20, 900));
        this.walls.add(new Rectangle(0, 855, 900, 20));

        // maze
        this.walls.add(new Rectangle(0, 750, 400, 20)); // bottom borders
        this.walls.add(new Rectangle(480, 750, 400, 20));
        this.walls.add(new Rectangle(480, 750, 400, 20));

        this.walls.add(new Rectangle(0, 100, 400, 20));
        this.walls.add(new Rectangle(250, 340, 400, 20));
        this.walls.add(new Rectangle(350, 210, 200, 20));

        this.walls.add(new Rectangle(400, 630, 100, 20));
        this.walls.add(new Rectangle(300, 630, 100, 20));
        this.walls.add(new Rectangle(300, 530, 100, 20));

        this.walls.add(new Rectangle(480, 630, 20, 140));
        this.walls.add(new Rectangle(300, 530, 20, 120));
        this.walls.add(new Rectangle(300, 530, 20, 120));
        this.walls.add(new Rectangle(150, 630, 20, 140));
        this.walls.add(new Rectangle(380, 435, 20, 100));

        this.walls.add(new Rectangle(250, 100, 20, 250));
        this.walls.add(new Rectangle(130, 250, 20, 300));
        this.walls.add(new Rectangle(20, 550, 130, 20));
        this.walls.add(new Rectangle(150, 450, 130, 20));


        this.walls.add(new Rectangle(750, 200, 130, 20));
        this.walls.add(new Rectangle(630, 100, 130, 20));

        this.walls.add(new Rectangle(750, 200, 20, 130));
        this.walls.add(new Rectangle(630, 100, 20, 250));
        this.walls.add(new Rectangle(500, 0, 20, 220));

        // right bottom area
        this.walls.add(new Rectangle(630, 430, 20, 200));
        this.walls.add(new Rectangle(510, 530, 130, 20));
        this.walls.add(new Rectangle(630, 630, 130, 20));

        this.walls.add(new Rectangle(510, 430, 20, 110));
        this.walls.add(new Rectangle(740, 520, 20, 130));

        this.walls.add(new Rectangle(630, 430, 260, 20));

    }
    public void level3() {
        walls.clear();

        // borders
        walls.add(new Rectangle(0, 0, 20, 900));
        walls.add(new Rectangle(0, 0, 900, 20));
        walls.add(new Rectangle(0, 0, 900, 20));
        walls.add(new Rectangle(880, 0, 20, 900));
        walls.add(new Rectangle(0, 855, 900, 20));

        // vertical
        this.walls.add(new Rectangle(500, 760, 20, 100));
        this.walls.add(new Rectangle(200, 660, 20, 250));
        this.walls.add(new Rectangle(300, 440, 20, 220));
        this.walls.add(new Rectangle(500, 440, 20, 220));
        this.walls.add(new Rectangle(680, 460, 20, 300));
        this.walls.add(new Rectangle(780, 460, 20, 190));
        this.walls.add(new Rectangle(100, 440, 20, 280));
        this.walls.add(new Rectangle(385, 350, 20, 200));
        this.walls.add(new Rectangle(600, 240, 20, 200));
        this.walls.add(new Rectangle(600, 240, 20, 200));
        this.walls.add(new Rectangle(700, 240, 20, 90));
        this.walls.add(new Rectangle(780, 140, 20, 110));
        this.walls.add(new Rectangle(400, 660, 20, 100));
        this.walls.add(new Rectangle(590, 560, 20, 100));
        this.walls.add(new Rectangle(600, 0, 20, 90));
        this.walls.add(new Rectangle(550, 100, 20, 110));
        this.walls.add(new Rectangle(400, 0, 20, 140));
        this.walls.add(new Rectangle(310, 130, 20, 100));
        this.walls.add(new Rectangle(475, 310, 20, 100));
        this.walls.add(new Rectangle(210, 90, 20, 200));
        this.walls.add(new Rectangle(410, 200, 20, 100));
        this.walls.add(new Rectangle(280, 300, 20, 70));


        // horizontal
        this.walls.add(new Rectangle(300, 760, 500, 20));
        this.walls.add(new Rectangle(300, 540, 220, 20));
        this.walls.add(new Rectangle(100, 420, 220, 20));
        this.walls.add(new Rectangle(100, 530, 110, 20));
        this.walls.add(new Rectangle(590, 550, 110, 20));
        this.walls.add(new Rectangle(510, 440, 110, 20));
        this.walls.add(new Rectangle(690, 460, 110, 20));
        this.walls.add(new Rectangle(600, 380, 180, 20));
        this.walls.add(new Rectangle(700, 310, 180, 20));
        this.walls.add(new Rectangle(550, 140, 350, 20));
        this.walls.add(new Rectangle(620, 70, 180, 20));
        this.walls.add(new Rectangle(310, 130, 160, 20));
        this.walls.add(new Rectangle(400, 350, 130, 20));
        this.walls.add(new Rectangle(210, 70, 110, 20));
        this.walls.add(new Rectangle(0, 70, 110, 20));
        this.walls.add(new Rectangle(120, 140, 110, 20));
        this.walls.add(new Rectangle(0, 210, 110, 20));
        this.walls.add(new Rectangle(110, 280, 300, 20));
        this.walls.add(new Rectangle(410, 200, 160, 20));
        this.walls.add(new Rectangle(200, 660, 120, 20));
        this.walls.add(new Rectangle(0, 347, 180, 20));

    }

    // paint component that sets the color depending on the level and fills all the walls
    // it also draws the cheese image

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(level == 1){
            g.setColor(new Color(128, 81, 54));
        }
        else if(level == 2){
            g.setColor(new Color(163, 191, 165));
        }
        else if(level == 3){
            g.setColor(new Color(237, 138, 174));
        }

        for (Rectangle wall : this.walls) {
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }
        g.drawImage(chez, cheese.x, cheese.y, this);
    }

    // getters for the cheese, levels, and walls
    public Rectangle getCheese(){
        return cheese;
    }
    public int getLevel(){
        return level;
    }
    public static ArrayList<Rectangle> getWalls() {
        return walls;
    }

}
