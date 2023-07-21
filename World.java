import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class World extends JPanel{
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

    public void setupLevel(int level) {
        clearDiamonds();
        switch(level) {
            case 1:
                level1();
        }        
    }

    private void level1() {
        int[][] diamondInfo = {
            {2, 3, Color.RED.getRGB()}, 
            {0, 1, Color.GREEN.getRGB()},
            {4, 4, Color.BLUE.getRGB()}
        };
    
        for (int[] info : diamondInfo) {
            int row = info[0];
            int col = info[1];
            int colorRGB = info[2];
            Cell cell = getCell(row, col);
            if (cell != null) {
                cell.setDiamond(true, new Color(colorRGB));
            }
        }
    }

    private void clearDiamonds() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.setHasDiamond(false);
            }
        }
    }

    public void drawDiamonds(Graphics g) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Cell cell = grid[row][col];
                if (cell.hasDiamond()) {
                    int x = col * cellSize;
                    int y = row * cellSize;
                    int halfCellSize = cellSize / 2;

                    g.setColor(cell.getDiamondColor()); // Set the color to the stored diamond color

                    // Draw the diamond shape
                    int[] xPoints = {x, x + halfCellSize, x + cellSize, x + halfCellSize};
                    int[] yPoints = {y + halfCellSize, y, y + halfCellSize, y + cellSize};
                    g.fillPolygon(xPoints, yPoints, 4);
                }
            }
        }
    }

    public Cell getCell(int row, int col) {
        for (Cell cell : cells) {
            if (cell.getRow() == row && cell.getCol() == col) {
                return cell;
            }
        }
        return null;
    }
    
    public void setSpider(int row, int col) {
        Cell cell = getCell(row, col);
        if (cell != null) {
            cell.setSpider();
        } 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDiamonds(g);

    }
}


