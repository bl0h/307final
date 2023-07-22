import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

import java.awt.Graphics;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{

    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.WHITE);
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
