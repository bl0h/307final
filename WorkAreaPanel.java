import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{

    private int x, y, x2, y2;
    private Rectangle rect = new Rectangle(25, 620, 50, 60);
    private boolean moveSelected, turnSelected, paintSelected;

    WorldPanel worldPanel;
    Block move = new Block("move", 600, 100);
	Block turn = new Block("turn", 600, 200);
	Block paint = new Block("paint", 600, 300);
    Block selectedBlock = null;
    String blockName = "";


    public WorkAreaPanel(WorldPanel worldPanel){
        addMouseListener(this);
        addMouseMotionListener(this);
        this.worldPanel = worldPanel;

    }


    @Override
    public void paintComponent(Graphics g){
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 700));
        setBorder(new LineBorder(Color.BLACK,1));
        super.paintComponent(g);

        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(550, 0, 250, 700);

        g.setColor(Color.GRAY);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);

        g.setColor(Color.BLACK);
        g.fillOval(25,610,50,20);

        move.draw(g);
		turn.draw(g);
		paint.draw(g);

        Datasource d = Datasource.getInstance();
        for (Block b: d.getProgram()){
            b.draw(g);
        }
    }


    @Override
	public void mousePressed(MouseEvent e) {
        Datasource d = Datasource.getInstance();
        x = e.getX();
        y = e.getY();  

        if(x > move.getX() && x < move.getX()+75 && y > move.getY() && y < move.getY()+25){
            blockName = "move";
            moveSelected = true;
            
        }
        if(x > turn.getX() && x < turn.getX()+75 && y > turn.getY() && y < turn.getX()+25){
            blockName = "turn";
            turnSelected = true;
           
        }
        if(x > paint.getX() && x < paint.getX()+75 && y > paint.getY() && y < paint.getX()+25){
            blockName = "paint";
            paintSelected = true;
        }

        for(Block block: d.getProgram()){
                if(block.contains(x,y)){
                    System.out.println("shit");
                    selectedBlock = block;
                }
                else 
                    selectedBlock = null;
            }
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();

        Datasource d = Datasource.getInstance();

        if(x2 < 500){
            if(moveSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                d.addBlock(addedBlock);
                moveSelected = false;
                worldPanel.repaint();
            }
            if(turnSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                d.addBlock(addedBlock);
                turnSelected = false;
                worldPanel.repaint();
            }
            if(paintSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                d.addBlock(addedBlock);
                paintSelected = false;
                worldPanel.repaint();
            }
            if(rect.contains(x2,y2) && selectedBlock !=null){
                System.out.println("yes");
                d.removeBlock(selectedBlock);
            }
        }
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();
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
