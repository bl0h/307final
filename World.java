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
        this.cellSize = 50;
        this.grid = new Cell[numRows][numCols];
    
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = new Cell(row, col, Color.BLACK);
                grid[row][col] = cell;
                cells.add(cell);
            }
        }
    }


    public void draw(Graphics g) {
        for (Cell cell : cells) {
            cell.draw(g, cellSize);
        }
    }

}

    



