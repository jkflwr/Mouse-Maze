public class Project2Runner {
    
    /*
     * Name: Natalia Parodi
     * Student ID: 501301868
     * 
     ******** Project Description ********
     * 
     * This program is a 2d game that uses Swing. It is a maze game. It starts by opening a home page where there are 3 buttons a user can pick from.
     * Each button correlates to a level and when pressed, a new window opens for the corresponding level. The user can play the game using the
     * 'w' key as well as the up arrow key and the cursor. The cursor is the direction the mouse character moves in. So when the w or up arrow is pressed, it moves in the direction
     * of the cursor. The aim of the game is to complete the maze and get to the cheese at the end. Once the user completes the maze and touches the cheese, a message box with 2 options
     * shows up, the user can either exit or go to the next level.
     * When they press go to the next level, it will open the next level and once they beat all the levels, that means they have won the game.
     * 
     ******** Swing Requirement ********
     * 
     * There are 3 unique components: JFrame, JOptionPane, and JButton are all used. 
     * JFrame is used in the main class (line 11) and home class (line 57) to display the windows
     * JOptionPane is used as a message pop up box in the character file (line 134) that shows a "congrats" message as well as
     * options users can pick from
     * JButton is used in the home file (line 35) so users can pick which level they want to play
     * 
     ******** 2D Graphics Requirement ********
     *
     * JPanel is used multiple times for drawing things.
     * First in the home file where it draws the background image of the homescreen. (line 28)
     * Then, its used in the character file (line 43) to draw the mouse character. Finally, its used in mazelevels file (line 184)
     * to draw the maze in each level
     * 
     ******** Event Listener Requirement ********
     *
     * It uses an actionlistener (44) to open the level window when a button on the homescreen is pushed.
     * There is also a mousemotionlistener in character file (79) as well as a keylistener in character (87) that
     * uses the keys to handle the character movement
     */

    public static void main(String[] args) {
        Main mainPanel = new Main();
        
    }
}
