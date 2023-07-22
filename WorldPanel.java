
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
public class WorldPanel extends JPanel{
    World w;

    public WorldPanel(World w){
        this.w = w;
    }


    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.RED);
        setPreferredSize(new Dimension(400, 400));
        super.paintComponent(g);
        w.draw(g);
    }

    public void updateDrawing(){
        repaint();
    }

}
