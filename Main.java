
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main extends JPanel {
    
    public Main() {
        JFrame frame = new JFrame("Mouse Maze"); 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(Color.white);
        frame.setSize(900, 900);
        this.setPreferredSize(new Dimension(900, 900));

        frame.setLocationRelativeTo(null);

        Home homeScreen = new Home();
        frame.add(homeScreen);

        frame.setVisible(true);
        
    }
}
