import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// this class is the home page that opens when the program is opened
public class Home extends JPanel{
    private Image backgroundImage;
    public Home() {
        setLayout(null);

        backgroundImage = new ImageIcon("bg1.png").getImage();

        addLevelButton("level1.png", 1, 330);
        addLevelButton("level2.png", 2, 430);
        addLevelButton("level3.png", 3, 530);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // the level buttons on the main home page that is mafe with images and when pressed, opens a level
    private void addLevelButton(String imagePath, int level, int y) {
        JButton button = new JButton(new ImageIcon(imagePath));
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBounds(350, y, 200, 70);

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openLevelWindow(level);
            }
        });

        add(button);
    }

    // opens each level window and adds the maze and chracter to it
    public static void openLevelWindow(int level) {

        JFrame levelFrame = new JFrame("Level " + level);
        levelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        levelFrame.setSize(900, 900);
        levelFrame.setLocationRelativeTo(null);
        levelFrame.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(900, 900));
        levelFrame.setContentPane(layeredPane);
        
        MazeLevels maze = new MazeLevels(level);
        maze.setBounds(0, 0, 900, 900);
        layeredPane.add(maze, JLayeredPane.DEFAULT_LAYER);
        
        Character character = new Character(maze,levelFrame);
        character.setBounds(0, 0, 900, 900);
        character.setOpaque(false);
        layeredPane.add(character, JLayeredPane.PALETTE_LAYER);

        levelFrame.setVisible(true);
        SwingUtilities.invokeLater(() -> {
            character.requestFocusInWindow(); 
            character.grabFocus();
        });

    

    }
}
