import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.LinkedList;

public class World extends JPanel{
    private int numRows;
    private int numCols;
    private LinkedList<Cell> cells;
    private int cellSize;

    public Cell getCell(int row, int col) {
        for (Cell cell : cells) {
            if (cell.getRow() == row && cell.getCol() == col) {
                return cell;
            }
        }
        return null;
    }
    
}


