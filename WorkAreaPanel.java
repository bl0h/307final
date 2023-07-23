import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Graphics;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{
    
    Block move = new Block("move", 600, 100);
	Block turn = new Block("turn", 600, 200);
	Block paint = new Block("paint", 600, 300);

    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 700));
        setBorder(new LineBorder(Color.BLACK,1));
        super.paintComponent(g);

        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(550, 0, 250, 700);

        move.draw(g);
		turn.draw(g);
		paint.draw(g);
    }


    @Override
	public void mousePressed(MouseEvent e) {


	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
    
}
