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
        this.spider = new Spider(30, 30, "north");
        this.problemHelper = new ProblemHelper(this.spider);
        this.level = 1;
    
        // for (int row = 0; row < numRows; row++) {
        //     for (int col = 0; col < numCols; col++) {
        //         Cell cell = new Cell(row, col, Color.BLACK);
        //         grid[row][col] = cell;
        //         cells.add(cell);
        //     }
        // }
        Datasource d = Datasource.getInstance();
        d.setCellList(problemHelper.getLevel1()); //getLevel0 returns level 0's cell list;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
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

    



