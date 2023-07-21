import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;

public class App extends JFrame {
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
                JButton button = new JButton("" + i);
                button.setPreferredSize(new Dimension(50, 40));
                button.setFont(button.getFont().deriveFont(16f));
                topPanel.add(button);

                if(i == 15){
                    button.setBorder(new EmptyBorder(0, 0, 0, 100));
                }
            }
            JButton directionButton = new JButton("Directions");
            directionButton.setFont(directionButton.getFont().deriveFont(20f));
            directionButton.setPreferredSize(new Dimension(120, 70));

            JButton restartButton = new JButton("Restart Level");
            restartButton.setFont(restartButton.getFont().deriveFont(20f));
            restartButton.setPreferredSize(new Dimension(150, 70));
    
            topPanel.add(directionButton);
            topPanel.add(restartButton);

            JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            mainPanel.setBackground(Color.WHITE);
            //mainPanel.setPreferredSize(new Dimension(300, 300));
           
            JPanel worldPanel = new JPanel(new GridLayout(5,5));
            int borderWidth = 1; 
            Color borderColor = Color.WHITE; 
            Border border = BorderFactory.createMatteBorder(borderWidth, borderWidth, 0, 0, borderColor);

            for (int i = 0; i < 25; i++) {
                JPanel cell = new JPanel();
                cell.setBorder(border);
                cell.setBackground(Color.BLACK);
                worldPanel.add(cell);
            }
            /* 
                @Override
                protected void paintComponent(Graphics g){
                    super.paintComponent(g);
                    drawGridLines(g);
                }
            };
            worldPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    worldPanel.repaint(); // Trigger a repaint when the panel is resized
                }
            });
            */


            worldPanel.setBackground(Color.BLACK);
            worldPanel.setPreferredSize(new Dimension(400, 400));
            mainPanel.add(worldPanel);


            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
            buttonPanel.setBackground(Color.WHITE);
            buttonPanel.setPreferredSize(new Dimension(100, 100));
            mainPanel.add(buttonPanel);


            JButton playButton = new JButton("Play");
            playButton.setFont(playButton.getFont().deriveFont(20f));
            //playButton.setPreferredSize(new Dimension(50, 70));
            playButton.setBackground(Color.GREEN);
            playButton.setOpaque(true);


            JButton resetButton = new JButton("Reset");
            //resetButton.setPreferredSize(new Dimension(50, 70));
            resetButton.setFont(resetButton.getFont().deriveFont(20f));
            resetButton.setBackground(Color.BLUE);
            resetButton.setOpaque(true);


            buttonPanel.add(playButton);
            buttonPanel.add(resetButton);


            JPanel workSpacePanel = new JPanel(new BorderLayout());
            workSpacePanel.setBackground(Color.WHITE);
            workSpacePanel.setPreferredSize(new Dimension(600, 700));
            workSpacePanel.setBorder(new LineBorder(Color.BLACK,1));
            mainPanel.add(workSpacePanel);


            try{
            File imageFile = new File("trashcan.png");
            BufferedImage originalImage = ImageIO.read(imageFile);

            int newWidth = 100;
            int newHeight = 100;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            ImageIcon imageIcon = new ImageIcon(resizedImage);
            JLabel trashLabel = new JLabel(imageIcon);


            JPanel trashPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            trashPanel.setBackground(Color.WHITE);
            trashPanel.add(trashLabel);
            workSpacePanel.add(trashPanel, BorderLayout.SOUTH);
            }

            catch(Exception e){
                e.printStackTrace();
            }


            JPanel sidePanel = new JPanel(new BorderLayout());
            sidePanel.setBackground(Color.LIGHT_GRAY);
            sidePanel.setPreferredSize(new Dimension(250, 700));
            mainPanel.add(sidePanel, BorderLayout.SOUTH);


            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(topPanel, BorderLayout.NORTH);
            getContentPane().add(mainPanel, BorderLayout.CENTER);
            pack(); 
            }
            /* 
            public void drawGridLines( Graphics g){
                int cellWidth = getWidth() / 5; 
                int cellHeight = getHeight() / 5; 
                g.setColor(Color.WHITE);

                for(int i=0; i<5;i++){
                    int x = i * cellWidth;
                    g.drawLine(x, 0, x, getHeight());
                }
                for(int i=0; i<5;i++){
                    int y = i * cellHeight;
                    g.drawLine(0, y, getWidth(), y);
                }
            }
            */

}


