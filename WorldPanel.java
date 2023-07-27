import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
public class WorldPanel extends JPanel{
    World w;

    public WorldPanel(){
        this.w = new World(5,5);
    }


    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 400));
        super.paintComponent(g);
        w.draw(g);
    }

    public void applySpiderCommands(){
        w.applySpiderCommands();
    }

    public void clearProgram(){
        w.clearProgram();
    }

    public void resetCellList(){
        w.resetCellList();
    }

    public void changeLevel(int level) {
        w.changeLevel(level);
        repaint();
    }

}
