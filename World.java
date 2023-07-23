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

    public void draw(Graphics g) {
        Datasource d = Datasource.getInstance();
        this.cells = d.getCellList();
        for (Cell cell : this.cells) {
            cell.draw(g, cellSize);
        }
    }


}

    



