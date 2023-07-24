import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class World{
    private int numRows;
    private int numCols;
    private int cellSize;
    private Spider spider;
    private int level;
    private ProblemHelper problemHelper;

    public World(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cellSize = 80;
        this.spider = new Spider();
        this.problemHelper = new ProblemHelper(this.spider);
        this.level = 1;
    
        Datasource d = Datasource.getInstance();
        d.setCellList(problemHelper.getLevel(this.level)); //getLevel0 returns level 0's cell list;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void applySpiderCommands() {
        Datasource d = Datasource.getInstance();
        LinkedList<Block> program = d.getProgram();        

        for(Block block : program) {
            String blockName = block.getText();

            if(blockName.equals("move")) {
                System.out.println("Spider should move");
                spider.move();
            }
            else if(blockName.equals("turn")) {
                spider.turn();
            }
            else if(blockName.equals("paint")) {
                paintCell(Color.RED);
            }
        }

        // Use for running program blocks one at a time without executing run button

        // if (!program.isEmpty()) {
        //     Block lastBlock = program.getLast();
        //     String blockName = lastBlock.getText();
        //     if (blockName.equals("move")) {
        //         System.out.println("Spider should move");
        //         spider.move();
        //     } else if (blockName.equals("turn")) {
        //         spider.turn();
        //     } else if (blockName.equals("paint")) {
        //         paintCell(Color.RED);
        //     }
        //     program.clear();
        // }    
    }

    public void clearProgram() {
        Datasource d = Datasource.getInstance();
        d.clearProgram();  
    }

    public void resetCellList() {
        LinkedList<Cell> levelCells = problemHelper.getLevel(this.level);
        Datasource d = Datasource.getInstance();
        d.setCellList(levelCells);
    }

    
    public void draw(Graphics g) {
        Datasource d = Datasource.getInstance();
        int gridWidth = numCols * cellSize;
        int gridHeight = numRows * cellSize;

        for (Cell cell : d.getCellList()) {
            cell.draw(g, cellSize);
            if (cell.hasSpider()){
                spider.draw(g);
            }
        }

        g.setColor(Color.GRAY);
        for (int row = 0; row <= numRows; row++) {
            int y = row * cellSize;
            g.drawLine(0, y, gridWidth, y);
        }
        for (int col = 0; col <= numCols; col++) {
            int x = col * cellSize;
            g.drawLine(x, 0, x, gridHeight);
        }
    }

    public void paintCell(Color color){
        int index = this.spider.getCellId();
        Datasource d = Datasource.getInstance();
        LinkedList<Cell> cellList = d.getCellList();
        Cell c = cellList.get(index);
        c.setColor(color);
    }
    

}

    



