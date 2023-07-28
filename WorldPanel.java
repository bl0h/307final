import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
public class WorldPanel extends JPanel{
    private World w;

    public WorldPanel(int numRows, int numCols){
        this.w = new World(numRows,numCols);
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        w.draw(g);
        int cellSize = 80;
        int gridWidth = w.getNumCols() * cellSize;
        int gridHeight = w.getNumRows() * cellSize;
        setPreferredSize(new Dimension(gridWidth, gridHeight));
        revalidate();
    }

    public void applySpiderCommands(){
        w.applySpiderCommands();
    }

    public void clearProgram(){
        w.clearProgram();
    }

    public void resetCellList(){
        w.resetCellList();
    }

    public void changeLevel(int level) {
        int matrixSize = 5;
        if(level >= 1 && level <= 6) {
            matrixSize = 5;
        } 
        else if(level == 7 || level == 8 || level == 10) {
            Random random = new Random();
            matrixSize = random.nextInt(5) + 3;
            this.w.setSpiderPosition(0, 0);
            this.w.setSpiderDirection("east");
        }
        else if(level == 9) {
            Random random = new Random();
            matrixSize = random.nextInt(5) + 3;
            this.w.setSpiderPosition(0, 0);
            this.w.setSpiderDirection("south");
        }

        this.w.setSpiderCols(matrixSize);
        this.w.setSpiderRows(matrixSize);
        this.w.setMatrixSize(matrixSize, matrixSize);
        w.changeLevel(level);
        repaint();
    }

    public void nextLevel(){
        w.changeLevel(w.getLevel() + 1);
        repaint();
    }

    public boolean grade(){
        return w.grade();
    }

}
