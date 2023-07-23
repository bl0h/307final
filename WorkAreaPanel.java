import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class WorkAreaPanel extends JPanel implements MouseListener, MouseMotionListener{
    
    World world;
    WorldPanel worldPanel;

    Block move = new Block("move", 600, 100);
	Block turn = new Block("turn", 600, 200);
	Block paint = new Block("paint", 600, 300);

    private int x, y, x2, y2;
    String blockName = "";
    private boolean moveSelected, turnSelected, paintSelected;


    public WorkAreaPanel(World world, WorldPanel worldPanel){
            addMouseListener(this);
            addMouseMotionListener(this);
            this.world = world;
            this.worldPanel = worldPanel;


            //String[] colors = {"Red", "Green", "Blue"};
            //JComboBox list = new JComboBox(colors);
            //add(list);
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

        Datasource d = Datasource.getInstance();
        for (Block b: d.getProgram()){
            b.draw(g);
        }
    }


    @Override
	public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();  

        if(x > 600 && x<675 && y>100 && y<125){
            System.out.println("inside move");
            blockName = "move";
            moveSelected = true;
        }
         if(x > 600 && x<675 && y>200 && y<225){
             System.out.println("inside turn");
             blockName = "turn";
             turnSelected = true;
        }
         if(x > 600 && x<675 && y>300 && y<325){
             System.out.println("inside paint");
              blockName = "paint";
              paintSelected = true;
        }
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();

        if(x2 < 500){
            if(moveSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                Datasource d = Datasource.getInstance();
                d.addBlock(addedBlock);
                moveSelected = false;
                world.applySpiderCommands();
                worldPanel.repaint();
            }
            if(turnSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                Datasource d = Datasource.getInstance();
                d.addBlock(addedBlock);
                turnSelected = false;
                world.applySpiderCommands();
                worldPanel.repaint();
            }
            if(paintSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                Datasource d = Datasource.getInstance();
                d.addBlock(addedBlock);
                paintSelected = false;
                world.applySpiderCommands();
                worldPanel.repaint();
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
