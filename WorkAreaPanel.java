import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Graphics;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{

	private Block selectedBlock;
    private int xOffset;
    private int yOffset;

    
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
		if (mouseX >= move.getX() && mouseX <= move.getX() + move.getWidth() &&
            mouseY >= move.getY() && mouseY <= move.getY() + move.getHeight()) {
            selectedBlock = move;
        } else if (mouseX >= turn.getX() && mouseX <= turn.getX() + turn.getWidth() &&
                   mouseY >= turn.getY() && mouseY <= turn.getY() + turn.getHeight()) {
            selectedBlock = turn;
        } else if (mouseX >= paint.getX() && mouseX <= paint.getX() + paint.getWidth() &&
                   mouseY >= paint.getY() && mouseY <= paint.getY() + paint.getHeight()) {
            selectedBlock = paint;
        } else {
            selectedBlock = null;
        }

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
