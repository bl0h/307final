import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class World{
    private int numRows;
    private int numCols;
    private LinkedList<Cell> cells;
    private int cellSize;
    private Cell[][] grid;

    public World(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cells = new LinkedList<>();
        this.cellSize = 80;
        this.grid = new Cell[numRows][numCols];
    
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = new Cell(row, col, Color.BLACK);
                grid[row][col] = cell;
                cells.add(cell);
            }
        }
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void drawSpider(Graphics g) {
        Spider spider = new Spider(2, 3, "north");
        spider.draw(g);
    }

    public void draw(Graphics g) {
        Datasource d = Datasource.getInstance();
        this.cells = d.getCellList();
        int gridWidth = numCols * cellSize;
        int gridHeight = numRows * cellSize;

        for (Cell cell : this.cells) {
            cell.draw(g, cellSize);
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
        drawSpider(g);
    }


}

    



