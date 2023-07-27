import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{

    private int x, y, x2, y2;
    private Rectangle rect = new Rectangle(25, 620, 50, 60);
    private boolean isBlockSelected;

    WorldPanel worldPanel;
    Block move = new Block("move", 600, 70);
	Block turn = new Block("turn", 600, 140);
	Block paintRed = new Block("paint red", 600, 210);
    Block paintGreen = new Block("paint green", 600, 280);
    Block paintBlue = new Block("paint blue", 600, 350);
    Block repeat = new Block("loop until wall", 600, 420);
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
		paintRed.draw(g);
        paintGreen.draw(g);
        paintBlue.draw(g);
        repeat.draw(g);

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

        if(x > move.getX() && x < move.getX()+95 && y > move.getY() && y < move.getY()+35){
            blockName = "move";
            isBlockSelected = true;   
        }
        if(x > turn.getX() && x < turn.getX()+95 && y > turn.getY() && y < turn.getX()+35){
            blockName = "turn";
            isBlockSelected = true;  
        }
        if(x > paintRed.getX() && x < paintRed.getX()+95 && y > paintRed.getY() && y < paintRed.getX()+35){
            blockName = "paint red";
            isBlockSelected = true;
        }
        if(x > paintGreen.getX() && x < paintGreen.getX()+95 && y > paintGreen.getY() && y < paintGreen.getX()+35){
            blockName = "paint green";
            isBlockSelected = true;
        }
        if(x > paintBlue.getX() && x < paintBlue.getX()+95 && y > paintBlue.getY() && y < paintBlue.getX()+35){
            blockName = "paint blue";
            isBlockSelected = true;
        }
        if(x > repeat.getX() && x < repeat.getX()+95 && y > repeat.getY() && y < repeat.getX()+35){
            blockName = "loop until wall";
            isBlockSelected = true;
        }


        for(Block block: d.getProgram()){
                if(block.contains(x,y)){
                    selectedBlock = block;
                    break;
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
            if(isBlockSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                d.addBlock(addedBlock);
                isBlockSelected = false;
                worldPanel.repaint();
            }

            if(rect.contains(x2,y2) && selectedBlock !=null){
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
