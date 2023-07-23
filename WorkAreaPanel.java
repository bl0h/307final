import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{
    
    Block move = new Block("move", 600, 100);
	Block turn = new Block("turn", 600, 200);
	Block paint = new Block("paint", 600, 300);

    private int x, y, x2, y2;
    String blockName = "";
    private boolean blockSelected;


    public WorkAreaPanel(){
            addMouseListener(this);
            addMouseMotionListener(this);
        }


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
        x = e.getX();
        y = e.getY();

        System.out.println("MouseX"+ x);
        System.out.println("MouseY"+ y);

        if(x > 600 && x<675 && y>100 && y<125){
            System.out.println("inside move");
            blockName = "move";
            blockSelected = true;

        }
        if(x > 600 && x<675 && y>200 && y<225){
            System.out.println("inside turn");
            blockName = "turn";
            blockSelected = true;

        }

        if(x > 600 && x<675 && y>300 && y<325){
            System.out.println("inside paint");
             blockName = "paint";
             blockSelected = true;

        }


	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();

        System.out.println("MouseX"+ x2);
        System.out.println("MouseY"+ y2);

        if(x2 < 500){
            if(blockSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                Datasource d = Datasource.getInstance();
                d.addBlock(addedBlock);
                blockSelected = false;
            }
        }
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();

        System.out.println("MouseX"+ x2);
        System.out.println("MouseY"+ y2);

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
