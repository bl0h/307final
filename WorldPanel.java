
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
public class WorldPanel extends JPanel{
    World w;

    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(400, 400));
        super.paintComponent(g);
        w.draw(g);




    }

}