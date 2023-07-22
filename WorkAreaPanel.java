import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Graphics;

public class WorkAreaPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(600, 700));
        setBorder(new LineBorder(Color.BLACK,1));
        super.paintComponent(g);
    }


    public void mousePress(){


    }

    public void mouseRelease(){


    }


    public void delete(){



    }
    
}
