import java.awt.Color;

public class Cell {
    private int row;
    private int col;
    private Color color;
    private boolean hasDiamond;
    private boolean hasSpider;

    public Cell(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.hasDiamond = false;
        this.hasSpider = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean hasDiamond() {
        return hasDiamond;
    }

    public void setHasDiamond(boolean hasDiamond) {
        this.hasDiamond = hasDiamond;
    }

    public boolean hasSpider() {
        return hasSpider;
    }

    public void setHasSpider(boolean hasSpider) {
        this.hasSpider = hasSpider;
    }

    public Color getColor() {
        return color;
    }

}

