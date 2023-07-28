import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;

public class App extends JFrame implements ActionListener{

    //comparing to the shapeApp lab, this WorldPanel and WorkAreaPanel classes = DrawArea and this App.java class = Main.java

    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    public static void main(String[] args){

        App game = new App();
        game.setSize(500,500);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public App(){
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel();
        title.setText("SPIDER WORLD");
        title.setBorder(new EmptyBorder(0, 0, 0, 60));
        title.setVisible(true);
        Font titleFont = new Font("Arial", Font.PLAIN, 22);
        title.setFont(titleFont);
    
        
        JLabel level = new JLabel();
        level.setText("Level");
        level.setVisible(true);
        Font levelFont = new Font("Arial", Font.PLAIN, 18);
        level.setFont(levelFont);

        topPanel.add(title);
        topPanel.add(level);


        for (int i = 1; i <= 15; i++){
            final int levelInt = i;
            JButton button = new JButton("" + i);
            button.setPreferredSize(new Dimension(50, 40));
            button.setFont(button.getFont().deriveFont(16f));
            button.addActionListener(e -> worldPanel.changeLevel(levelInt));
            topPanel.add(button);

            if(i == 15){
                button.setBorder(new EmptyBorder(0, 0, 0, 100));
            }
        }



        JButton directionButton = new JButton("Directions");
        directionButton.setFont(directionButton.getFont().deriveFont(20f));
        directionButton.setPreferredSize(new Dimension(120, 70));
        directionButton.addActionListener(e -> showDirectionsPopup());

        JButton restartButton = new JButton("Restart Level");
        restartButton.setFont(restartButton.getFont().deriveFont(20f));
        restartButton.setPreferredSize(new Dimension(150, 70));
        restartButton.addActionListener(e -> worldPanel.clearProgram());
        restartButton.addActionListener(e ->worldPanel.resetCellList());
        restartButton.addActionListener(e -> worldPanel.repaint());

        topPanel.add(directionButton);
        topPanel.add(restartButton);
        

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainPanel.setBackground(Color.WHITE);

        worldPanel = new WorldPanel();
        workAreaPanel = new WorkAreaPanel(worldPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); 
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setPreferredSize(new Dimension(100, 100));
        mainPanel.add(buttonPanel);

        JButton playButton = new JButton("Play");
        playButton.setFont(playButton.getFont().deriveFont(20f));
        playButton.setBackground(Color.GREEN);
        playButton.setOpaque(true);
        playButton.addActionListener(e -> {
            worldPanel.applySpiderCommands();
            worldPanel.repaint();
            if(worldPanel.grade() == true){
                levelCompletedPopup();
            }
            worldPanel.repaint();
            });


        JButton resetButton = new JButton("Reset");
        resetButton.setFont(resetButton.getFont().deriveFont(20f));
        resetButton.setBackground(Color.BLUE);
        resetButton.setOpaque(true);

        resetButton.addActionListener(e ->worldPanel.resetCellList());
        resetButton.addActionListener(e -> worldPanel.repaint());

        buttonPanel.add(playButton);
        buttonPanel.add(resetButton);

        mainPanel.add(worldPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(workAreaPanel);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();       
        }

        public void actionPerformed(ActionEvent e){

        }

        private void showDirectionsPopup() {
            String directionsText = "Welcome to Spider World!"
            + " Use the MOVE and TURN blocks to guide the spider around her room."
            +" The PAINT block paints the square the spider is standing on." 
            +" Can you guide the spider to paint the squares marked with diamonds?";

            JDialog popupDialog = new JDialog(this, "Directions", true);
            popupDialog.setLayout(new BorderLayout());

            JTextArea content = new JTextArea(directionsText);
            content.setFont(content.getFont().deriveFont(20f));
            content.setLineWrap(true);
            content.setWrapStyleWord(true);
            popupDialog.add(content, BorderLayout.CENTER);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> {
                popupDialog.dispose(); 
            });
            popupDialog.add(closeButton, BorderLayout.SOUTH);
            popupDialog.setSize(400, 300);
            popupDialog.setLocationRelativeTo(this);
            popupDialog.setVisible(true);
        }

        private void levelCompletedPopup() {
            String text = "Congrats!"
            + " Ready for the next level?";

            JDialog popupDialog = new JDialog(this, "Level Completed", true);
            popupDialog.setLayout(new BorderLayout());

            JTextArea content = new JTextArea(text);
            content.setFont(content.getFont().deriveFont(20f));
            content.setLineWrap(true);
            content.setWrapStyleWord(true);
            popupDialog.add(content, BorderLayout.CENTER);

            JButton nextButton = new JButton("next level");
            nextButton.addActionListener(e -> {
                popupDialog.dispose();
                worldPanel.nextLevel();
                worldPanel.clearProgram();
                worldPanel.resetCellList(); 
                worldPanel.repaint();
            });
            popupDialog.add(nextButton, BorderLayout.SOUTH);
            popupDialog.setSize(300, 200);
            popupDialog.setLocationRelativeTo(this);
            popupDialog.setVisible(true);
        }
    
}


