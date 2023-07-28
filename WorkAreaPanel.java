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
    private boolean isLoopSelected;
    

    WorldPanel worldPanel;
    Block move = new Block("move", 600, 70);
	Block turn = new Block("turn", 600, 140);
	Block paintRed = new Block("paint red", 600, 210);
    Block paintGreen = new Block("paint green", 600, 280);
    Block paintBlue = new Block("paint blue", 600, 350);
    Loop repeat = new Loop( 600, 420,"loop until wall");
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
            selectedBlock = move;
        }
        else if(x > turn.getX() && x < turn.getX()+95 && y > turn.getY() && y < turn.getY()+35){
            blockName = "turn";
            isBlockSelected = true;
            selectedBlock = turn;  
        }
        else if(x > paintRed.getX() && x < paintRed.getX()+95 && y > paintRed.getY() && y < paintRed.getY()+35){
            blockName = "paint red";
            isBlockSelected = true;
            selectedBlock = paintRed;
        }
        else if(x > paintGreen.getX() && x < paintGreen.getX()+95 && y > paintGreen.getY() && y < paintGreen.getY()+35){
            blockName = "paint green";
            isBlockSelected = true;
            selectedBlock = paintGreen;
        }
        else if(x > paintBlue.getX() && x < paintBlue.getX()+95 && y > paintBlue.getY() && y < paintBlue.getY()+35){
            blockName = "paint blue";
            isBlockSelected = true;
            selectedBlock = paintBlue;
        }
        else if(x > repeat.getX() && x < repeat.getX()+95 && y > repeat.getY() && y < repeat.getY()+35){
            blockName = "loop until wall";
            isLoopSelected = true;
            selectedBlock = repeat;
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
        int added = 0;
        Datasource d = Datasource.getInstance();

        if(x2 < 500){

            if(isLoopSelected){
                System.out.println("creating loop");
                Loop addedLoop = new Loop(x2, y2, blockName);
                d.addBlock(addedLoop);
                isLoopSelected = false;
            }

            else if(isBlockSelected){
                Block addedBlock = new Block(blockName, x2, y2);
                System.out.println("creating block");

                for (Block block : d.getProgram()) {
                    if(block instanceof Loop){
                        Loop l = (Loop)block;
                        if(l.contains(x2,y2)){
                            l.addBlock(addedBlock);
                            added = 1;
                            break;
                        }
                    }
                }
                if(added == 0){
                    d.addBlock(addedBlock);
                }
                isBlockSelected = false;
            }


            else if(rect.contains(x2,y2) && selectedBlock !=null){
                d.removeBlock(selectedBlock);
            }

            

        }
        worldPanel.repaint();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
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
